package com.yakupatmaca.satisci.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yakupatmaca.satisci.entity.UrunTuru;

public interface UrunTuruRepository extends JpaRepository<UrunTuru, Long> {

	List<UrunTuru> findByAdi(String adi);

}
