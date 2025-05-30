package com.inventory.repository;

import com.inventory.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test") 
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void testSaveAndFind() {
        Item item = new Item();
        item.setName("Test Item");
        item.setQuantity(10);
        item.setPrice(100.0);

        // Save
        Item savedItem = itemRepository.save(item);

        // Fetch
        Optional<Item> fetchedItem = itemRepository.findById(savedItem.getId());

        assertThat(fetchedItem).isPresent();
        assertThat(fetchedItem.get().getName()).isEqualTo("Test Item");
        assertThat(fetchedItem.get().getQuantity()).isEqualTo(10);
        assertThat(fetchedItem.get().getPrice()).isEqualTo(100.0);
    }
}
