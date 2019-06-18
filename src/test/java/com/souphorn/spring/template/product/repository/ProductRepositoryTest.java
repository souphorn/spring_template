package com.souphorn.spring.template.product.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test() {

//        entityManager.persistAndFlush(new Product(100, "product1"));
//        productRepository.save(new Product(1, "product2"));
        //Product p = productRepository.findByName("product1");

        //assertThat(p.getName()).isEqualTo(savedProduct.getName());
    }
}
