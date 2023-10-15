package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the uloga database table.
 * 
 */
@Entity
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUloga;

	private String naziv;

	//bi-directional many-to-many association to Korisnik
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="korisnikuloga"
		, joinColumns={
			@JoinColumn(name="Uloga_idUloga")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Korisnik_idKorisnik")
			}
		)
	private Set<Korisnik> korisniks;

	public Uloga() {
	}

	public int getIdUloga() {
		return this.idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(Set<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}
	
	public void addRole(Korisnik k) {
		this.korisniks.add(k);
	}

}