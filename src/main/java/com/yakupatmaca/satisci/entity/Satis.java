package com.yakupatmaca.satisci.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "satis")
public class Satis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "urun_id", referencedColumnName = "id")
	private Urun urun;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "musteri_id", referencedColumnName = "id")
	private Musteri musteri;

	@Column(name = "satisTarihi")
	private LocalDateTime satisTarihi;

	@Column(name = "adet")
	private Integer adet;

	@Column(name = "aciklama")
	private String aciklama;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Urun getUrun() {
		return urun;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
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
