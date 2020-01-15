package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.OeuvreCritique;
import fr.cesi.atlantismedia.entities.OeuvreCritiqueId;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class OeuvreCritique.
 * @see fr.cesi.atlantismedia.dao.OeuvreCritique
 * @author Hibernate Tools
 */
public class OeuvreCritiqueHome {

	private static final Logger logger = Logger.getLogger(OeuvreCritiqueHome.class.getName());
	
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

	public void persist(OeuvreCritique transientInstance) {
		logger.log(Level.INFO, "persisting OeuvreCritique instance");
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

	public void saveOrUpdate(OeuvreCritique instance) {
		logger.log(Level.INFO, "attaching dirty OeuvreCritique instance");
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

	/*public void attachClean(OeuvreCritique instance) {
		logger.log(Level.INFO, "attaching clean OeuvreCritique instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	public void delete(OeuvreCritique persistentInstance) {
		logger.log(Level.INFO, "deleting OeuvreCritique instance");
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

	/*public OeuvreCritique merge(OeuvreCritique detachedInstance) {
		logger.log(Level.INFO, "merging OeuvreCritique instance");
		try {
			OeuvreCritique result = (OeuvreCritique) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public OeuvreCritique findById(OeuvreCritiqueId id) {
		logger.log(Level.INFO, "getting OeuvreCritique instance with id: " + id);
		try {
			OeuvreCritique instance = (OeuvreCritique) session.get("fr.cesi.atlantismedia.dao.OeuvreCritique", id);
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

	/*public List findByExample(OeuvreCritique instance) {
		logger.log(Level.INFO, "finding OeuvreCritique instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.OeuvreCritique")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
