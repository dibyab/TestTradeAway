package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.domain.UserCredentails;
import com.thoughtworks.assignment.repository.UserBaseRepository;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * Created by vrushali on 6/19/17.
 */
@Component
public class CustomAuthenticationManager {

    @Resource
    private UserBaseRepository userRepository;

    @Resource
    private StandardPasswordEncoder standardPasswordEncoder;

    @Resource
    private TokenService tokenService;

    public Token authenticate(UserCredentails userCredentails) {

        Assert.notNull(userCredentails,"Credetials are empty");

        final User byUsername = userRepository.findByUsername(userCredentails.getUsername());

        if( null == byUsername){
            throw new UsernameNotFoundException("Could not findBySeller user with username: "+ userCredentails.getUsername());
        }

        if( !standardPasswordEncoder.encode( userCredentails.getPassword()).equals( byUsername.getPassword())){
            throw new AuthenticationServiceException("Username or password is incorrect");
        }

        return tokenService.createToken();

    }

}
