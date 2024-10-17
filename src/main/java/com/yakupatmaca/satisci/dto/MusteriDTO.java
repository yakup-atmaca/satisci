package com.yakupatmaca.satisci.dto;

public class MusteriDTO {

	private Long id;
	private String adi;
	private String soyadi;
	private String telefon;
	private String aciklama;

	public MusteriDTO() {
	}

	public MusteriDTO(Long id, String adi, String soyadi, String telefon, String aciklama) {

		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.telefon = telefon;
		this.aciklama = aciklama;
	}

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

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
}
