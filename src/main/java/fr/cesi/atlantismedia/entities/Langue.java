package fr.cesi.atlantismedia.entities;
// Generated 15 janv. 2020 14:02:11 by Hibernate Tools 5.4.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Langue generated by hbm2java
 */
public class Langue implements java.io.Serializable {

	private int idLangue;
	private String libelle;
	private Set oeuvres = new HashSet(0);

	public Langue() {
	}

	public Langue(int idLangue, String libelle) {
		this.idLangue = idLangue;
		this.libelle = libelle;
	}

	public Langue(int idLangue, String libelle, Set oeuvres) {
		this.idLangue = idLangue;
		this.libelle = libelle;
		this.oeuvres = oeuvres;
	}

	public int getIdLangue() {
		return this.idLangue;
	}

	public void setIdLangue(int idLangue) {
		this.idLangue = idLangue;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set getOeuvres() {
		return this.oeuvres;
	}

	public void setOeuvres(Set oeuvres) {
		this.oeuvres = oeuvres;
	}

}
