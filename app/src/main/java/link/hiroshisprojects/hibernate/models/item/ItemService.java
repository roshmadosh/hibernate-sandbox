package link.hiroshisprojects.hibernate.models.item;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemRepository itemDao;


	public Item save(Item item) {
		return itemDao.save(item);
	}
	
	public Item findByName(String name) {
		return itemDao.findDistinctByName(name).orElseThrow(EntityNotFoundException::new);
	}
	
	public List<Item> list() {
		List<Item> items = itemDao.findAll();

		/* When the controller tries to map a fetched item to JSON, the orders must be fetched then b/c one-to-many attributes
		 * are lazily instantiated. The problem is that the DB session has already closed, so to ensure the orders info are 
		 * fetched along with the items, this line is required. */
		items.stream().forEach(item -> Hibernate.initialize(item.getOrders()));

		return items;
	}

}
