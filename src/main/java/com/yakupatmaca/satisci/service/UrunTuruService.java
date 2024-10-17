package com.yakupatmaca.satisci.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakupatmaca.satisci.dto.UrunTuruDTO;
import com.yakupatmaca.satisci.entity.UrunTuru;
import com.yakupatmaca.satisci.repository.UrunTuruRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UrunTuruService {

	@Autowired
	private UrunTuruRepository urunTuruRepository;

	// UrunTuru entity'sini UrunTuruDTO'ya dönüştüren yardımcı metot
	private UrunTuruDTO convertToDto(UrunTuru urunTuru) {
		return new UrunTuruDTO(urunTuru.getId(), urunTuru.getAdi());
	}

	// DTO'dan entity'ye dönüşüm metodu
	private UrunTuru convertToEntity(UrunTuruDTO urunTuruDTO) {
		UrunTuru urunTuru = new UrunTuru();
		urunTuru.setId(urunTuruDTO.getId());
		urunTuru.setAdi(urunTuruDTO.getAdi());		
		return urunTuru;
	}

	// Tüm UrunTuru entity'lerini DTO listesine dönüştürür
	public List<UrunTuruDTO> tumUrunTuruleriGetir() {
		return urunTuruRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// Bir UrunTuru entity'sini DTO'ya dönüştürür
	public UrunTuruDTO urunTuruGetirById(Long id) {
		Optional<UrunTuru> urunTuruOptional = urunTuruRepository.findById(id);
		return urunTuruOptional.map(this::convertToDto).orElse(null);
	}

	// Yeni bir ürün türü oluşturur
	public UrunTuruDTO urunTuruKaydet(UrunTuruDTO urunTuruDTO) {
		UrunTuru urunTuru = convertToEntity(urunTuruDTO);
		UrunTuru kaydedilenUrunTuru = urunTuruRepository.save(urunTuru);
		return new UrunTuruDTO(kaydedilenUrunTuru.getId(), kaydedilenUrunTuru.getAdi());
	}

	// Var olan ürün türünü gunceller
	public UrunTuruDTO urunTuruGuncelle(UrunTuruDTO urunTuruDTO) {
		UrunTuru urunTuru = convertToEntity(urunTuruDTO);
		UrunTuru kaydedilenUrunTuru = urunTuruRepository.save(urunTuru);
		return new UrunTuruDTO(kaydedilenUrunTuru.getId(), kaydedilenUrunTuru.getAdi());
	}
	
	public UrunTuruDTO urunTuruGuncelle(Long id, UrunTuruDTO urunTuruDTO) {
		Optional<UrunTuru> urunTuruOptional = urunTuruRepository.findById(id);
        if (urunTuruOptional.isPresent()) {
            UrunTuru urunTuru = urunTuruOptional.get();
            urunTuru = convertToEntity(urunTuruDTO);
            //urunTuru.setId(id);
            urunTuruRepository.save(urunTuru);
            return convertToDto(urunTuru);
        } else {
            throw new EntityNotFoundException("Ürün türü bulunamadı");
        }
    }

	// Ürünü siler
	public void urunTuruSil(Long id) {
		urunTuruRepository.deleteById(id);
	}

}
