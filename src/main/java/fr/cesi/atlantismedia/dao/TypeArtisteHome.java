package fr.cesi.atlantismedia.dao;
// Generated 15 janv. 2020 14:03:23 by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.cesi.atlantismedia.entities.TypeArtiste;
import fr.cesi.atlantismedia.utils.HibernateUtils;

/**
 * Home object for domain model class TypeArtiste.
 * @see fr.cesi.atlantismedia.dao.TypeArtiste
 * @author Hibernate Tools
 */
public class TypeArtisteHome {

	private static final Logger logger = Logger.getLogger(TypeArtisteHome.class.getName());

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

	public void persist(TypeArtiste transientInstance) {
		logger.log(Level.INFO, "persisting TypeArtiste instance");
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

	public void saveOrUpdate(TypeArtiste instance) {
		logger.log(Level.INFO, "attaching dirty TypeArtiste instance");
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

	/*public void attachClean(TypeArtiste instance) {
		logger.log(Level.INFO, "attaching clean TypeArtiste instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}*/

	public void delete(TypeArtiste persistentInstance) {
		logger.log(Level.INFO, "deleting TypeArtiste instance");
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

	/*public TypeArtiste merge(TypeArtiste detachedInstance) {
		logger.log(Level.INFO, "merging TypeArtiste instance");
		try {
			TypeArtiste result = (TypeArtiste) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}*/

	public TypeArtiste findById(int id) {
		logger.log(Level.INFO, "getting TypeArtiste instance with id: " + id);
		try {
			TypeArtiste instance = (TypeArtiste) session.get("fr.cesi.atlantismedia.dao.TypeArtiste", id);
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
	
	public List<TypeArtiste> findAll() {
		logger.log(Level.INFO, "getting All TypeArtiste instance");
		try {
			String sql = "Select typeArtiste from TypeArtiste typeArtiste ";
			@SuppressWarnings("deprecation")
			Query<TypeArtiste> query = session.createQuery(sql);
			List<TypeArtiste> instance = query.getResultList();
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
	
	public List<TypeArtiste> findByLibelle(String libelle) {
		logger.log(Level.INFO, "getting All TypeArtiste instance");
		try {
			String sql = "select typeArtiste from TypeArtiste typeArtiste "
					+ " where typeArtiste.libelle = :libelle" ;
			Query<TypeArtiste> query = session.createQuery(sql);
			query.setParameter("libelle", libelle);
			List<TypeArtiste> instance = query.getResultList();
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

	/*public List findByExample(TypeArtiste instance) {
		logger.log(Level.INFO, "finding TypeArtiste instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("fr.cesi.atlantismedia.dao.TypeArtiste")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}*/
}
