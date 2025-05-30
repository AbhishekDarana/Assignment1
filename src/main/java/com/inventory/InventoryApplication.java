// package com.inventory;

// import com.inventory.model.Item;
// import com.inventory.repository.ItemRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// @SpringBootApplication
// public class InventoryApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(InventoryApplication.class, args);
//     }

//     @Bean
//     CommandLineRunner testConnection(ItemRepository repo) {
//         return args -> {
//             Item item = new Item();
//             item.setName("Test Item");
//             item.setQuantity(5);
//             item.setPrice(19.99);

//             repo.save(item);
//             System.out.println("✅ Successfully connected and saved: " + item.getName());
//         };
//     }
// }
