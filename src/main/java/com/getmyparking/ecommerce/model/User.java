package com.getmyparking.ecommerce.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.Date;

@Getter
public class User {

    private int id;
    private String name;
    private String[] address;
    private Date dateOfBirth;
    private Role userRole;
    private boolean isLoggedIn;

    public User(int id, String name, String[] address, Date dateOfBirth, Role userRole) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.userRole = userRole;
        this.isLoggedIn = true;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + Arrays.toString(address) +
                ", dateOfBirth=" + dateOfBirth +
                ", userRole=" + userRole +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
