package fr.cesi.atlantismedia.entities;
// Generated 15 janv. 2020 14:02:11 by Hibernate Tools 5.4.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Support generated by hbm2java
 */
public class Support implements java.io.Serializable {

	private int idSupport;
	private String libelle;
	private Set oeuvres = new HashSet(0);

	public Support() {
	}

	public Support(int idSupport, String libelle) {
		this.idSupport = idSupport;
		this.libelle = libelle;
	}

	public Support(int idSupport, String libelle, Set oeuvres) {
		this.idSupport = idSupport;
		this.libelle = libelle;
		this.oeuvres = oeuvres;
	}

	public int getIdSupport() {
		return this.idSupport;
	}

	public void setIdSupport(int idSupport) {
		this.idSupport = idSupport;
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
