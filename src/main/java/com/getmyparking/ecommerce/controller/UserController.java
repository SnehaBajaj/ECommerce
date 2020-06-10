package com.getmyparking.ecommerce.controller;

import com.getmyparking.ecommerce.model.Role;
import com.getmyparking.ecommerce.model.User;
import com.getmyparking.ecommerce.service.UserService;

import java.util.Date;
import java.util.Scanner;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    Scanner sc = new Scanner(System.in);

    public void createUser(){
        System.out.println("Enter user name");
        String name = sc.nextLine();
        System.out.println("Enter user role: ADMIN/REGULAR");
        String role = sc.nextLine();
        int userCount = userService.countUsers();
        String[] address = new String[]{" ", " "};
        userService.create(new User(userCount+1, name, address, new Date(), Role.valueOf(role)));
    }

    public void login() {
        System.out.println("Enter user name");
        String name = sc.nextLine();
        userService.login(name);
    }

    public void logout() {
        System.out.println("Enter user name");
        String name = sc.nextLine();
        userService.logout(name);
    }

    public boolean checkAdmin(){
        return userService.checkAdmin();
    }
}
