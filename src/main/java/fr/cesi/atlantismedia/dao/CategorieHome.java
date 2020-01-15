package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Categorie;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Categorie.
 * @see fr.cesi.atlantismedia.dao.Categorie
 * @author Hibernate Tools
 */
public class CategorieHome {

	private static final Logger logger = Logger.getLogger(CategorieHome.class.getName());

	private final Session session = getSession();
	
	
	protected Session getSession() {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			return session;
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
//méthode pour créer=persist (create) une entrée dans la base de données
	public void persist(Categorie transientInstance) {
		logger.log(Level.INFO, "persisting Categorie instance");
		try {
			session.getTransaction().begin();
			session.persist(transientInstance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Categorie instance) {
		logger.log(Level.INFO, "attaching dirty Categorie instance");
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(instance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	/*public void attachClean(Categorie instance) {
		logger.log(Level.INFO, "attaching clean Categorie instance");
		try {
			session.lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	public void delete(Categorie persistentInstance) {
		logger.log(Level.INFO, "deleting Categorie instance");
		try {
			session.getTransaction().begin();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	/*public Categorie merge(Categorie detachedInstance) {
		logger.log(Level.INFO, "merging Categorie instance");
		try {
			Categorie result = (Categorie) session.merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public Categorie findById(int id) {
		logger.log(Level.INFO, "getting Categorie instance with id: " + id);
		try {
			Categorie instance = (Categorie) session.get("fr.cesi.atlantismedia.entities.Categorie", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
	
	public List<Categorie> findAll() {
		logger.log(Level.INFO, "getting All Categorie instance");
		try {
			String sql = "Select categorie from Categorie categorie ";
			@SuppressWarnings("deprecation")
			Query<Categorie> query = session.createQuery(sql);
			List<Categorie> instance = query.getResultList();
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
	
	public List<Categorie> findByLibelle(String libelle) {
		logger.log(Level.INFO, "getting All Categorie instance");
		try {
			String sql = "select categorie from Categorie categorie "
					+ " where categorie.libelle = :libelle" ;
			Query<Categorie> query = session.createQuery(sql);
			query.setParameter("libelle", libelle);
			List<Categorie> instance = query.getResultList();
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	/*public List findByExample(Categorie instance) {
		logger.log(Level.INFO, "finding Categorie instance by example");
		try {
			List results = session.createCriteria("fr.cesi.atlantismedia.entities.Categorie")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}