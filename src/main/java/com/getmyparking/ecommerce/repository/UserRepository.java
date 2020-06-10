package com.getmyparking.ecommerce.repository;

import com.getmyparking.ecommerce.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public Map<String, User> getUsers() {
        return users;
    }


}
