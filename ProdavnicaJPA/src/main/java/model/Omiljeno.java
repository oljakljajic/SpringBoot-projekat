package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the omiljeno database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljeno.findAll", query="SELECT o FROM Omiljeno o")
public class Omiljeno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljeno;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne(cascade={CascadeType.ALL})
	private Proizvod proizvod;

	public Omiljeno() {
	}

	public int getIdOmiljeno() {
		return this.idOmiljeno;
	}

	public void setIdOmiljeno(int idOmiljeno) {
		this.idOmiljeno = idOmiljeno;
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