package fr.cesi.atlantismedia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cesi.atlantismedia.dao.ArtisteHome;
import fr.cesi.atlantismedia.dao.CategorieHome;
import fr.cesi.atlantismedia.dao.GenreHome;
import fr.cesi.atlantismedia.dao.LangueHome;
import fr.cesi.atlantismedia.dao.OeuvreHome;
import fr.cesi.atlantismedia.dao.OrigineHome;
import fr.cesi.atlantismedia.dao.StatutHome;
import fr.cesi.atlantismedia.dao.SupportHome;
import fr.cesi.atlantismedia.entities.Artiste;
import fr.cesi.atlantismedia.entities.Casting;
import fr.cesi.atlantismedia.entities.Categorie;
import fr.cesi.atlantismedia.entities.Genre;
import fr.cesi.atlantismedia.entities.Langue;
import fr.cesi.atlantismedia.entities.Oeuvre;
import fr.cesi.atlantismedia.entities.Origine;
import fr.cesi.atlantismedia.entities.Statut;
import fr.cesi.atlantismedia.entities.Support;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    
    /**
     * Create the test case.
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * Suite.
     *
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-).
     */
    public void testCreateOeuvre()
    {
		ArtisteHome artisteDao = new ArtisteHome();
		Artiste artistel = artisteDao.findById(1);
		Set<Artiste> artistes = new HashSet<Artiste>();
		
		artistes.add(artistel);
		
		Casting casting = new Casting();
		casting.setArtiste(artistel);
		casting.setAnneeComposition(2009);
		casting.setRole("Gandalf");
		
		Set<Casting> castings = new HashSet<Casting>();
		castings.add(casting);
		
		CategorieHome catDao = new CategorieHome();
		Categorie cat = catDao.findById(1);
		
		GenreHome genreDao = new GenreHome();
		Genre genre1 = genreDao.findById(14);
		Set<Genre> genres = new HashSet<Genre>();
		genres.add(genre1);
		
		OrigineHome origineDao = new OrigineHome();
		Origine origine = origineDao.findById(1);

		LangueHome langueHome = new LangueHome();
		List<Langue> langueList = langueHome.findAll();
		Set<Langue> langues = new HashSet<Langue>(langueList);
		
		StatutHome statutHome = new StatutHome();
		Statut statut = statutHome.findById(1);
		
		SupportHome supportHome = new SupportHome();
		Support support = supportHome.findById(1);
		
		Oeuvre oeuvre = new Oeuvre();
		oeuvre.setTitre("Le seigneur des anneaux 3");
		oeuvre.setCastings(castings);
		oeuvre.setCategorie(cat);
		oeuvre.setGenres(genres);
		oeuvre.setOrigine(origine);
		oeuvre.setLangues(langues);
		oeuvre.setStatut(statut);
		oeuvre.setSupport(support);
		
		casting.setOeuvre(oeuvre);
		
		OeuvreHome oeuvreDao = new OeuvreHome();
		oeuvreDao.saveOrUpdate(oeuvre);  
		
        assertTrue( true );

    }
    
    /**
     * Test get oeuvres.
     */
    public void testGetOeuvres(){
    	OeuvreHome oeuvreDao = new OeuvreHome();
    	List<Oeuvre> oeuvres = oeuvreDao.findAll();
    	for (Oeuvre prout : oeuvres) {
            System.out.println("Oeuvre: " + prout.getTitre());            
        }	
    	assertNotNull(oeuvres);
    }
    
    /**
     * Test get oeuvres by categorie.
     */
    //one to many
    public void testGetOeuvresByCategorie() {
    	CategorieHome catDao = new CategorieHome();
		Categorie cat = catDao.findById(3);
		OeuvreHome oeuvreDao = new OeuvreHome();
    	List<Oeuvre> oeuvres = oeuvreDao.findByCategorie(cat.getIdCategorie());
    	for (Oeuvre prout : oeuvres) {
            System.out.println(("Oeuvre: " + prout.getTitre())+":"+ cat.getLibelle());            
        }
    	assertNotNull(oeuvres);
    }
    
    /**
     * Test get oeuvres by genre.
     */
    //many to many
    public void testGetOeuvresByGenre() {
    	GenreHome genreDao = new GenreHome();
    	List<Oeuvre> oeuvres = genreDao.findOeuvreByGenre(11);
    	for (Oeuvre prout : oeuvres) {
            System.out.println("Oeuvre: " + prout.getTitre());            
        }
    	assertNotNull(oeuvres);
    }
    
    /**
     * Test get oeuvres by artiste.
     */
    //many to many complexe    
    public void testGetOeuvresByArtiste() {
    	assertTrue( true );
    }
    
    /**
     * Test get type artistes by oeuvre.
     */
    //many to many ultra complexe   
    public void testGetTypeArtistesByOeuvre() {
    	assertTrue( true );
    }
}
