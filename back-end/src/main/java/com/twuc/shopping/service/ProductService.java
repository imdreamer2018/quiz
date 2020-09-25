package com.twuc.shopping.service;

import com.twuc.shopping.dto.ProductRequest;
import com.twuc.shopping.dto.ProductResponse;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.exception.BaseProductException;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ProductResponse<ProductEntity> createProduct(ProductRequest productRequest) {
        Optional<ProductEntity> product = productRepository.findByName(productRequest.getName());
        if (product.isPresent()) {
            throw new BaseProductException("the product name is existed!");
        }
        ProductResponse<ProductEntity> response = new ProductResponse<>();
        response.setCode(201);
        response.setMessage("create product success!");
        ProductEntity productEntity = ProductEntity.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .unit(productRequest.getUnit())
                .imgLink(productRequest.getImgLink())
                .build();
        productRepository.save(productEntity);
        response.setData(productEntity);
        return response;
    }
}
