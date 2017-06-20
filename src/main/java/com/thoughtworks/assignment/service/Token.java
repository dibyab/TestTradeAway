package com.thoughtworks.assignment.service;

import java.util.Date;

/**
 * Created by vrushali on 6/19/17.
 */
public class Token {

    private String accessToken;
    private Date expirationTime;

    public Token(String accessToken, Date expirationTime) {
        this.accessToken = accessToken;
        this.expirationTime = expirationTime;
    }

    public boolean doesAccessTokenMatch( String other){
        return this.accessToken.equals( other);
    }
}
