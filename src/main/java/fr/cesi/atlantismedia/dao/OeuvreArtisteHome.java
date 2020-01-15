package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.OeuvreArtiste;
import fr.cesi.atlantismedia.entities.OeuvreArtisteId;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class OeuvreArtiste.
 * @see fr.cesi.atlantismedia.dao.OeuvreArtiste
 * @author Hibernate Tools
 */
public class OeuvreArtisteHome {

	private static final Logger logger = Logger.getLogger(OeuvreArtisteHome.class.getName());

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

	public void persist(OeuvreArtiste transientInstance) {
		logger.log(Level.INFO, "persisting OeuvreArtiste instance");
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

	public void saveOrUpdate(OeuvreArtiste instance) {
		logger.log(Level.INFO, "attaching dirty OeuvreArtiste instance");
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

	/*public void attachClean(OeuvreArtiste instance) {
		logger.log(Level.INFO, "attaching clean OeuvreArtiste instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	public void delete(OeuvreArtiste persistentInstance) {
		logger.log(Level.INFO, "deleting OeuvreArtiste instance");
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

	/*public OeuvreArtiste merge(OeuvreArtiste detachedInstance) {
		logger.log(Level.INFO, "merging OeuvreArtiste instance");
		try {
			OeuvreArtiste result = (OeuvreArtiste) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public OeuvreArtiste findById(OeuvreArtisteId id) {
		logger.log(Level.INFO, "getting OeuvreArtiste instance with id: " + id);
		try {
			OeuvreArtiste instance = (OeuvreArtiste) session.get("fr.cesi.atlantismedia.dao.OeuvreArtiste", id);
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

	/*public List findByExample(OeuvreArtiste instance) {
		logger.log(Level.INFO, "finding OeuvreArtiste instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.OeuvreArtiste")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
