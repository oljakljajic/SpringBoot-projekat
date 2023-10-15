package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Kategorija;
import model.Proizvod;

public interface KategorijaRepository extends JpaRepository<Kategorija, Integer>{
	
	

}
