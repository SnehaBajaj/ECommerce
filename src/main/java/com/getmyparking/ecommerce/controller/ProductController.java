package com.getmyparking.ecommerce.controller;

import com.getmyparking.ecommerce.model.Product;
import com.getmyparking.ecommerce.service.ProductService;

import java.util.Scanner;

public class ProductController {

    private UserController userController;
    private ProductService productService;

    public ProductController(UserController userController, ProductService productService) {
        this.userController = userController;
        this.productService = productService;
    }

    Scanner sc = new Scanner(System.in);

    public void addProduct() {
        if (userController.checkAdmin()) {
            System.out.println("Enter product name");
            String name = sc.nextLine();
            System.out.println("Enter product description");
            String desc = sc.nextLine();
            System.out.println("Enter product price");
            Double price = sc.nextDouble();
            sc.nextLine();
            int productCount = productService.countProducts();
            productService.addProduct(new Product(productCount + 1, name, desc, price));
            System.out.println("Product added");
            displayAllProducts();
        } else {
            System.out.println("Only admins can add products");
        }
    }

    public void updateProduct() {
        System.out.println("Enter the product ID which needs to be updated: ");
        int productId = sc.nextInt();
        if (userController.checkAdmin()) {
            if (productService.doesProductExist(productId)) {
                System.out.println("Do you want to change product name? (Y/N) ");
                String name = null, description = null;
                double price = Double.MIN_VALUE;
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Enter product name");
                    name = sc.nextLine();
                }
                System.out.println("Do you want to change product description? (Y/N) ");
                answer = sc.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Enter product desciption");
                    description = sc.nextLine();
                }
                System.out.println("Do you want to change product price? (Y/N) ");
                answer = sc.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Enter product price");
                    price = sc.nextDouble();
                    sc.nextLine();
                }
                productService.updateProduct(productId, name, description, price);
                System.out.println("Product updated");
                displayAllProducts();
            } else {
                System.out.println("Product " + productId + " does not exist");
            }
        } else {
            System.out.println("Only admins can update products");
        }
    }

    public void deleteProduct() {
        System.out.println("Enter the product ID which needs to be deleted: ");
        int productId = sc.nextInt();
        sc.nextLine();
        if (userController.checkAdmin()) {
            if(productService.doesProductExist(productId)) {
                productService.deleteProduct(productId);
                System.out.println("Product deleted");
                displayAllProducts();
            } else {
                System.out.println("Product " + productId + " does not exist");
            }
        } else {
            System.out.println("Only admins can delete products");
        }
    }

    public void displayAllProducts() {
        productService.displayAllProducts();
    }
}
