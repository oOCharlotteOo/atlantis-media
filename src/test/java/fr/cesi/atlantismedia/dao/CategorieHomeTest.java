package fr.cesi.atlantismedia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategorieHomeTest {

    private SessionFactory sessionFactory;

    private Session session = null;

    @Before
    public void before() {

     sessionFactory = createSessionFactory();

     session = sessionFactory.openSession();

     Transaction transaction = session.beginTransaction();

    }
    
    private SessionFactory createSessionFactory() {

     // setup the session factory

     Configuration configuration = new Configuration();

     configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/atlantismedia?serverTimezone=UTC");
     configuration.setProperty("hibernate.connection.username", "root");
     configuration.setProperty("hibernate.bytecode.use_reflection_optimizer", "false");
     configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
     configuration.setProperty("hibernate.connection.password", "");
     configuration.setProperty("hibernate.default_catalog", "atlantismedia");
     configuration.setProperty("hibernate.default_schema", "atlantismedia");
     configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
     configuration.setProperty("hibernate.search.autoregister_listeners", "true");
     
     
     //sessionFactory = configuration.buildSessionFactory();

     //session = sessionFactory.openSession();
     SessionFactory sessionFactory = configuration.buildSessionFactory();
     return sessionFactory;
    }

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/*CategorieHome cat = new CategorieHome ();
		Categorie r1= cat.findById(1);
		assertNotNull(r1);*/
	}

}
