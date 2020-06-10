package com.getmyparking.ecommerce.repository;

import com.getmyparking.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {

    private final Map<Integer, Product> products = new HashMap<>();

    public Map<Integer, Product> getProducts() {
        return products;
    }
}
