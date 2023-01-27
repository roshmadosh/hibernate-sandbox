package link.hiroshisprojects.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import link.hiroshisprojects.hibernate.item.Item;
import link.hiroshisprojects.hibernate.order.PurchaseOrder;


public class App {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
	private static SessionFactory sessionFactory;
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	static { 
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure()
			.build();

		try {
			sessionFactory = new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();

		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public static void main(String[] args) {
		jpa();	
		// hibernate();
    }

	static void jpa() {
		EntityManager entityManager = emf.createEntityManager();
		LOGGER.warn("SANITY CHECK **********");
		PurchaseOrder order = new PurchaseOrder();
		Item shoes = new Item("shoes", 10.50);
		Item hat = new Item("hat", 33.33);
		order.addItem(shoes);
		order.addItem(hat);

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(order);
		
		tx.commit();
		entityManager.close();
	}

	static void hibernate() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		PurchaseOrder order = new PurchaseOrder();
		Item pants = new Item("pants", 20.55);
		Item shirt = new Item("shirt", 52.41);

		
		order.addItem(pants);
		order.addItem(shirt);

		session.save(order);

		session.getTransaction().commit();
		session.close();
	}
}
