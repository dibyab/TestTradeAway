package com.thoughtworks.assignment.validator;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.repository.UserBaseRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by vrushali on 6/19/17.
 */
@Component
public class UserValidator{

    @Resource
    private UserBaseRepository userRepository;

    public void validate( User user) throws RegistrationFailedException {

        if( userRepository.findByUsername( user.getUsername()) != null) {
            throw new RegistrationFailedException( RegistrationErrorCode.USERNAME_ALREADY_EXIST,"username already taken");
        }

        if( userRepository.findByEmail( user.getEmail()) != null) {
            throw new RegistrationFailedException( RegistrationErrorCode.EMAIL_ALREADY_TAKEN,"email id already exist");
        }
    }
}
