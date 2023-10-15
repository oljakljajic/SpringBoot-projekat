package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepositoryImplementation<Korisnik, Integer>{
	Korisnik findByUsername(String username);
}
