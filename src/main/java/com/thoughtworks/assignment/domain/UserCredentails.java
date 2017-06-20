package com.thoughtworks.assignment.domain;

/**
 * Created by vrushali on 6/19/17.
 */
public class UserCredentails {

    private String username;
    private String password;

    private UserCredentails() {}

    public UserCredentails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
