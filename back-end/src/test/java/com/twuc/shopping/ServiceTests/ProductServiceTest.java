package com.twuc.shopping.ServiceTests;

import com.twuc.shopping.dto.ProductRequest;
import com.twuc.shopping.dto.ProductResponse;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.exception.BaseProductException;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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

    @Test
    void should_throw_invalid_input_exception_when_create_product_and_name_is_existed() {
        ProductEntity product = ProductEntity.builder()
                .name("雪碧")
                .price(3)
                .unit("瓶")
                .imgLink("http://11.com")
                .build();
        when(productRepository.findByName(anyString())).thenReturn(Optional.of(product));
        ProductRequest productRequest = ProductRequest.builder()
                .name("雪碧")
                .price(3)
                .unit("瓶")
                .imgLink("http://11.com")
                .build();
        BaseProductException exception = assertThrows(BaseProductException.class, () -> productService.createProduct(productRequest));
        assertEquals("the product name is existed!", exception.getMessage());
    }

}
