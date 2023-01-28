package link.hiroshisprojects.hibernate.models.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Optional<Item> findDistinctByName(String name); 

} 
