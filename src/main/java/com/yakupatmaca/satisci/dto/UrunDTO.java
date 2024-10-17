package com.yakupatmaca.satisci.dto;

public class UrunDTO {

	private Long id;
    private String adi;
    private Double ucret;
    private String aciklama;

    // Constructor, getter ve setter metotları
    public UrunDTO() {}

    public UrunDTO(Long id, String adi, Double ucret, String aciklama) {
    	this.id = id;
        this.adi = adi;
        this.ucret = ucret;
        this.aciklama = aciklama;
    }
    
    public UrunDTO( String adi, Double ucret, String aciklama) {
        this.adi = adi;
        this.ucret = ucret;
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
}
