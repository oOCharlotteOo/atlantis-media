package fr.cesi.atlantismedia.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
 
/**
 * The Class HibernateUtils.
 */
public class HibernateUtils {
 
    /** The Constant sessionFactory. */
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    /** The session. */
    private static Session session = null;
 
    /**
     * Builds the session factory.
     *
     * @return the session factory
     */
    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                    .configure("hibernate.cfg.xml").build();
 
            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
 
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
         
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Gets the session.
     *
     * @return the session
     */
    public static Session getSession() {
    	if (session == null) {
    		session = sessionFactory.openSession();
    	}
        return session;
    }    
 
    /**
     * Gets the session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    /**
     * Shutdown.
     */
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
 
}
