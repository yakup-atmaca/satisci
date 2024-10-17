package com.yakupatmaca.satisci.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yakupatmaca.satisci.dto.KullaniciDTO;
import com.yakupatmaca.satisci.entity.Kullanici;
import com.yakupatmaca.satisci.repository.KullaniciRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class KullaniciService {

	@Autowired
	private KullaniciRepository kullaniciRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Yeni bir kullanıcı kaydetme
	public KullaniciDTO kaydet(KullaniciDTO kullaniciDTO) {
		Kullanici kullanici = new Kullanici();
		kullanici = convertToEntity(kullaniciDTO);
		kullanici = kullaniciRepository.save(kullanici);
		return convertToDto(kullanici);
	}

	// Tüm kullanıcıları listeleme
	public List<KullaniciDTO> tumKullanicilariGetir() {
		return kullaniciRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// ID'ye göre kullanıcı bulma
	public Optional<KullaniciDTO> kullaniciBul(Long id) {
		return kullaniciRepository.findById(id).map(this::convertToDto);
	}

	// E-posta adresine göre kullanıcı bulma
	public Optional<KullaniciDTO> kullaniciBul(String eposta) {
		Kullanici kullanici = kullaniciRepository.findByEposta(eposta);
		Optional<KullaniciDTO> kullaniciDTO = Optional.ofNullable(convertToDto(kullanici));
		return kullaniciDTO;
	}

	// Kullanıcı güncelleme
	public KullaniciDTO guncelle(Long id, KullaniciDTO guncellenecekKullanici) {
		return kullaniciRepository.findById(id).map(kullanici -> {
			convertToEntity(guncellenecekKullanici);
			return kullaniciRepository.save(kullanici);
		}).map(this::convertToDto).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
	}

	// Kullanıcı silme
	public void sil(Long id) {
		kullaniciRepository.deleteById(id);
	}

	// Entity'den DTO'ya dönüştürme metodu
	private KullaniciDTO convertToDto(Kullanici kullanici) {
		KullaniciDTO kullaniciDTO = new KullaniciDTO();
		kullaniciDTO.setId(kullanici.getId());
		kullaniciDTO.setAdi(kullanici.getAdi());
		kullaniciDTO.setSoyadi(kullanici.getSoyadi());
		// Diğer alanlar için benzer şekilde atama yap
		return kullaniciDTO;
	}

	// DTO'dan Entity'ye dönüştürme metodu
	private Kullanici convertToEntity(KullaniciDTO kullaniciDTO) {
		Kullanici kullanici = new Kullanici();
		kullanici.setAdi(kullaniciDTO.getAdi());
		kullanici.setSoyadi(kullaniciDTO.getSoyadi());
		// Diğer alanlar için benzer şekilde atama yap
		kullanici.setEposta(kullaniciDTO.getEposta());
		kullanici.setSifre(passwordEncoder.encode(kullaniciDTO.getSifre()));
		return kullanici;
	}
}