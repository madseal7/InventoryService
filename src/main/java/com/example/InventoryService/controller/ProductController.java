package com.example.InventoryService.controller;

import com.example.InventoryService.service.ProductService;
import com.example.InventoryService.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{product_id}")
    public Optional<Product> getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/products")
    public void saveNewProduct(@RequestBody Product product) {
        productService.saveNewProduct(product);
    }

    @DeleteMapping("/products/{product_id}")
    public void deleteProductById(@RequestBody Long productId) {
        productService.deleteProductById(productId);
    }
}
