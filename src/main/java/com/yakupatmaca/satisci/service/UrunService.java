package com.yakupatmaca.satisci.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakupatmaca.satisci.dto.UrunDTO;
import com.yakupatmaca.satisci.entity.Urun;
import com.yakupatmaca.satisci.repository.UrunRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UrunService {

	@Autowired
	private UrunRepository urunRepository;

	// Urun entity'sini UrunDTO'ya dönüştüren yardımcı metot
	private UrunDTO convertToDto(Urun urun) {
		return new UrunDTO(urun.getId(), urun.getAdi(), urun.getUcret(), urun.getAciklama());
	}

	// DTO'dan entity'ye dönüşüm metodu
	private Urun convertToEntity(UrunDTO urunDTO) {
		Urun urun = new Urun();
		urun.setId(urunDTO.getId());
		urun.setAdi(urunDTO.getAdi());
		urun.setUcret(urunDTO.getUcret());
		urun.setAciklama(urunDTO.getAciklama());
		return urun;
	}

	// Tüm Urun entity'lerini DTO listesine dönüştürür
	public List<UrunDTO> tumUrunleriGetir() {
		return urunRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// Bir Urun entity'sini DTO'ya dönüştürür
	public UrunDTO urunGetirById(Long id) {
		Optional<Urun> urunOptional = urunRepository.findById(id);
		return urunOptional.map(this::convertToDto).orElse(null);
	}

	// Yeni bir ürün oluşturur
	public UrunDTO urunKaydet(UrunDTO urunDTO) {
		Urun urun = convertToEntity(urunDTO);
		Urun kaydedilenUrun = urunRepository.save(urun);
		return new UrunDTO(kaydedilenUrun.getId(), kaydedilenUrun.getAdi(), kaydedilenUrun.getUcret(),
				kaydedilenUrun.getAciklama());
	}

	// Var olan ürünü gunceller
	public UrunDTO urunGuncelle(UrunDTO urunDTO) {
		Urun urun = convertToEntity(urunDTO);
		Urun kaydedilenUrun = urunRepository.save(urun);
		return new UrunDTO(kaydedilenUrun.getId(), kaydedilenUrun.getAdi(), kaydedilenUrun.getUcret(),
				kaydedilenUrun.getAciklama());
	}
	
	public UrunDTO urunGuncelle(Long id, UrunDTO urunDTO) {
		Optional<Urun> urunOptional = urunRepository.findById(id);
        if (urunOptional.isPresent()) {
            Urun urun = urunOptional.get();
            urun = convertToEntity(urunDTO);
            //urun.setId(id);
            urunRepository.save(urun);
            return convertToDto(urun);
        } else {
            throw new EntityNotFoundException("Ürün bulunamadı");
        }
    }

	// Ürünü siler
	public void urunSil(Long id) {
		urunRepository.deleteById(id);
	}

}
