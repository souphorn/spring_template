package com.souphorn.spring.template.product.api;

import com.souphorn.spring.template.product.domain.Product;
import com.souphorn.spring.template.product.repository.ProductRepository;
import com.souphorn.spring.template.product.service.ProductService;
import com.souphorn.spring.template.product.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void test() {

        given(productRepository.findAll()).willReturn(List.of(new Product(1, "p1"), new Product(2, "p2")));

        var products = productService.getProducts();
        assertThat(products.size()).isEqualTo(2);
        var product = (Product) products.toArray()[0];
        assertThat(product).isNotNull();
        System.out.println(products.toArray()[0].toString());
    }
}