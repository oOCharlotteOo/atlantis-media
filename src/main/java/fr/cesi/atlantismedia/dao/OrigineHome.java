package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Categorie;
import fr.cesi.atlantismedia.entities.Origine;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Origine.
 * @see fr.cesi.atlantismedia.dao.Origine
 * @author Hibernate Tools
 */
public class OrigineHome {

	private static final Logger logger = Logger.getLogger(OrigineHome.class.getName());

private final Session session = getSession();
	
	protected Session getSession() {
		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession(); //on force l'ouverture de la session
			return session;
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	//méthode pour créer=persist (create) une entrée dans la base de données
		public void persist(Origine transientInstance) {
			logger.log(Level.INFO, "persisting Origine instance");
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
		
		public void saveOrUpdate(Origine instance) {
			logger.log(Level.INFO, "attaching dirty Origine instance");
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

	/*public void attachClean(Origine instance) {
		logger.log(Level.INFO, "attaching clean Origine instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

		public void delete(Origine persistentInstance) {
			logger.log(Level.INFO, "deleting Origine instance");
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

	/*public Origine merge(Origine detachedInstance) {
		logger.log(Level.INFO, "merging Origine instance");
		try {
			Origine result = (Origine) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public Origine findById(int id) {
		logger.log(Level.INFO, "getting Origine instance with id: " + id);
		try {
			Origine instance = (Origine) session.get("fr.cesi.atlantismedia.dao.Origine",
					id);
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

	
	public List<Origine> findAll() {
		logger.log(Level.INFO, "getting All Origine instance");
		try {
			String sql = "Select origine from Origine origine ";
			@SuppressWarnings("deprecation")
			Query<Origine> query = session.createQuery(sql);
			List<Origine> instance = query.getResultList();
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
	
	public List<Origine> findByLibelle(String libelle) {
		logger.log(Level.INFO, "getting All Origine instance");
		try {
			String sql = "select origine from Origine origine "
					+ " where origine.libelle = :libelle" ;
			Query<Origine> query = session.createQuery(sql);
			query.setParameter("libelle", libelle);
			List<Origine> instance = query.getResultList();
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
	/*public List findByExample(Origine instance) {
		logger.log(Level.INFO, "finding Origine instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.Origine")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
