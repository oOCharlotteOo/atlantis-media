package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Langue;
import fr.cesi.atlantismedia.entities.Morceaux;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Morceaux.
 *
 * @author oOCharlotteOo
 * @see fr.cesi.atlantismedia.entities.Morceaux
 */
public class MorceauxHome {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MorceauxHome.class.getName());

/** The session. */
private final Session session = getSession();
	
	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		try {
			Session session = HibernateUtils.getSession();
			return session;
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	/**
	 * Persist.
	 *
	 * @param transientInstance the transient instance
	 */
	public void persist(Morceaux transientInstance) {
		logger.log(Level.INFO, "persisting Morceaux instance");
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

	/**
	 * Save or update.
	 *
	 * @param instance the instance
	 */
	public void saveOrUpdate(Morceaux instance) {
		logger.log(Level.INFO, "attaching dirty Morceaux instance");
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

	/*public void attachClean(Morceaux instance) {
		logger.log(Level.INFO, "attaching clean Morceaux instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	/**
	 * Delete.
	 *
	 * @param persistentInstance the persistent instance
	 */
	public void delete(Morceaux persistentInstance) {
		logger.log(Level.INFO, "deleting Morceaux instance");
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

	/*public Morceaux merge(Morceaux detachedInstance) {
		logger.log(Level.INFO, "merging Morceaux instance");
		try {
			Morceaux result = (Morceaux) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the morceaux
	 */
	public Morceaux findById(int id) {
		logger.log(Level.INFO, "getting Morceaux instance with id: " + id);
		try {
			Morceaux instance = (Morceaux) session.get("fr.cesi.atlantismedia.entities.Morceaux",
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

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Morceaux> findAll() {
		logger.log(Level.INFO, "getting All Morceaux instance");
		try {
			String sql = "Select morceaux from Morceaux morceaux ";
			@SuppressWarnings("deprecation")
			Query<Morceaux> query = session.createQuery(sql);
			List<Morceaux> instance = query.getResultList();
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
	
	/**
	 * Find by titre.
	 *
	 * @param titreMorceaux the titre morceaux
	 * @return the list
	 */
	public List<Morceaux> findByTitre(String titreMorceaux) {
		logger.log(Level.INFO, "getting All Morceaux instance");
		try {
			String sql = "select morceaux from Morceaux morceaux "
					+ " where morceaux.titreMorceaux = :titreMorceaux" ;
			Query<Morceaux> query = session.createQuery(sql);
			query.setParameter("titreMorceaux", titreMorceaux);
			List<Morceaux> instance = query.getResultList();
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
	
	/*public List findByExample(Morceaux instance) {
		logger.log(Level.INFO, "finding Morceaux instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.Morceaux")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
