package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOcena;

	private int ocena;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	private Proizvod proizvod;

	public Ocena() {
	}

	public int getIdOcena() {
		return this.idOcena;
	}

	public void setIdOcena(int idOcena) {
		this.idOcena = idOcena;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

}