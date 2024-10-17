package com.yakupatmaca.satisci.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakupatmaca.satisci.dto.MusteriDTO;
import com.yakupatmaca.satisci.entity.Musteri;
import com.yakupatmaca.satisci.repository.MusteriRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MusteriService {

	@Autowired
	private MusteriRepository musteriRepository;


	// Yeni bir kullanıcı kaydetme
	public MusteriDTO kaydet(MusteriDTO musteriDTO) {
		Musteri musteri = new Musteri();
		musteri = convertToEntity(musteriDTO);
		musteri = musteriRepository.save(musteri);
		return convertToDto(musteri);
	}

	// Tüm kullanıcıları listeleme
	public List<MusteriDTO> tumMusterileriGetir() {
		return musteriRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// ID'ye göre kullanıcı bulma
	public Optional<MusteriDTO> musteriBul(Long id) {
		/*
		 * Optional<Musteri> musteri = musteriRepository.findById(id);
		 * Optional<MusteriDTO> musteriDTO = Optional.ofNullable(convertToDto(musteri));
		 * return musteriDTO;
		 */
		return musteriRepository.findById(id).map(this::convertToDto);
	}

	// Ada göre kullanıcı bulma
	public Optional<MusteriDTO> musteriBul(String adi) {
		Musteri musteri = (Musteri) musteriRepository.findByAdi(adi);
		Optional<MusteriDTO> musteriDTO = Optional.ofNullable(convertToDto(musteri));
		return musteriDTO;
	}

	// Müşteri güncelleme
	public MusteriDTO guncelle(Long id, MusteriDTO guncellenecekMusteri) {
		return musteriRepository.findById(id).map(musteri -> {
			convertToEntity(guncellenecekMusteri);
			return musteriRepository.save(musteri);
		}).map(this::convertToDto).orElseThrow(() -> new EntityNotFoundException("Müşteri bulunamadı"));
	}

	// Müşteri silme
	public void sil(Long id) {
		musteriRepository.deleteById(id);
	}

	// Entity'den DTO'ya dönüştürme metodu
	private MusteriDTO convertToDto(Musteri musteri) {
		MusteriDTO musteriDTO = new MusteriDTO();
		musteriDTO.setId(musteri.getId());
		musteriDTO.setAdi(musteri.getAdi());
		musteriDTO.setSoyadi(musteri.getSoyadi());
		// Diğer alanlar için benzer şekilde atama yap
		return musteriDTO;
	}
	
	// Entity'den DTO'ya dönüştürme metodu
	/*
	 * private MusteriDTO convertToDto(Optional<Musteri> musteri) { MusteriDTO
	 * musteriDTO = new MusteriDTO(); musteriDTO.setId(musteri.get().getId());
	 * musteriDTO.setAdi(musteri.get().getAdi());
	 * musteriDTO.setSoyadi(musteri.get().getSoyadi()); // Diğer alanlar için benzer
	 * şekilde atama yap return musteriDTO; }
	 */

	// DTO'dan Entity'ye dönüştürme metodu
	private Musteri convertToEntity(MusteriDTO musteriDTO) {
		Musteri musteri = new Musteri();
		musteri.setAdi(musteriDTO.getAdi());
		musteri.setSoyadi(musteriDTO.getSoyadi());
		// Diğer alanlar için benzer şekilde atama yap
		
		return musteri;
	}
}