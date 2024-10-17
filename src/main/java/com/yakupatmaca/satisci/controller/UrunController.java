package com.yakupatmaca.satisci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakupatmaca.satisci.dto.UrunDTO;
import com.yakupatmaca.satisci.service.UrunService;

@RestController
@RequestMapping("/api/urunler")
public class UrunController {

	@Autowired
	private UrunService urunService;

	// Tüm ürünleri dönen endpoint
	@GetMapping
	public ResponseEntity<List<UrunDTO>> tumUrunleriGetir() {
		List<UrunDTO> urunler = urunService.tumUrunleriGetir();
		return ResponseEntity.ok(urunler);
	}

	// Yeni ürün oluşturma endpoint'i
	@PostMapping
	public ResponseEntity<UrunDTO> urunKaydet(@RequestBody UrunDTO urunDTO) {
		UrunDTO kaydedilenUrun = urunService.urunKaydet(urunDTO);
		return ResponseEntity.ok(kaydedilenUrun);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UrunDTO> urunGetirById(@PathVariable Long id) {
		UrunDTO urunDTO = urunService.urunGetirById(id);
		return ResponseEntity.ok(urunDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> urunSil(@PathVariable Long id) {
		urunService.urunSil(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<UrunDTO> urunGuncelle(@PathVariable Long id, @RequestBody UrunDTO urunDTO) {
		UrunDTO guncellenenUrun = null;
		try {
			guncellenenUrun = urunService.urunGuncelle(id, urunDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(guncellenenUrun);
	}

}
