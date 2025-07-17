package com.example.InventoryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    long id;
    String name;
    int quantity;
    double price;
    boolean isOnSale;
}
