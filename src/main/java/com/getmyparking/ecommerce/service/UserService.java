package com.getmyparking.ecommerce.service;

import com.getmyparking.ecommerce.model.Role;
import com.getmyparking.ecommerce.model.User;
import com.getmyparking.ecommerce.repository.UserRepository;

import java.util.Map;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        if (userRepository.getUsers().containsKey(user.getName())) {
            throw new IllegalArgumentException("User " + user.getName() + " already exists");
        }
        userRepository.getUsers().put(user.getName(), user);
        System.out.println("User added and logged in");
        System.out.println("User Repository: " + userRepository.getUsers());
    }

    public int countUsers() {
        return userRepository.getUsers().size();
    }

    public void login(String name) {
        User user = userRepository.getUsers().get(name);
        if (user != null) {
            user.setLoggedIn(true);
            System.out.println("User logged in");
        } else {
            System.out.println("User not found");
        }
    }

    public void logout(String name) {
        User user = userRepository.getUsers().get(name);
        if (user != null) {
            user.setLoggedIn(false);
            System.out.println("User logged out");
        } else {
            System.out.println("User not found");
        }
    }

    public boolean checkAdmin() {
        boolean isLoggedInUserAdmin = false;
        Optional<Map.Entry<String, User>> userEntry = userRepository.getUsers().entrySet()
                .stream()
                .filter(element -> element.getValue().isLoggedIn())
                .findFirst();
        boolean isAnyUserLoggedIn = userEntry.isPresent();
        if (isAnyUserLoggedIn) {
            isLoggedInUserAdmin = userEntry.get().getValue().getUserRole().equals(Role.ADMIN);
        }
        return isLoggedInUserAdmin;
    }

    public User findLoggedInUser() {
        Optional<Map.Entry<String, User>> userEntry = userRepository.getUsers().entrySet()
                .stream()
                .filter(element -> element.getValue().isLoggedIn())
                .findFirst();
        boolean isAnyUserLoggedIn = userEntry.isPresent();
        if (isAnyUserLoggedIn) {
            return userEntry.get().getValue();
        }
        return null;
    }
}
