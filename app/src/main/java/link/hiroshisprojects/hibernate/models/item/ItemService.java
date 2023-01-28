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
		items.stream().forEach(item -> Hibernate.initialize(item.getOrders()));

		return items;
	}

}
