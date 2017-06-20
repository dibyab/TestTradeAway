package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.repository.UserRepository;
import com.thoughtworks.assignment.validator.UserValidator;
import com.thoughtworks.assignment.validator.RegistrationFailedException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by vrushali on 6/16/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserValidator userValidator;

    @Override
    public User register(User user) throws RegistrationFailedException {
        userValidator.validate( user);
        return userRepository.save(user);
    }
}
