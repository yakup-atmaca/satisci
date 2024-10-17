package com.yakupatmaca.satisci.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yakupatmaca.satisci.dto.SatisDTO;
import com.yakupatmaca.satisci.entity.Musteri;
import com.yakupatmaca.satisci.entity.Satis;
import com.yakupatmaca.satisci.entity.Urun;

public interface SatisRepository extends JpaRepository<Satis, Long> {

	List<Satis> findByUrunAdi(String urunAdi);
	List<Satis> findByUrunTuruAdi(String urunTuruAdi);
	List<Satis> findByMusteriAdi(String musteriAdi);
	Collection<SatisDTO> findByMusteri(Musteri musteri);
	Collection<SatisDTO> findByUrun(Urun urun);
	Collection<SatisDTO> findBySatisTarihiBetween(LocalDateTime baslangicTarihi, LocalDateTime bitisTarihi);

}
