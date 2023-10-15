package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.ProizvodRepository;

import model.Proizvod;
import model.Proizvodjac;

public class ProizvodKonverter implements Converter<String, Proizvod>{
	
	ProizvodRepository pr;
	
	public ProizvodKonverter(ProizvodRepository pr) {
		this.pr = pr;
	}

	@Override
	public Proizvod convert(String source) {
		int idPr = -1;
		try {
			idPr = Integer.parseInt(source);
			
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Proizvodjac.class),
												idPr, null);
		}
		
		Proizvod p = pr.findById(idPr).get();
		
		return p;
	}

}
