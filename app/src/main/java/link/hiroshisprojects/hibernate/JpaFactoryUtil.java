package link.hiroshisprojects.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaFactoryUtil {

	private static EntityManagerFactory emf;
	private static SessionFactory sessionFactory;
	private static final Logger LOGGER = LoggerFactory.getLogger(JpaFactoryUtil.class);

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			LOGGER.info("***CREATING ENTITY MANAGER FACTORY***");
			emf =  Persistence.createEntityManagerFactory("MyPersistenceUnit");
		} return emf;		
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			LOGGER.info("***CREATING SESSION FACTORY***");
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

			try {
				sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
				return sessionFactory;
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		} return sessionFactory;
	}



}
