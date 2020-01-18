package fr.cesi.atlantismedia.entities;
// Generated 16 janv. 2020 21:29:33 by Hibernate Tools 5.4.7.Final

/**
 * Casting generated by hbm2java.
 */
public class Casting implements java.io.Serializable {

	/** The id casting. */
	private Integer idCasting;
	
	/** The artiste. */
	private Artiste artiste;
	
	/** The oeuvre. */
	private Oeuvre oeuvre;
	
	/** The annee composition. */
	private Integer anneeComposition;
	
	/** The role. */
	private String role;


	/**
	 * Instantiates a new casting.
	 */
	public Casting() {
	}

	/**
	 * Instantiates a new casting.
	 *
	 * @param artiste the artiste
	 * @param oeuvre the oeuvre
	 */
	public Casting(Artiste artiste, Oeuvre oeuvre) {
		this.artiste = artiste;
		this.oeuvre = oeuvre;
	}

	/**
	 * Instantiates a new casting.
	 *
	 * @param artiste the artiste
	 * @param oeuvre the oeuvre
	 * @param anneeComposition the annee composition
	 * @param role the role
	 */
	public Casting(Artiste artiste, Oeuvre oeuvre, Integer anneeComposition, String role) {
		this.artiste = artiste;
		this.oeuvre = oeuvre;
		this.anneeComposition = anneeComposition;
		this.role = role;
		
	}

	/**
	 * Gets the id casting.
	 *
	 * @return the id casting
	 */
	public Integer getIdCasting() {
		return this.idCasting;
	}

	/**
	 * Sets the id casting.
	 *
	 * @param idCasting the new id casting
	 */
	public void setIdCasting(Integer idCasting) {
		this.idCasting = idCasting;
	}

	/**
	 * Gets the artiste.
	 *
	 * @return the artiste
	 */
	public Artiste getArtiste() {
		return this.artiste;
	}

	/**
	 * Sets the artiste.
	 *
	 * @param artiste the new artiste
	 */
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	/**
	 * Gets the oeuvre.
	 *
	 * @return the oeuvre
	 */
	public Oeuvre getOeuvre() {
		return this.oeuvre;
	}

	/**
	 * Sets the oeuvre.
	 *
	 * @param oeuvre the new oeuvre
	 */
	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	/**
	 * Gets the annee composition.
	 *
	 * @return the annee composition
	 */
	public Integer getAnneeComposition() {
		return this.anneeComposition;
	}

	/**
	 * Sets the annee composition.
	 *
	 * @param anneeComposition the new annee composition
	 */
	public void setAnneeComposition(Integer anneeComposition) {
		this.anneeComposition = anneeComposition;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
