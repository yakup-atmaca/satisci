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

import com.yakupatmaca.satisci.dto.SatisDTO;
import com.yakupatmaca.satisci.service.SatisService;

@RestController
@RequestMapping("/api/satislar")
public class SatisController {

	@Autowired
	private SatisService satisService;

	// Tüm ürünleri dönen endpoint
	@GetMapping
	public ResponseEntity<List<SatisDTO>> tumSatislariGetir() {
		List<SatisDTO> satislar = satisService.getAllSatislar();
		return ResponseEntity.ok(satislar);
	}

	// Yeni ürün oluşturma endpoint'i
	@PostMapping
	public ResponseEntity<SatisDTO> satisKaydet(@RequestBody SatisDTO satisDTO) {
		SatisDTO kaydedilenSatis = satisService.save(satisDTO);
		return ResponseEntity.ok(kaydedilenSatis);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SatisDTO> satisGetirById(@PathVariable Long id) {
		SatisDTO satisDTO = satisService.getSatisById(id).get();
		return ResponseEntity.ok(satisDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> satisSil(@PathVariable Long id) {
		satisService.deleteSatis(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<SatisDTO> satisGuncelle(@PathVariable Long id, @RequestBody SatisDTO satisDTO) {
		SatisDTO guncellenenSatis = null;
		try {
			guncellenenSatis = satisService.updateSatis(id, satisDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(guncellenenSatis);
	}

}
