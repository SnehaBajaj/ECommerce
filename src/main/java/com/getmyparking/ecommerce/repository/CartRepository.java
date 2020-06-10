package com.getmyparking.ecommerce.repository;

import com.getmyparking.ecommerce.model.Product;
import com.getmyparking.ecommerce.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartRepository {
    private final Map<User, List<Product>> carts = new HashMap<>();

    public List<Product> getCartOfUser(User user) {
        if(carts.get(user) == null){
            List<Product> products = new ArrayList<>();
            carts.put(user, products);
        }
        return carts.get(user);
    }
}
