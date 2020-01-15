package fr.cesi.atlantismedia;

import fr.cesi.atlantismedia.dao.CategorieHome;
import fr.cesi.atlantismedia.entities.Categorie;

/**
 * Hello world!
 *
 */
public class App {
    
	@SuppressWarnings("static-access")
	public static void main( String[] args ){
    	
		/*GenreHome genreDao = new GenreHome();
    	Genre genre = new Genre();
    	genre.setIdGenre(10);
    	genre.setLibelle("Drame");
    	genreDao.persist(genre);
    	System.out.println("nouveau genre ajouté : "+genre);*/
    	
    	/*OeuvreHome oeuvreDao = new OeuvreHome();
    	Oeuvre oeuvre1 = new Oeuvre();
    	List<Oeuvre> oeuvres = oeuvreDao.findAll();
    	System.out.println("liste des oeuvres de la médiathèque : "+oeuvre1); */
    	
    	//CategorieHome catDao = new  CategorieHome();
        //Categorie cat1 = new Categorie()
;    	//catDao.findById(1); //fonction recherche par id
        //cat1.setLibelle("Jeux Vidéo");
        //catDao.saveOrUpdate(cat1); // fonction update/save
        //catDao.delete(cat1); // fonction delete
     
		CategorieHome catDao = new  CategorieHome(); 
        Categorie cat = new Categorie();
        cat.setLibelle("Film");
        catDao.saveOrUpdate(cat);
        System.out.println("catégorie :"+cat.getLibelle()); //attention c'est l'objet courant qui est affiché (celui qui vient d'être créer
        
        //List<Categorie> cats = catDao.findAll();
       /* List<Categorie> cats = catDao.findByLibelle("Musique");
        for (Categorie catsou : cats) {
            System.out.println("Cat: " + catsou.getLibelle());            
        }*/
    }
}
