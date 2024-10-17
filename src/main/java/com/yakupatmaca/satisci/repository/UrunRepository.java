package com.yakupatmaca.satisci.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yakupatmaca.satisci.entity.Urun;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {
    
    // Ürün adıyla arama yapar
    List<Urun> findByAdi(String adi);
    
    // Ücret aralığında ürünleri getirir
    List<Urun> findByUcretBetween(Double minUcret, Double maxUcret);
    
    // Açıklama içeren ürünleri getirir
    List<Urun> findByAciklamaContaining(String keyword);
}