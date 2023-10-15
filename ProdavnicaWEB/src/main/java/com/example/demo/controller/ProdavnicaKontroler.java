package com.example.demo.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator.RequestorType;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.KategorijaRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.KorpaRepository;

import com.example.demo.repository.OcenaRepository;
import com.example.demo.repository.OmiljenoRepository;
import com.example.demo.repository.ProizvodRepository;
import com.example.demo.repository.ProizvodjacRepository;

import model.Kategorija;
import model.Korisnik;
import model.Korpa;
import model.Ocena;
import model.Omiljeno;
import model.Proizvod;
import model.Proizvodjac;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value = "/prodavnica")
public class ProdavnicaKontroler {
	
	@Autowired
	ProizvodRepository pr;
	
	@Autowired
	ProizvodjacRepository proiz;
	
	@Autowired
	KategorijaRepository kr;
	
	@Autowired
	KorisnikRepository k;
	
	@Autowired
	OmiljenoRepository or;
	
	@Autowired
	OcenaRepository ocr;
	
	@Autowired
	KorpaRepository kor;
	
	@RequestMapping(value = "/getProizvodi", method = RequestMethod.GET)
	public String getProizvodi(HttpServletRequest request) {
		List<Proizvod> pro = pr.findAll();
		request.getSession().setAttribute("proizvodi", pro);
		return "/prikaz/PrikazProizvoda";
	}
	
	@RequestMapping(value = "/getOcene", method = RequestMethod.GET)
	public String getOcene(HttpServletRequest request) {
		List<Ocena> ocena = ocr.findAll();
		request.getSession().setAttribute("ocena", ocena);
		return "/prikaz/PrikazOcena";
	}
	
	@RequestMapping(value = "/getKategorije", method = RequestMethod.GET)
	public String getKategorije(HttpServletRequest request) {
		List<Kategorija> kat = kr.findAll();
		request.getSession().setAttribute("kategorije", kat);
		return "/prikaz/PrikazProizvodaKategorija";
	}
	
	@RequestMapping(value = "/getProKat", method = RequestMethod.GET)
	public String getProKat(HttpServletRequest request, Integer idKategorija) {
		Kategorija nova = kr.findById(idKategorija).get();
		
		List<Proizvod> novP = pr.findByKategorija(nova);
		request.getSession().setAttribute("odabranaKategorija", nova);
		request.getSession().setAttribute("odabraniProizvod", novP);
		return "prikaz/PrikazProizvodaKategorija";
	}
	
//	@RequestMapping(value="/saveProizvodjac", method=RequestMethod.POST)
//	public String saveProizvodjac(Proizvodjac p, Model m, HttpServletRequest request) {
//		proiz.save(p);
//		request.getSession().setAttribute("proizvodjac", p);
//		return "unos/UnosProizvodjaca";
//	}
	
//	@RequestMapping(value="/saveKategorija", method=RequestMethod.POST)
//	public String saveKategorija(Kategorija k, HttpServletRequest request) {
//		kr.save(k);
//		request.getSession().setAttribute("kategorija", k);
//		return "unos/UnosKategorije";
//	}
	
	@ModelAttribute("proizvodjaci")
	public List<Proizvodjac> getProizvodjac(){
		return proiz.findAll();
	}
	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorija(){
		return kr.findAll();
	}
	
//	@RequestMapping(value = "/unosNoveKolicine", method = RequestMethod.GET)
//	public String unosNoveKolicine() {
//		return "unos/UnosNoveKolicine";
//	}
	
	@ModelAttribute("proizvodi")
	public List<Proizvod> getProizvodZaOmiljeno() {
		return pr.findAll();
	}
	
	@ModelAttribute("kupac")
	public List<Korisnik> getKupac() {
		return k.findAll();
	}
	
	@ModelAttribute("omiljeno")
	public Omiljeno getOmiljeno() {
		return new Omiljeno();
	}
	
	@ModelAttribute("proizvod")
	public Proizvod getProizvod() {
		return new Proizvod();
	}
//	@RequestMapping(value = "/unosProizvoda", method = RequestMethod.GET)
//	public String unosProizvoda(){
//		return "unos/UnosProizvoda";
//	}
	
//	@RequestMapping(value = "/saveProizvod", method = RequestMethod.POST)
//	public String saveProizvod(@ModelAttribute("proizvod") Proizvod p, Model m) {
//		Proizvod nov = pr.save(p);
//		m.addAttribute("proizvodNov", nov);
//		return "unos/UnosProizvoda";
//	}
	
	@RequestMapping(value = "/unosOmiljeno", method = RequestMethod.POST)
	public String unosOmiljeno() {
		return "prikaz/PrikazProizvoda";
	}
	
	@RequestMapping(value = "/saveOmiljenoKat", method = RequestMethod.GET)
	public String saveOmiljenoKat(Integer idProizvod,HttpServletRequest request, Model m) {
		Principal pri = request.getUserPrincipal();
		Omiljeno o = new Omiljeno();
		Proizvod novP = pr.findById(idProizvod).get();
		Korisnik novK = k.findByUsername(pri.getName());
		o.setKorisnik(novK);
		o.setProizvod(novP);
		or.save(o);
		m.addAttribute("potvrda", "Uspesno dodat u omiljeno: " + o.getProizvod().getNazivP());
		return "prikaz/PrikazProizvodaKategorija";
	}
	
	@RequestMapping(value = "/saveOmiljeno", method = RequestMethod.GET)
	public String saveOmiljeno(Integer idProizvod, HttpServletRequest request, Model m) {
		Principal pri = request.getUserPrincipal();
		Omiljeno o = new Omiljeno();
		Proizvod novP = pr.findById(idProizvod).get();
		Korisnik novK = k.findByUsername(pri.getName());
		o.setKorisnik(novK);
		o.setProizvod(novP);
		or.save(o);
		m.addAttribute("potvrda", "Uspesno dodat u omiljeno: " + o.getProizvod().getNazivP());
		return "prikaz/PrikazProizvoda";
	}
	
	
	@RequestMapping(value = "/saveKolicina", method = RequestMethod.GET)
	public String saveKolicina(Integer idProizvod, Integer novaKolicina, Model m) {
		Proizvod p = pr.findById(idProizvod).get();
		p.setKolicinaP(p.getKolicinaP() + novaKolicina);
		pr.save(p);
		m.addAttribute("sacuvaniP", p);
		return "unos/UnosNoveKolicine";
	}

	@RequestMapping(value="/dodajOcenu", method=RequestMethod.GET)
	public String oceniProizvod(Integer idProizvod, Model m) {
		Proizvod p = pr.findById(idProizvod).get();
		
		m.addAttribute("proizvodOcena", p);
		
		return "unos/UnosOcene";
	}
	
	@RequestMapping(value="/saveOcena", method=RequestMethod.GET)
	public String saveOcena(HttpServletRequest request,Integer idProizvod, Integer novaOcena, Model m) {
		Principal pri = request.getUserPrincipal();
		Ocena nova = new Ocena();
		Proizvod p = pr.findById(idProizvod).get();
		Korisnik kup = k.findByUsername(pri.getName());
		nova.setKorisnik(kup);
		nova.setProizvod(p);
		
		nova.setOcena(novaOcena);
		
		ocr.save(nova);
		String potvrda = "Uspesno dodata ocena za proizvod: " + nova.getProizvod().getNazivP();
		m.addAttribute("potvrda", potvrda);
		
		return "unos/UnosOcene";
	}
	
	@RequestMapping(value = "/saveUKorpu", method = RequestMethod.GET)
	public String saveUKorpu(Integer idProizvod, Model m, HttpServletRequest request) {
		Principal pri = request.getUserPrincipal();
		Korpa korpa = new Korpa();
		Proizvod p = pr.findById(idProizvod).get();
		p.setKolicinaP(p.getKolicinaP() - 1);
		pr.save(p);
		Korisnik kup = k.findByUsername(pri.getName());
		Date date = new Date();
		korpa.setKorisnik(kup);
		korpa.setProizvod(p);
		korpa.setDatumKupovine(date);
		kor.save(korpa);
		String potvrdaKorpa = "Uspesno dodato u korpu: " + korpa.getProizvod().getNazivP();
		m.addAttribute("potvrdaKorpa", potvrdaKorpa);
		
		return "prikaz/PrikazProizvoda";
	}
	
	@RequestMapping(value = "/saveUKorpuKat", method = RequestMethod.GET)
	public String saveUKorpuKat(Integer idProizvod,HttpServletRequest request, Model m) {
		Principal pri = request.getUserPrincipal();
		Korpa korpa = new Korpa();
		Proizvod novP = pr.findById(idProizvod).get();
		
		Korisnik novK = k.findByUsername(pri.getName());
		Date date = new Date();
		korpa.setKorisnik(novK);
		korpa.setProizvod(novP);
		korpa.setDatumKupovine(date);
		novP.setKolicinaP(novP.getKolicinaP() - 1);
		pr.save(novP);
		kor.save(korpa);
		String potvrdaKorpa = "Uspesno dodato u korpu: " + korpa.getProizvod().getNazivP();
		m.addAttribute("potvrdaKorpa", potvrdaKorpa);
		
		return "prikaz/PrikazProizvodaKategorija";
	}
	
	
	@RequestMapping(value = "/sortCena", method = RequestMethod.GET)
	public String sortiraj(Model m) {
		List<Proizvod> sortirano = pr.sortirajPoCeni();
		m.addAttribute("proizvodi", sortirano);
		return "prikaz/PrikazProizvoda";
	}
	
	@RequestMapping(value = "/vratiKorpu", method = RequestMethod.GET)
	public String vratiKorpu(HttpServletRequest request) {
		Principal pri = request.getUserPrincipal();
		Korisnik korisnik = k.findByUsername(pri.getName());
		List<Korpa> korpa = kor.vratiKorpu(korisnik.getIdKorisnik());
		request.getSession().setAttribute("korpa", korpa);
		return "prikaz/PrikaziKorpu";
	}
	@RequestMapping(value="getIstorijaKupovine", method=RequestMethod.GET) 
	public void vratiIstorijuKupovine(HttpServletResponse response, HttpServletRequest request) throws Exception { 
		Principal pri = request.getUserPrincipal();
		Korisnik korisnik = k.findByUsername(pri.getName());
		List<Korpa> korpa = kor.vratiKorpu(korisnik.getIdKorisnik());
	
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(korpa);
		InputStream inputStream = this.getClass().getResourceAsStream("/reports/IstorijaKorpe.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=IstorijaKupovine.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out);
	}
	
	@RequestMapping(value="getFiltriranje", method=RequestMethod.GET) 
	public void filtriranje(String naziv, Integer cenaP, HttpServletResponse response, HttpServletRequest request) throws Exception { 
		List<Proizvod> proizvod = pr.filtriranje(naziv,cenaP);
		
		Principal pri = request.getUserPrincipal();
		Korisnik korisnik = k.findByUsername(pri.getName());
	
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(proizvod);
		InputStream inputStream = this.getClass().getResourceAsStream("/reports/IzvestajFiltriranja.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ime", korisnik.getIme());
		params.put("prezime", korisnik.getPrezime());
		
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=Filtrirano.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out);
	}
	
	
	
}
