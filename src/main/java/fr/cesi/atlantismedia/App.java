package fr.cesi.atlantismedia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.dao.CategorieHome;
import fr.cesi.atlantismedia.entities.Categorie;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        CategorieHome catDao = new  CategorieHome();
        /*Categorie cat1 = catDao.findById(4);
        cat1.setLibelle("Jeux Vidéo");
        catDao.saveOrUpdate(cat1);*/
        /*catDao.delete(cat1);*/
        //System.out.println("Cat1: " + cat1.getLibelle());
        
        /*Categorie cat = new Categorie();
        cat.setLibelle("Film");
        catDao.saveOrUpdate(cat);*/
        
        //List<Categorie> cats = catDao.findAll();
        List<Categorie> cats = catDao.findByLibelle("Film");
        for (Categorie catsou : cats) {
            System.out.println("Cat: " + catsou.getLibelle());
        }
        /*SessionFactory factory = HibernateUtils.getSessionFactory();
        
        Session session = factory.openSession();
  
        try {
             
            // All the action with DB via Hibernate
            // must be located in one transaction.
            // Start Transaction.            
            session.getTransaction().begin();
  
     
             
            // Create an HQL statement, query the object.
            // Equivalent to the SQL statement:
            // Select e.* from EMPLOYEE e order by e.EMP_NAME, e.EMP_NO
            String sql = "Select cat from " + Categorie.class.getName() + " cat ";
  
    
            // Create Query object.
            Query<Categorie> query = session.createQuery(sql);
  
     
            // Execute query.
            List<Categorie> categories = query.getResultList();
  
            for (Categorie cat : categories) {
                System.out.println("Cat: " + cat.getLibelle());
            }*/
            
            /*Categorie cat1 = (Categorie) session.get("fr.cesi.atlantismedia.entities.Categorie", 1);
            System.out.println("Cat1: " + cat1.getLibelle());*/
        /*    
            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }*/
    }
}
