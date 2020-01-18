package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.cesi.atlantismedia.entities.Oeuvre;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Oeuvre.
 *
 * @author oOCharlotteOo
 * @see fr.cesi.atlantismedia.entities.Oeuvre
 */
public class OeuvreHome {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(OeuvreHome.class.getName());

	/** The session. */
	private final Session session = getSession();

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		try {
			Session session = HibernateUtils.getSession();// à faire partot == récupère la session courante (singleton)
			// Session session = factory.openSession(); //on force l'ouverture de la session
			// session.setFlushMode(FlushMode.MANUAL);
			return session;
			// return (SessionFactory) new InitialContext().lookup("SessionFactory");
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
	public void persist(Oeuvre transientInstance) {
		logger.log(Level.INFO, "persisting Oeuvre instance");
		try {
			session.getTransaction().begin();
			session.persist(transientInstance);
			session.flush();
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
	public void saveOrUpdate(Oeuvre instance) {
		logger.log(Level.INFO, "attaching dirty Oeuvre instance");
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

	/*
	 * public void attachClean(Oeuvre instance) { logger.log(Level.INFO,
	 * "attaching clean Oeuvre instance"); try {
	 * sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
	 * logger.log(Level.INFO, "attach successful"); } catch (RuntimeException re) {
	 * logger.log(Level.SEVERE, "attach failed", re); throw re; } }
	 */

	/**
	 * Delete.
	 *
	 * @param persistentInstance the persistent instance
	 */
	public void delete(Oeuvre persistentInstance) {
		logger.log(Level.INFO, "deleting Oeuvre instance");
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

	/**
	 * Merge.
	 *
	 * @param detachedInstance the detached instance
	 * @return the oeuvre
	 */
	public Oeuvre merge(Oeuvre detachedInstance) {
		logger.log(Level.INFO, "merging Oeuvre instance");
		try {
			session.getTransaction().begin();
			Oeuvre result = (Oeuvre) session.merge(detachedInstance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the oeuvre
	 */
	public Oeuvre findById(int id) {
		logger.log(Level.INFO, "getting Oeuvre instance with id: " + id);
		try {
			Oeuvre instance = (Oeuvre) session.get("fr.cesi.atlantismedia.entities.Oeuvre", id);
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
	public List<Oeuvre> findAll() {
		logger.log(Level.INFO, "getting All Oeuvre instance");
		try {
			String sql = "Select oeuvre from Oeuvre oeuvre ";
			@SuppressWarnings("deprecation")
			Query<Oeuvre> query = session.createQuery(sql);
			List<Oeuvre> instance = query.getResultList();
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
	 * @param titre the titre
	 * @return the list
	 */
	public List<Oeuvre> findByTitre(String titre) {
		logger.log(Level.INFO, "getting All Oeuvre instance");
		try {
			String sql = "select oeuvre from Oeuvre oeuvre " + " where oeuvre.titre = :titre";
			Query<Oeuvre> query = session.createQuery(sql);
			query.setParameter("titre", titre);
			List<Oeuvre> instance = query.getResultList();
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
	/*
	 * public List findByExample(Oeuvre instance) { logger.log(Level.INFO,
	 * "finding Oeuvre instance by example"); try { List results =
	 * sessionFactory.getCurrentSession().createCriteria(
	 * "fr.cesi.atlantismedia.dao.Oeuvre") .add(Example.create(instance)).list();
	 * logger.log(Level.INFO, "find by example successful, result size: " +
	 * results.size()); return results; } catch (RuntimeException re) {
	 * logger.log(Level.SEVERE, "find by example failed", re); throw re; } }
	 */

	/**
	 * Find by categorie.
	 *
	 * @param idCategorie the id categorie
	 * @return the list
	 */
	public List<Oeuvre> findByCategorie(int idCategorie) {

		logger.log(Level.INFO, "getting All Oeuvre instance");
		try {
			String sql = "select oeuvre from Oeuvre oeuvre " + " where oeuvre.categorie.id = :idCategorie";
			Query<Oeuvre> query = session.createQuery(sql);
			query.setParameter("idCategorie", idCategorie);
			List<Oeuvre> instance = query.getResultList();
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

	
}
