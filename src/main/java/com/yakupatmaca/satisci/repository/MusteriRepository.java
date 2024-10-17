package com.yakupatmaca.satisci.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yakupatmaca.satisci.entity.Musteri;

public interface MusteriRepository extends JpaRepository<Musteri, Long> {

	List<Musteri> findByAdi(String adi);
	Optional<Musteri> findById(Long id);

}
