package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.ProizvodjacRepository;

import model.Proizvodjac;

public class ProizvodjacKonverter implements Converter<String, Proizvodjac>{
	
	ProizvodjacRepository pr;
	
	public ProizvodjacKonverter(ProizvodjacRepository pr) {
		this.pr = pr;
	}
	@Override
	public Proizvodjac convert(String source) {
		int idPr = -1;
		try {
			idPr = Integer.parseInt(source);
			
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Proizvodjac.class),
												idPr, null);
		}
		
		Proizvodjac p = pr.findById(idPr).get();
		
		return p;
	}
	

}
