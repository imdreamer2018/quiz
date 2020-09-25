package com.twuc.shopping.ServiceTests;

import com.twuc.shopping.dto.ProductRequest;
import com.twuc.shopping.dto.ProductResponse;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class ProductServiceTest {

    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        initMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    void should_return_products_info_when_get_products_success() {
        ProductEntity product = ProductEntity.builder()
                .name("雪碧")
                .price(3)
                .unit("瓶")
                .imgLink("http://11.com")
                .build();
        List<ProductEntity> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        ProductResponse<List<ProductEntity>> response = productService.getAllProducts();
        assertEquals("get all products success!", response.getMessage());
    }

    @Test
    void should_return_product_info_when_create_product_success() {
        ProductRequest productRequest = ProductRequest.builder()
                .name("雪碧")
                .price(3)
                .unit("瓶")
                .imgLink("http://11.com")
                .build();
        ProductResponse<ProductEntity> response = productService.createProduct(productRequest);
        assertEquals("create product success!", response.getMessage());
        verify(productRepository)
                .save(
                        ProductEntity.builder()
                                .name(productRequest.getName())
                                .price(productRequest.getPrice())
                                .unit(productRequest.getUnit())
                                .imgLink(productRequest.getImgLink())
                                .build());
    }

}
