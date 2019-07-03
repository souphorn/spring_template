package com.souphorn.spring.template.product.api;

import com.souphorn.spring.template.product.domain.Product;
import com.souphorn.spring.template.product.exception.NotProductFound;
import com.souphorn.spring.template.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductApi {

    private static Logger LOG = LoggerFactory.getLogger(ProductApi.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public Collection<Product> all() {

        var products = productService.getProducts();

        LOG.warn(String.format("Number of records found %d", products.toArray().length));

        return products;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void exceptionHandler(NotProductFound ex) {

    }
}
