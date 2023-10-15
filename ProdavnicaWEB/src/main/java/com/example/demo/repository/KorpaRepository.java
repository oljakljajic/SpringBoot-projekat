package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Korpa;

public interface KorpaRepository extends JpaRepository<Korpa, Integer>{
	
	@Query("select k from Korpa k where k.korisnik.idKorisnik =:idKorisnik")
	List<Korpa> vratiKorpu(@Param("idKorisnik")Integer idKorisnik);
	

}
