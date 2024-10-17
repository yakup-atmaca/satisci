package com.yakupatmaca.satisci.dto;

import java.time.LocalDateTime;

public class SatisDTO {

	private Long id;
	private Long urunId;
	private Long musteriId;
	private LocalDateTime satisTarihi;
	private Integer adet;
	private String aciklama;

	public SatisDTO() {
	}

	public SatisDTO(Long id, Long urunId, Long musteriId, LocalDateTime satisTarihi, Integer adet, String aciklama) {
		super();
		this.id = id;
		this.urunId = urunId;
		this.musteriId = musteriId;
		this.satisTarihi = satisTarihi;
		this.adet = adet;
		this.aciklama = aciklama;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUrunId() {
		return urunId;
	}

	public void setUrunId(Long urunId) {
		this.urunId = urunId;
	}

	public Long getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(Long musteriId) {
		this.musteriId = musteriId;
	}

	public LocalDateTime getSatisTarihi() {
		return satisTarihi;
	}

	public void setSatisTarihi(LocalDateTime satisTarihi) {
		this.satisTarihi = satisTarihi;
	}

	public Integer getAdet() {
		return adet;
	}

	public void setAdet(Integer adet) {
		this.adet = adet;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
}
