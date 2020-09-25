package com.twuc.shopping.ControllerTests;

import com.twuc.shopping.dto.ProductRequest;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    private ProductEntity productEntity;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        productEntity = ProductEntity.builder()
                .name("雪碧")
                .price(3)
                .unit("瓶")
                .imgLink("http://123.com")
                .build();
    }

    @Test
    void should_get_all_products_when_get_all_products_success() throws Exception {
        productRepository.save(productEntity);
        mockMvc.perform(get("/products"))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].name", is("雪碧")))
                .andExpect(jsonPath("$.data[0].price", is(3)))
                .andExpect(status().isOk());
    }
}
