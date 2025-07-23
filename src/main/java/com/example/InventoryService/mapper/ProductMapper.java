package com.example.InventoryService.mapper;

import com.example.InventoryService.ProductResponse;
import com.example.InventoryService.dto.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "isOnSale", source = "sale")
    Product productResponseToProduct(ProductResponse response);

    @Mapping(target = "sale", source = "isOnSale")
    ProductResponse productToProductResponse(Product product);
}
