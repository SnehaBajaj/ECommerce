package com.getmyparking.ecommerce.controller;

import com.getmyparking.ecommerce.exception.InvalidRoleException;
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
        System.out.println("Enter user role: " + Role.ADMIN.name()+"/"+Role.REGULAR.name());
        String role = sc.nextLine();
        Role userRole;
        try {
            userRole = Role.valueOf(role);
        } catch (IllegalArgumentException e) {
            throw new InvalidRoleException("Role must be one of ADMIN or REGULAR");
        }
        int userCount = userService.countUsers();
        String[] address = new String[]{" ", " "};
        userService.create(new User(userCount+1, name, address, new Date(), userRole));
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
