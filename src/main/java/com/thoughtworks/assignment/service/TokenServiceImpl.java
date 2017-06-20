package com.thoughtworks.assignment.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by vrushali on 6/19/17.
 */
@Service
public class TokenServiceImpl implements TokenService{

    private List<Token> tokenList;

    @Override
    public Token createToken() {
        final double random = Math.random();
        return new Token("token-"+random,new Date());
    }

    @Override
    public boolean validate(String token) {
      return tokenList.stream().filter(token1 -> token1.doesAccessTokenMatch( token)).findAny().isPresent();
    }
}
