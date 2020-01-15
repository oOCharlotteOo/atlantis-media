package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Artiste;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Artiste.
 * @see fr.cesi.atlantismedia.dao.Artiste
 * @author Hibernate Tools
 */
public class ArtisteHome {

	private static final Logger logger = Logger.getLogger(ArtisteHome.class.getName());

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

	public void persist(Artiste transientInstance) {
		logger.log(Level.INFO, "persisting Artiste instance");
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

	public void saveOrUpdate(Artiste instance) {
		logger.log(Level.INFO, "attaching dirty Artiste instance");
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

	/*public void attachClean(Artiste instance) {
		logger.log(Level.INFO, "attaching clean Artiste instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	public void delete(Artiste persistentInstance) {
		logger.log(Level.INFO, "deleting Artiste instance");
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

	/*public Artiste merge(Artiste detachedInstance) {
		logger.log(Level.INFO, "merging Artiste instance");
		try {
			Artiste result = (Artiste) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public Artiste findById(int id) {
		logger.log(Level.INFO, "getting Artiste instance with id: " + id);
		try {
			Artiste instance = (Artiste) session.get("fr.cesi.atlantismedia.entities.Artiste", id);
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
	
	public List<Artiste> findAll() {
		logger.log(Level.INFO, "getting All Artiste instance");
		try {
			String sql = "Select artiste from Artiste artiste ";
			@SuppressWarnings("deprecation")
			Query<Artiste> query = session.createQuery(sql);
			List<Artiste> instance = query.getResultList();
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
	
	public List<Artiste> findByNom(String nom) {
		logger.log(Level.INFO, "getting All Artiste instance");
		try {
			String sql = "select artiste from Artiste artiste "
					+ " where artiste.nom = :nom" ;
			Query<Artiste> query = session.createQuery(sql);
			query.setParameter("nom", nom);
			List<Artiste> instance = query.getResultList();
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

	/*public List findByExample(Artiste instance) {
		logger.log(Level.INFO, "finding Artiste instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.Artiste")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
