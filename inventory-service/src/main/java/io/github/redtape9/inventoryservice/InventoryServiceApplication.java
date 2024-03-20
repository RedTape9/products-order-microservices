package io.github.redtape9.inventoryservice;

import io.github.redtape9.inventoryservice.model.Inventory;
import io.github.redtape9.inventoryservice.repo.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			inventoryRepository.save(new Inventory(123L,"Samsung Galaxy S21 FE", 3));
			inventoryRepository.save(new Inventory(321L,"Xiaomi Redmi Note 13", 0));
		};
	}
}
