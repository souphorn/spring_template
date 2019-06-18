package com.souphorn.spring.template.product.api;

import com.souphorn.spring.template.product.domain.Product;
import com.souphorn.spring.template.product.exception.NotProductFound;
import com.souphorn.spring.template.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testProductApi() throws Exception {

        given(productService.getProducts()).willReturn(List.of(new Product(1, "product1"), new Product(2, "product2")));

        mockMvc.perform(
                get("/api/products").with(user("user"))
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("product1"))
        .andExpect(jsonPath("$[1].name").value("product2"))
        ;

                ;
    }

    @Test
    public void testGetProduct() throws Exception {

        given(productService.findByName(anyString())).willReturn(new Product(1, "product1"));

        mockMvc.perform(get("/api/products/product1").with(user("user")))
                .andExpect(jsonPath("name").value("product1"))
        ;
    }

    @Test
    public void testNotFound() throws Exception {
        given(productService.findByName(anyString())).willThrow(new NotProductFound());

        mockMvc.perform(get("/api/products/product1").with(user("user")))
                .andExpect(status().isNotFound());
    }
}
