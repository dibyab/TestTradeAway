package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.validator.RegistrationFailedException;

/**
 * Created by vrushali on 6/16/17.
 */
public interface UserService {

    User register(User user) throws RegistrationFailedException;
}
