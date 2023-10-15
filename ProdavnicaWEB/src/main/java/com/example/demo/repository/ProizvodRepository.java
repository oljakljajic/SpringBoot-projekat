package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Kategorija;
import model.Proizvod;

public interface ProizvodRepository extends JpaRepository<Proizvod, Integer>{
	
	List<Proizvod> findByKategorija(Kategorija k);
	
	
	@Query("select p from Proizvod p order by p.cenaP desc")
	List<Proizvod> sortirajPoCeni();
	
	@Query("select p from Proizvod p where p.kategorija.naziv =:naziv and p.cenaP <=:cenaP")
	List<Proizvod> filtriranje(@Param("naziv")String naziv, @Param("cenaP")Integer cenaP);
	
	List<Proizvod> findByCenaPLessThan(Integer cenaP);

}
