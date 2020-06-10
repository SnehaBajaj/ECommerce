package com.getmyparking.ecommerce;

import com.getmyparking.ecommerce.config.ApplicationConfig;
import com.getmyparking.ecommerce.controller.CartController;
import com.getmyparking.ecommerce.controller.ProductController;
import com.getmyparking.ecommerce.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserController userController = context.getBean(UserController.class);
        ProductController productController = context.getBean(ProductController.class);
        CartController cartController = context.getBean(CartController.class);

        int option;
        do {
            System.out.println("Options:\n" +
                    "1. Sign-up a new user\n" +
                    "2. Log-in\n" +
                    "3. Log-out\n" +
                    "4. Add products\n" +
                    "5. Update products\n" +
                    "6. Delete products\n" +
                    "7. Browse products\n" +
                    "8. Add product to cart\n" +
                    "9. View cart\n" +
                    "10. Checkout\n" +
                    "11. Exit");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    userController.createUser();
                    break;
                case 2:
                    userController.login();
                    break;
                case 3:
                    userController.logout();
                    break;
                case 4:
                    productController.addProduct();
                    break;
                case 5:
                    productController.updateProduct();
                    break;
                case 6:
                    productController.deleteProduct();
                    break;
                case 7:
                    productController.displayAllProducts();
                    break;
                case 8:
                    cartController.addProduct();
                    break;
                case 9:
                    cartController.viewCart();
                    break;
                case 10:
                    cartController.checkout();
                    break;
                case 11:
                    System.out.println("Thank you for using SellMyProduct");
                    return;
            }

        } while (option > 0 && option < 11);

    }
}
