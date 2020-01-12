package fr.cesi.atlantismedia.entities;
// Generated 12 janv. 2020 19:04:39 by Hibernate Tools 5.4.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Morceaux generated by hbm2java
 */
public class Morceaux implements java.io.Serializable {

	private int idMorceaux;
	private String titreMorceaux;
	private int duree;
	private Set oeuvres = new HashSet(0);

	public Morceaux() {
	}

	public Morceaux(int idMorceaux, String titreMorceaux, int duree) {
		this.idMorceaux = idMorceaux;
		this.titreMorceaux = titreMorceaux;
		this.duree = duree;
	}

	public Morceaux(int idMorceaux, String titreMorceaux, int duree, Set oeuvres) {
		this.idMorceaux = idMorceaux;
		this.titreMorceaux = titreMorceaux;
		this.duree = duree;
		this.oeuvres = oeuvres;
	}

	public int getIdMorceaux() {
		return this.idMorceaux;
	}

	public void setIdMorceaux(int idMorceaux) {
		this.idMorceaux = idMorceaux;
	}

	public String getTitreMorceaux() {
		return this.titreMorceaux;
	}

	public void setTitreMorceaux(String titreMorceaux) {
		this.titreMorceaux = titreMorceaux;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Set getOeuvres() {
		return this.oeuvres;
	}

	public void setOeuvres(Set oeuvres) {
		this.oeuvres = oeuvres;
	}

}
