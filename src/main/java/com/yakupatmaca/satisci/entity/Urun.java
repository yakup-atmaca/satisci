package com.yakupatmaca.satisci.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "urun")
public class Urun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String adi;
	private Double ucret;
	private String aciklama;
	private UrunTuru urunTuru;

	// Getter ve Setter metotları
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public Double getUcret() {
		return ucret;
	}

	public void setUcret(Double ucret) {
		this.ucret = ucret;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public UrunTuru getUrunTuru() {
		return urunTuru;
	}

	public void setUrunTuru(UrunTuru urunTuru) {
		this.urunTuru = urunTuru;
	}

}
