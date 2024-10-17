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

import com.yakupatmaca.satisci.dto.MusteriDTO;
import com.yakupatmaca.satisci.service.MusteriService;

@RestController
@RequestMapping("/api/musteriler")
public class MusteriController {

	@Autowired
	private MusteriService musteriService;

	// Tüm ürünleri dönen endpoint
	@GetMapping
	public ResponseEntity<List<MusteriDTO>> tumMusterileriGetir() {
		List<MusteriDTO> musteriler = musteriService.tumMusterileriGetir();
		return ResponseEntity.ok(musteriler);
	}

	// Yeni ürün oluşturma endpoint'i
	@PostMapping
	public ResponseEntity<MusteriDTO> musteriKaydet(@RequestBody MusteriDTO musteriDTO) {
		MusteriDTO kaydedilenMusteri = musteriService.kaydet(musteriDTO);
		return ResponseEntity.ok(kaydedilenMusteri);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MusteriDTO> musteriGetirById(@PathVariable Long id) {
		MusteriDTO musteriDTO = musteriService.musteriBul(id).get();
		return ResponseEntity.ok(musteriDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> musteriSil(@PathVariable Long id) {
		musteriService.sil(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<MusteriDTO> musteriGuncelle(@PathVariable Long id, @RequestBody MusteriDTO musteriDTO) {
		MusteriDTO guncellenenMusteri = null;
		try {
			guncellenenMusteri = musteriService.guncelle(id, musteriDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(guncellenenMusteri);
	}

}
