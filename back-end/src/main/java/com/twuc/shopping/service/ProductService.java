package com.twuc.shopping.service;

import com.twuc.shopping.dto.ProductResponse;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        ProductResponse<List<ProductEntity>> response = new ProductResponse<>();
        response.setCode(200);
        response.setMessage("get all products success!");
        response.setData(productEntities);
        return response;
    }
}
