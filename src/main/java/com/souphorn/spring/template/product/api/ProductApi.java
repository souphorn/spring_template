package com.souphorn.spring.template.product.api;

import com.souphorn.spring.template.product.domain.Product;
import com.souphorn.spring.template.product.exception.NotProductFound;
import com.souphorn.spring.template.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/api/products")
    public Collection<Product> all() {
        return productService.getProducts();
    }

    @GetMapping(value = "/api/products/{name}")
    public Product getOne(@PathVariable String name) {
        return productService.findByName(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void exceptionHandler(NotProductFound ex) {

    }
}
