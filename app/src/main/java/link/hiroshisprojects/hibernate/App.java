package link.hiroshisprojects.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import link.hiroshisprojects.hibernate.item.Item;
import link.hiroshisprojects.hibernate.item.ItemRepository;
import link.hiroshisprojects.hibernate.order.PurchaseOrder;


public class App {
	public static void main(String[] args) {
		// jpa();	
		// hibernate();
    }

	static void jpa() {
		EntityManager entityManager = JpaFactoryUtil.getEntityManagerFactory().createEntityManager();
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
		Session session = JpaFactoryUtil.getSessionFactory().openSession();
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
