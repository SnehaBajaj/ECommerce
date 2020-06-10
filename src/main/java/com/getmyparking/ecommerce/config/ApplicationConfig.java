package com.getmyparking.ecommerce.config;

import com.getmyparking.ecommerce.controller.CartController;
import com.getmyparking.ecommerce.controller.ProductController;
import com.getmyparking.ecommerce.controller.UserController;
import com.getmyparking.ecommerce.repository.CartRepository;
import com.getmyparking.ecommerce.repository.ProductRepository;
import com.getmyparking.ecommerce.repository.UserRepository;
import com.getmyparking.ecommerce.service.CartService;
import com.getmyparking.ecommerce.service.ProductService;
import com.getmyparking.ecommerce.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserController userController(){
        return new UserController(userService());
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public ProductController productController() {
        return new ProductController(userController(), productService());
    }

    @Bean
    public ProductService productService(){
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public CartController cartController() {
        return new CartController(cartService(), userService());
    }

    @Bean
    public CartService cartService() {
        return new CartService(cartRepository(), productService());
    }

    @Bean
    public CartRepository cartRepository() {
        return new CartRepository();
    }

}
