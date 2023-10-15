package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Korpa
	@OneToMany(mappedBy="korisnik")
	private List<Korpa> korpas;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="korisnik")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="korisnik")
	private List<Omiljeno> omiljenos;

	//bi-directional many-to-many association to Uloga
	@ManyToMany(mappedBy="korisniks", fetch = FetchType.EAGER)
	private Set<Uloga> ulogas;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Korpa> getKorpas() {
		return this.korpas;
	}

	public void setKorpas(List<Korpa> korpas) {
		this.korpas = korpas;
	}

	public Korpa addKorpa(Korpa korpa) {
		getKorpas().add(korpa);
		korpa.setKorisnik(this);

		return korpa;
	}

	public Korpa removeKorpa(Korpa korpa) {
		getKorpas().remove(korpa);
		korpa.setKorisnik(null);

		return korpa;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setKorisnik(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setKorisnik(null);

		return ocena;
	}

	public List<Omiljeno> getOmiljenos() {
		return this.omiljenos;
	}

	public void setOmiljenos(List<Omiljeno> omiljenos) {
		this.omiljenos = omiljenos;
	}

	public Omiljeno addOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().add(omiljeno);
		omiljeno.setKorisnik(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setKorisnik(null);

		return omiljeno;
	}

	public Set<Uloga> getUlogas() {
		return this.ulogas;
	}

	public void setUlogas(Set<Uloga> ulogas) {
		this.ulogas = ulogas;
	}
	
	public void addUloga(Uloga u) {
		this.ulogas.add(u);
	}

}