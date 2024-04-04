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

    // http://localhost:8082/api/inventory/redmi_tote_13,Samsung,Galaxy_S21_FE
    // http://localhost:8082/api/inventory?sku-code=redmi_tote_13&sku-code=Samsung_Galaxy_S21_FE
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

}
