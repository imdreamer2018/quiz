package com.twuc.shopping.controller;

import com.twuc.shopping.dto.ProductResponse;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @ResponseBody
    public ResponseEntity<ProductResponse<List<ProductEntity>>> getAllProducts() {
        ProductResponse<List<ProductEntity>> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }
}
