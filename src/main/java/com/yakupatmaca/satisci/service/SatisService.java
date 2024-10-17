package com.yakupatmaca.satisci.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yakupatmaca.satisci.dto.SatisDTO;
import com.yakupatmaca.satisci.entity.Musteri;
import com.yakupatmaca.satisci.entity.Satis;
import com.yakupatmaca.satisci.entity.Urun;
import com.yakupatmaca.satisci.repository.MusteriRepository;
import com.yakupatmaca.satisci.repository.SatisRepository;
import com.yakupatmaca.satisci.repository.UrunRepository;

import jakarta.persistence.EntityNotFoundException;

public class SatisService {
	@Autowired
	private SatisRepository satisRepository;

	@Autowired
	private UrunRepository urunRepository;

	@Autowired
	private MusteriRepository musteriRepository;

	public SatisDTO save(SatisDTO satisDTO) {
		Satis satis = new Satis();
		BeanUtils.copyProperties(satisDTO, satis);

		// Eğer ürün veya müşteri ilişkileri yeni ise, ilgili entity'leri de kaydet
		if (satis.getUrun().getId() == null) {
			urunRepository.save(satis.getUrun());
		}
		if (satis.getMusteri().getId() == null) {
			musteriRepository.save(satis.getMusteri());
		}

		satis = satisRepository.save(satis);
		return convertToDTO(satis);
	}

	public List<SatisDTO> getAllSatislar() {
		List<Satis> satislar = satisRepository.findAll();
		return satislar.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public Optional<SatisDTO> getSatisById(Long id) {
		Optional<Satis> satis = satisRepository.findById(id);
		return satis.map(this::convertToDTO);
	}

	public SatisDTO updateSatis(Long id, SatisDTO satisDTO) {
		Optional<Satis> existingSatis = satisRepository.findById(id);
		if (existingSatis.isPresent()) {
			Satis satis = existingSatis.get();
			BeanUtils.copyProperties(satisDTO, satis, "id"); // id'yi güncellemeyecek
			return convertToDTO(satisRepository.save(satis));
		} else {
			throw new EntityNotFoundException("Satış bilgisi bulunamadı");
		}
	}

	public void deleteSatis(Long id) {
		satisRepository.deleteById(id);
	}

	public List<SatisDTO> getSatislarByMusteri(Musteri musteri) {
		return satisRepository.findByMusteri(musteri).stream().collect(Collectors.toList());
	}

	public List<SatisDTO> getSatislarByUrun(Urun urun) {
		return satisRepository.findByUrun(urun).stream().collect(Collectors.toList());
	}

	public List<SatisDTO> getSatislarByTarihAraligi(LocalDateTime baslangicTarihi, LocalDateTime bitisTarihi) {
		return satisRepository.findBySatisTarihiBetween(baslangicTarihi, bitisTarihi).stream()
				.collect(Collectors.toList());
	}

	private SatisDTO convertToDTO(Satis satis) {
		SatisDTO satisDTO = new SatisDTO();
		BeanUtils.copyProperties(satis, satisDTO);
		return satisDTO;
	}

}
