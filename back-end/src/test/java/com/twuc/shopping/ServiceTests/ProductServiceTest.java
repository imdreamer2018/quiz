package com.twuc.shopping.ServiceTests;

import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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


}
