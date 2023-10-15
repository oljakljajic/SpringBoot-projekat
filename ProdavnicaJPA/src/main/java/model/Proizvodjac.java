package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proizvodjac database table.
 * 
 */
@Entity
@NamedQuery(name="Proizvodjac.findAll", query="SELECT p FROM Proizvodjac p")
public class Proizvodjac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProizvodjac;

	private String adresaProizvodjac;

	private String imeProizvodjac;

	//bi-directional many-to-one association to Proizvod
	@OneToMany(mappedBy="proizvodjac")
	private List<Proizvod> proizvods;

	public Proizvodjac() {
	}

	public int getIdProizvodjac() {
		return this.idProizvodjac;
	}

	public void setIdProizvodjac(int idProizvodjac) {
		this.idProizvodjac = idProizvodjac;
	}

	public String getAdresaProizvodjac() {
		return this.adresaProizvodjac;
	}

	public void setAdresaProizvodjac(String adresaProizvodjac) {
		this.adresaProizvodjac = adresaProizvodjac;
	}

	public String getImeProizvodjac() {
		return this.imeProizvodjac;
	}

	public void setImeProizvodjac(String imeProizvodjac) {
		this.imeProizvodjac = imeProizvodjac;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setProizvodjac(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setProizvodjac(null);

		return proizvod;
	}

}