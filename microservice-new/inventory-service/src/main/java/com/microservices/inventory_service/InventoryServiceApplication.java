package com.microservices.inventory_service;

import com.microservices.inventory_service.model.Inventory;
import com.microservices.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

		System.out.println("INVENTORY-SERVICE INITIALIZED SUCCESSFULLY ON " + new Date());
	}

		@Bean
		public CommandLineRunner LoadData(InventoryRepository inventoryrepository) {
			return args ->  {
				Inventory inventory = new Inventory();
				inventory.setProductCode("samsung1");
				inventory.setQuantity(100);

				Inventory inventory1 = new Inventory();
				inventory1.setProductCode("infinix1");
				inventory1.setQuantity(0);

				Inventory inventory2 = new Inventory();
				inventory1.setProductCode("tecno1");
				inventory1.setQuantity(20);

				inventoryrepository.save(inventory);
				inventoryrepository.save(inventory1);
				inventoryrepository.save(inventory2);
			};
		}
}
