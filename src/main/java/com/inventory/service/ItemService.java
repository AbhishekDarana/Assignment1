package com.inventory.service;

import com.inventory.model.Item;
import com.inventory.repository.ItemRepository;
import com.inventory.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + id));
    }


    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItemQuantity(Long id, int quantity) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setQuantity(quantity);
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Item not found with id: " + id);
        }
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
