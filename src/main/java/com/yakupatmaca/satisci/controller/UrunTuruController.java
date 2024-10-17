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

import com.yakupatmaca.satisci.dto.UrunTuruDTO;
import com.yakupatmaca.satisci.service.UrunTuruService;

@RestController
@RequestMapping("/api/urunturleri")
public class UrunTuruController {

	@Autowired
	private UrunTuruService urunTuruService;

	@GetMapping
	public ResponseEntity<List<UrunTuruDTO>> tumUrunTuruleriGetir() {
		List<UrunTuruDTO> urunTuruler = urunTuruService.tumUrunTuruleriGetir();
		return ResponseEntity.ok(urunTuruler);
	}

	@PostMapping
	public ResponseEntity<UrunTuruDTO> urunTuruKaydet(@RequestBody UrunTuruDTO urunTuruDTO) {
		UrunTuruDTO kaydedilenUrunTuru = urunTuruService.urunTuruKaydet(urunTuruDTO);
		return ResponseEntity.ok(kaydedilenUrunTuru);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UrunTuruDTO> urunTuruGetirById(@PathVariable Long id) {
		UrunTuruDTO urunTuruDTO = urunTuruService.urunTuruGetirById(id);
		return ResponseEntity.ok(urunTuruDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> urunTuruSil(@PathVariable Long id) {
		urunTuruService.urunTuruSil(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<UrunTuruDTO> urunTuruGuncelle(@PathVariable Long id, @RequestBody UrunTuruDTO urunTuruDTO) {
		UrunTuruDTO guncellenenUrunTuru = null;
		try {
			guncellenenUrunTuru = urunTuruService.urunTuruGuncelle(id, urunTuruDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(guncellenenUrunTuru);
	}

}
