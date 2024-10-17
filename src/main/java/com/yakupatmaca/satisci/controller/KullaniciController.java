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

import com.yakupatmaca.satisci.dto.KullaniciDTO;
import com.yakupatmaca.satisci.service.KullaniciService;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController {

	@Autowired
	private KullaniciService kullaniciService;

	// Tüm ürünleri dönen endpoint
	@GetMapping
	public ResponseEntity<List<KullaniciDTO>> tumKullanicileriGetir() {
		List<KullaniciDTO> kullanicilar = kullaniciService.tumKullanicilariGetir();
		return ResponseEntity.ok(kullanicilar);
	}

	// Yeni ürün oluşturma endpoint'i
	@PostMapping
	public ResponseEntity<KullaniciDTO> kullaniciKaydet(@RequestBody KullaniciDTO kullaniciDTO) {
		KullaniciDTO kaydedilenKullanici = kullaniciService.kaydet(kullaniciDTO);
		return ResponseEntity.ok(kaydedilenKullanici);
	}

	@GetMapping("/{id}")
	public ResponseEntity<KullaniciDTO> kullaniciGetirById(@PathVariable Long id) {
		KullaniciDTO kullaniciDTO = kullaniciService.kullaniciBul(id).get();
		return ResponseEntity.ok(kullaniciDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> kullaniciSil(@PathVariable Long id) {
		kullaniciService.sil(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<KullaniciDTO> kullaniciGuncelle(@PathVariable Long id, @RequestBody KullaniciDTO kullaniciDTO) {
		KullaniciDTO guncellenenKullanici = null;
		try {
			guncellenenKullanici = kullaniciService.guncelle(id, kullaniciDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(guncellenenKullanici);
	}

}
