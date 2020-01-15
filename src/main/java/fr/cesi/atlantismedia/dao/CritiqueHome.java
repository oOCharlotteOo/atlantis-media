package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.Critique;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class Critique.
 * @see fr.cesi.atlantismedia.dao.Critique
 * @author Hibernate Tools
 */
public class CritiqueHome {

	private static final Logger logger = Logger.getLogger(CritiqueHome.class.getName());

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

	public void persist(Critique transientInstance) {
		logger.log(Level.INFO, "persisting Critique instance");
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

	public void saveOrUpdate(Critique instance) {
		logger.log(Level.INFO, "attaching dirty Critique instance");
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

	/*public void attachClean(Critique instance) {
		logger.log(Level.INFO, "attaching clean Critique instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	public void delete(Critique persistentInstance) {
		logger.log(Level.INFO, "deleting Critique instance");
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

	/*public Critique merge(Critique detachedInstance) {
		logger.log(Level.INFO, "merging Critique instance");
		try {
			Critique result = (Critique) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public Critique findById(int id) {
		logger.log(Level.INFO, "getting Critique instance with id: " + id);
		try {
			Critique instance = (Critique) session.get("fr.cesi.atlantismedia.dao.Critique",
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

	public List<Critique> findAll() {
		logger.log(Level.INFO, "getting All Critique instance");
		try {
			String sql = "Select critique from Critique critique ";
			@SuppressWarnings("deprecation")
			Query<Critique> query = session.createQuery(sql);
			List<Critique> instance = query.getResultList();
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
	
	public List<Critique> findByTitre(String libelle) {
		logger.log(Level.INFO, "getting All Critique instance");
		try {
			String sql = "select critique from Critique critique "
					+ " where critique.libelle = :libelle" ;
			Query<Critique> query = session.createQuery(sql);
			query.setParameter("libelle", libelle);
			List<Critique> instance = query.getResultList();
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
	
	/*public List findByExample(Critique instance) {
		logger.log(Level.INFO, "finding Critique instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.Critique")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
