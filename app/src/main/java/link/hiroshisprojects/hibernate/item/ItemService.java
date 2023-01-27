package link.hiroshisprojects.hibernate.item;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

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
		return itemDao.findAll();
	}

}
