package com.souphorn.spring.template.product.service;

import com.souphorn.spring.template.product.domain.Product;

import java.util.Collection;

public interface ProductService {
    public Collection<Product> getProducts();
    Product findByName(String name);
}
