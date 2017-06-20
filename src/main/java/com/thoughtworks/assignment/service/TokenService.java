package com.thoughtworks.assignment.service;

/**
 * Created by vrushali on 6/19/17.
 */
public interface TokenService {

    Token createToken();

    boolean validate( String token);
}
