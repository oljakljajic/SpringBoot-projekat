package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.ProizvodRepository;
import com.example.demo.repository.UlogaRepository;

import model.Korisnik;
import model.Proizvod;
import model.Uloga;

@Controller
@ControllerAdvice
@RequestMapping(value = "auth")
public class LoginController {
	@Autowired
	KorisnikRepository kr;

	@Autowired
	UlogaRepository ur;
	
	@Autowired
	ProizvodRepository pr;


	@ModelAttribute
	public void getRoles(Model model) {
		List<Uloga> roles = ur.findAll();
		model.addAttribute("roles", roles);

	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		return "login";

	}

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String deniedPage() {
		return "access_denied";

	}

	@RequestMapping(value = "registerUser", method = RequestMethod.GET)
	public String newUser(Model model) {
		Korisnik u = new Korisnik();
		model.addAttribute("user", u);
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Korisnik k) {
//		NoOpPasswordEncoder  passwordEncoder = (NoOpPasswordEncoder) passwordEncoder();
//		k.setPassword(passwordEncoder.encode(k.getPassword()));
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		k.setPassword(passwordEncoder.encode(k.getPassword()));

		for (Uloga r : k.getUlogas()) {
			r.addRole(k);
		}

		kr.save(k);
		return "login";

	}

//	@RequestMapping(value = "registerUser", method = RequestMethod.GET)
//	public String newUser(Model model) {
//		BibliotekaKorisnik u = new BibliotekaKorisnik();
//		model.addAttribute("user", u);
//		return "register";
//	}
// 
//   @RequestMapping(value = "register", method = RequestMethod.POST)
//	public String saveUser(@ModelAttribute("user")  u) {
//    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//     	u.setSifra(passwordEncoder.encode(u.getSifra()));
//		
//		
//    	ur.save(u);
//		return "login";
//
//	}

	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/auth/loginPage";
	}

	@RequestMapping(value = "/pocetna", method = RequestMethod.GET)
	public String getPocetna() {

		return "pocetna";
	}

	@RequestMapping(value = "/getSve", method = RequestMethod.GET)
	public String getSve(HttpServletRequest request) {
		List<Proizvod> proizvod = pr.findAll();
		request.getSession().setAttribute("proizvodi", proizvod);
		return "prikaz/PrikazProizvoda";
	}

}

