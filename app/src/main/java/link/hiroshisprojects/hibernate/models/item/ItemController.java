package link.hiroshisprojects.hibernate.models.item;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/item")
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
	public Item saveItem(@RequestBody Item item) {
		return itemService.save(item);
	}


}
