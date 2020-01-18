package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Statut;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Statut.
 *
 * @author oOCharlotteOo
 * @see fr.cesi.atlantismedia.entities.Statut
 */
public class StatutHome {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(StatutHome.class.getName());

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
	public void persist(Statut transientInstance) {
		logger.log(Level.INFO, "persisting Statut instance");
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
	public void saveOrUpdate(Statut instance) {
		logger.log(Level.INFO, "attaching dirty Statut instance");
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

	/*public void attachClean(Statut instance) {
		logger.log(Level.INFO, "attaching clean Statut instance");
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
	public void delete(Statut persistentInstance) {
		logger.log(Level.INFO, "deleting Statut instance");
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

	/*public Statut merge(Statut detachedInstance) {
		logger.log(Level.INFO, "merging Statut instance");
		try {
			Statut result = (Statut) sessionFactory.getCurrentSession().merge(detachedInstance);
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
	 * @return the statut
	 */
	public Statut findById(int id) {
		logger.log(Level.INFO, "getting Statut instance with id: " + id);
		try {
			Statut instance = (Statut) session.get("fr.cesi.atlantismedia.entities.Statut", id);
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
	public List<Statut> findAll() {
		logger.log(Level.INFO, "getting All Statut instance");
		try {
			String sql = "Select statut from Statut statut ";
			@SuppressWarnings("deprecation")
			Query<Statut> query = session.createQuery(sql);
			List<Statut> instance = query.getResultList();
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
	 * Find by libelle.
	 *
	 * @param libelle the libelle
	 * @return the list
	 */
	public List<Statut> findByLibelle(String libelle) {
		logger.log(Level.INFO, "getting All Statut instance");
		try {
			String sql = "select statut from Statut statut "
					+ " where statut.libelle = :libelle" ;
			Query<Statut> query = session.createQuery(sql);
			query.setParameter("libelle", libelle);
			List<Statut> instance = query.getResultList();
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
	
	/*public List findByExample(Statut instance) {
		logger.log(Level.INFO, "finding Statut instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.Statut")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}*/
}
