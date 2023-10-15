package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proizvod database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvod.findAll", query="SELECT p FROM Proizvod p")
public class Proizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProizvod;

	private int cenaP;

	private int kolicinaP;

	private String nazivP;

	private String opis;

	//bi-directional many-to-one association to Korpa
	@OneToMany(mappedBy="proizvod", cascade={CascadeType.ALL})
	private List<Korpa> korpas;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="proizvod")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljeno
	@OneToMany(mappedBy="proizvod", cascade={CascadeType.ALL})
	private List<Omiljeno> omiljenos;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	private Kategorija kategorija;

	//bi-directional many-to-one association to Proizvodjac
	@ManyToOne
	private Proizvodjac proizvodjac;

	public Proizvod() {
	}

	public int getIdProizvod() {
		return this.idProizvod;
	}

	public void setIdProizvod(int idProizvod) {
		this.idProizvod = idProizvod;
	}

	public int getCenaP() {
		return this.cenaP;
	}

	public void setCenaP(int cenaP) {
		this.cenaP = cenaP;
	}

	public int getKolicinaP() {
		return this.kolicinaP;
	}

	public void setKolicinaP(int kolicinaP) {
		this.kolicinaP = kolicinaP;
	}

	public String getNazivP() {
		return this.nazivP;
	}

	public void setNazivP(String nazivP) {
		this.nazivP = nazivP;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Korpa> getKorpas() {
		return this.korpas;
	}

	public void setKorpas(List<Korpa> korpas) {
		this.korpas = korpas;
	}

	public Korpa addKorpa(Korpa korpa) {
		getKorpas().add(korpa);
		korpa.setProizvod(this);

		return korpa;
	}

	public Korpa removeKorpa(Korpa korpa) {
		getKorpas().remove(korpa);
		korpa.setProizvod(null);

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
		ocena.setProizvod(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setProizvod(null);

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
		omiljeno.setProizvod(this);

		return omiljeno;
	}

	public Omiljeno removeOmiljeno(Omiljeno omiljeno) {
		getOmiljenos().remove(omiljeno);
		omiljeno.setProizvod(null);

		return omiljeno;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Proizvodjac getProizvodjac() {
		return this.proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

}