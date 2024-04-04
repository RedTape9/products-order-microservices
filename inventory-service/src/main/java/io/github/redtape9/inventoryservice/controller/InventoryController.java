package io.github.redtape9.inventoryservice.controller;

import io.github.redtape9.inventoryservice.dto.InventoryResponse;
import io.github.redtape9.inventoryservice.service.InventoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/xiaomi_redmi_note_13,samsung_galaxy_s21_fe
    // http://localhost:8082/api/inventory?skuCode=xiaomi_redmi_note_13&sku-code=samsung_galaxy_s21_fe
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

}
