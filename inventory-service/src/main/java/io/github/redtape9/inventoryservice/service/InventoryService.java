package io.github.redtape9.inventoryservice.service;

import io.github.redtape9.inventoryservice.repo.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    public boolean isInStock(String skuCode) {
        inventoryRepository.findBySkuCode();
    }
}
