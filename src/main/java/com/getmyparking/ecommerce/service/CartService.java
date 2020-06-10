package com.getmyparking.ecommerce.service;

import com.getmyparking.ecommerce.model.Product;
import com.getmyparking.ecommerce.model.User;
import com.getmyparking.ecommerce.repository.CartRepository;

public class CartService {

    private CartRepository cartRepository;
    private ProductService productService;

    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    public void addProductToCart(User user, int productId) {
        Product product;
        if (productService.doesProductExist(productId)) {
            product = productService.findProduct(productId);
            cartRepository.getCartOfUser(user).add(product);
        }
    }

    public void viewCart(User loggedInUser){
        System.out.println(cartRepository.getCartOfUser(loggedInUser));
    }

    public void checkout(User user) {
        double totalAmount = 0;
        for (Product product : cartRepository.getCartOfUser(user)) {
            totalAmount += product.getPrice();
        }
        System.out.println("Total Price is: " + totalAmount);
    }
}
