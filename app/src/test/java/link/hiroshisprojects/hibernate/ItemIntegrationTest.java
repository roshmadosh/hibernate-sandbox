package link.hiroshisprojects.hibernate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import link.hiroshisprojects.hibernate.item.Item;
import link.hiroshisprojects.hibernate.item.ItemRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class, WebMvcConfig.class })
@WebAppConfiguration
public class ItemIntegrationTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	@Transactional
	public void testTableIsEmptyAtInit() {
		long expectedCount = 0;
		long actualCount = itemRepository.count(); 

		assertEquals(expectedCount, actualCount);
	}

	@Test
	@Transactional
	public void testWhenSave_CountIncrements() {
		long beforeCount = itemRepository.count();
		itemRepository.save(new Item("test", 10.00));
		long afterCount = itemRepository.count();
		
		assertEquals(beforeCount + 1, afterCount);
	}

	@Test
	@Transactional
	public void testWhenFindByIdExists_ReturnItem() {

		Item expected = new Item("shoes", 10.50);
		itemRepository.save(expected);

		Optional<Item> item = itemRepository.findDistinctByName(expected.getName());
		
		assertEquals(item.get().getPrice(), expected.getPrice());
	}



}
