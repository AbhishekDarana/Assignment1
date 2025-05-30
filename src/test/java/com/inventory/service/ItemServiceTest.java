package com.inventory.service;

import com.inventory.exception.ResourceNotFoundException;
import com.inventory.model.Item;
import com.inventory.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllItems() {
        List<Item> mockItems = Arrays.asList(
                new Item(1L, "Item A", 10, 100.0),
                new Item(2L, "Item B", 5, 50.0)
        );
        when(itemRepository.findAll()).thenReturn(mockItems);

        List<Item> items = itemService.getAllItems();

        assertThat(items).hasSize(2);
        verify(itemRepository, times(1)).findAll();
    }

    @Test
    void testGetItemById_Found() {
        Item mockItem = new Item(1L, "Item A", 10, 100.0);
        when(itemRepository.findById(1L)).thenReturn(Optional.of(mockItem));

        Item item = itemService.getItemById(1L);

        assertThat(item.getName()).isEqualTo("Item A");
    }

    @Test
    void testGetItemById_NotFound() {
        when(itemRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> itemService.getItemById(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Item not found");
    }

    @Test
    void testAddItem() {
        Item newItem = new Item(null, "New Item", 20, 200.0);
        Item savedItem = new Item(1L, "New Item", 20, 200.0);
        when(itemRepository.save(newItem)).thenReturn(savedItem);

        Item result = itemService.addItem(newItem);

        assertThat(result.getId()).isEqualTo(1L);
        verify(itemRepository).save(newItem);
    }

    @Test
    void testUpdateItemQuantity_Found() {
        Item existing = new Item(1L, "Item", 10, 100.0);
        when(itemRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(itemRepository.save(any(Item.class))).thenAnswer(i -> i.getArgument(0));

        Item updated = itemService.updateItemQuantity(1L, 50);

        assertThat(updated.getQuantity()).isEqualTo(50);
    }

    @Test
    void testUpdateItemQuantity_NotFound() {
        when(itemRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> itemService.updateItemQuantity(1L, 20))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Item not found");
    }

    @Test
    void testDeleteItem() {
        doNothing().when(itemRepository).deleteById(1L);

        itemService.deleteItem(1L);

        verify(itemRepository).deleteById(1L);
    }
}
