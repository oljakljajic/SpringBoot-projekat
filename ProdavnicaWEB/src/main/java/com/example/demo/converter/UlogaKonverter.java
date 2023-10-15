package com.example.demo.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.UlogaRepository;

import model.Proizvodjac;
import model.Uloga;

public class UlogaKonverter implements Converter<String, Uloga>{
	
	UlogaRepository ur;
	
	public UlogaKonverter(UlogaRepository ur) {
		this.ur = ur;
	}
	
	@Override
	public Uloga convert(String source) {
		int idPr = -1;
		try {
			idPr = Integer.parseInt(source);
			
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Proizvodjac.class),
												idPr, null);
		}
		
		Uloga p = ur.findById(idPr).get();
		
		return p;
	}

}
