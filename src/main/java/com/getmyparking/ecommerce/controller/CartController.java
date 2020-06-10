package com.getmyparking.ecommerce.controller;

import com.getmyparking.ecommerce.model.User;
import com.getmyparking.ecommerce.service.CartService;
import com.getmyparking.ecommerce.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

public class CartController {

    private CartService cartService;

    private UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    Scanner sc = new Scanner(System.in);

    public void addProduct() {
        User loggedInUser = userService.findLoggedInUser();
        if (loggedInUser != null) {
            System.out.println("Enter the product ID that you want to add to your cart: ");
            int productId = sc.nextInt();
            cartService.addProductToCart(loggedInUser, productId);
        }
    }

    public void viewCart() {
        User loggedInUser = userService.findLoggedInUser();
        if (loggedInUser != null) {
            cartService.viewCart(loggedInUser);
        }
    }

    public void checkout() {
        User loggedInUser = userService.findLoggedInUser();
        if (loggedInUser != null) {
            cartService.checkout(loggedInUser);
        }
    }
}
