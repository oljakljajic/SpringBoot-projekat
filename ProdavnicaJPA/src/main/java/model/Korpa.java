package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the korpa database table.
 * 
 */
@Entity
@NamedQuery(name="Korpa.findAll", query="SELECT k FROM Korpa k")
public class Korpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int korpaId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumKupovine;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne(cascade={CascadeType.ALL})
	private Proizvod proizvod;

	public Korpa() {
	}

	public int getKorpaId() {
		return this.korpaId;
	}

	public void setKorpaId(int korpaId) {
		this.korpaId = korpaId;
	}

	public Date getDatumKupovine() {
		return this.datumKupovine;
	}

	public void setDatumKupovine(Date datumKupovine) {
		this.datumKupovine = datumKupovine;
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