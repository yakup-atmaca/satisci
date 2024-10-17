package com.yakupatmaca.satisci.dto;

public class KullaniciDTO {
	private Long id;
	private String adi;
	private String soyadi;
	private String eposta;
	private String sifre;
	private String rol;

	public KullaniciDTO() {
	}

	public KullaniciDTO(Long id, String adi, String soyadi, String eposta, String sifre, String rol) {
		this.id = id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.eposta = eposta;
		this.sifre = sifre;
		this.rol = rol;
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

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
