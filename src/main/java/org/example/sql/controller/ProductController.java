package org.example.sql.controller;

import org.example.sql.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final OrderRepository repository;

    @Autowired
    public ProductController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> fetchProducts(@RequestParam("name") String name) {
        return repository.getProductNamesByCustomerName(name);
    }
}
