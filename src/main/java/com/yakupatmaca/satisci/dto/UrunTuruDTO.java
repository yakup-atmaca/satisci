package com.yakupatmaca.satisci.dto;

public class UrunTuruDTO {
	private Long id;
    private String adi;       
    
	public UrunTuruDTO() {		
	}

	public UrunTuruDTO(Long id, String adi) {
		this.id = id;
		this.adi = adi;
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
}
