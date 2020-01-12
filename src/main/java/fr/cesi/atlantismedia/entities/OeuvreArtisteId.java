package fr.cesi.atlantismedia.entities;
// Generated 12 janv. 2020 19:04:39 by Hibernate Tools 5.4.7.Final

/**
 * OeuvreArtisteId generated by hbm2java
 */
public class OeuvreArtisteId implements java.io.Serializable {

	private int idOeuvre;
	private int idArtiste;

	public OeuvreArtisteId() {
	}

	public OeuvreArtisteId(int idOeuvre, int idArtiste) {
		this.idOeuvre = idOeuvre;
		this.idArtiste = idArtiste;
	}

	public int getIdOeuvre() {
		return this.idOeuvre;
	}

	public void setIdOeuvre(int idOeuvre) {
		this.idOeuvre = idOeuvre;
	}

	public int getIdArtiste() {
		return this.idArtiste;
	}

	public void setIdArtiste(int idArtiste) {
		this.idArtiste = idArtiste;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OeuvreArtisteId))
			return false;
		OeuvreArtisteId castOther = (OeuvreArtisteId) other;

		return (this.getIdOeuvre() == castOther.getIdOeuvre()) && (this.getIdArtiste() == castOther.getIdArtiste());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdOeuvre();
		result = 37 * result + this.getIdArtiste();
		return result;
	}

}
