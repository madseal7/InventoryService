package com.example.InventoryService.service;

import com.example.InventoryService.*;
import com.example.InventoryService.dto.Product;
import com.example.InventoryService.repository.ProductRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class InventoryService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository repository;

    @Override
    public void getProductInfo(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {

        Optional<Product> optionalProduct = repository.findById(request.getProductId());
        Product product = optionalProduct.get();

        ProductResponse response = ProductResponse.newBuilder()
                .setId(request.getProductId())
                .setName(product.getName())
                .setQuantity(product.getQuantity())
                .setPrice(product.getPrice())
                .setSale(product.isOnSale())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
