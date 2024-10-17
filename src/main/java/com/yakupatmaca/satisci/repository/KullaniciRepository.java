package com.yakupatmaca.satisci.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yakupatmaca.satisci.entity.Kullanici;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {

	List<Kullanici> findByAdi(String adi);

	Kullanici findByEposta(String eposta);

}
