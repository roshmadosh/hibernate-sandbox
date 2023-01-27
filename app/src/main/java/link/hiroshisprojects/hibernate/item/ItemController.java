package link.hiroshisprojects.hibernate.item;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	private ItemService itemService;
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	@GetMapping
	public List<Item> getItems() {
		return itemService.list();
	}

	@PostMapping
	public Item saveItem(Item item) {
		return itemService.save(item);
	}


}
