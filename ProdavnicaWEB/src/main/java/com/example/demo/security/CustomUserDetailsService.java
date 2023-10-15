package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.KorisnikRepository;

import model.Korisnik;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private KorisnikRepository kir;
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik user = kir.findByUsername(username);
		UserDetailsImpl userDetails =new UserDetailsImpl();
		userDetails.setUsername(user.getUsername());
		userDetails.setPassword(user.getPassword());
		userDetails.setRoles(user.getUlogas());
		return userDetails;
		
    }
 
     
 


	
     
}
