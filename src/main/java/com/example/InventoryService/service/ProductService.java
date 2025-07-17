package com.example.InventoryService.service;

import com.example.InventoryService.dto.Product;
import com.example.InventoryService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return repository.findById(productId);
    }

    public void saveNewProduct(Product product) {
        repository.save(product);
    }

    public void deleteProductById(Long productId) {
        repository.deleteById(productId);
    }
}
