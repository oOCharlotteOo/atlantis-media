package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Genre;
import fr.cesi.atlantismedia.entities.Oeuvre;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Genre.
 *
 * @author oOCharlotteOo
 * @see fr.cesi.atlantismedia.entities.Genre
 */
public class GenreHome {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(GenreHome.class.getName());

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
	public void persist(Genre transientInstance) {
		logger.log(Level.INFO, "persisting Genre instance");
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
	 * @return the genre
	 */
	public Genre saveOrUpdate(Genre instance) {
		logger.log(Level.INFO, "attaching dirty Genre instance");
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
		return instance;
	}

	/*public void attachClean(Genre instance) {
		logger.log(Level.INFO, "attaching clean Genre instance");
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
	public void delete(Genre persistentInstance) {
		logger.log(Level.INFO, "deleting Genre instance");
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

	/*public Genre merge(Genre detachedInstance) {
		logger.log(Level.INFO, "merging Genre instance");
		try {
			Genre result = (Genre) sessionFactory.getCurrentSession().merge(detachedInstance);
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
	 * @return the genre
	 */
	public Genre findById(int id) {
		logger.log(Level.INFO, "getting Genre instance with id: " + id);
		try {
			Genre instance = (Genre) session.get("fr.cesi.atlantismedia.entities.Genre", id);
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
	public List<Genre> findAll() {
		logger.log(Level.INFO, "getting All Genre instance");
		try {
			String sql = "Select genre from Genre genre ";
			@SuppressWarnings("deprecation")
			Query<Genre> query = session.createQuery(sql);
			List<Genre> instance = query.getResultList();
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
	public List<Genre> findByLibelle(String libelle) {
		logger.log(Level.INFO, "getting All Genre instance");
		try {
			String sql = "select genre from Genre genre "
					+ " where genre.libelle = :libelle" ;
			Query<Genre> query = session.createQuery(sql);
			query.setParameter("libelle", libelle);
			List<Genre> instance = query.getResultList();
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
	/*public List findByExample(Genre instance) {
		logger.log(Level.INFO, "finding Genre instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.Genre")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
	
	/**
	 * Find oeuvre by genre.
	 *
	 * @param idGenre the id genre
	 * @return the list
	 */
	public List<Oeuvre> findOeuvreByGenre(int idGenre) {

		logger.log(Level.INFO, "getting All Oeuvre instance by genre");
		try {
			String sql = "select genre.oeuvres from Genre genre where genre.id = :idGenre";
			Query<Oeuvre> query = session.createQuery(sql);
			query.setParameter("idGenre", idGenre);
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