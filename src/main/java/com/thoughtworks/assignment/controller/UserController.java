package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.controller.dto.UserDTO;
import com.thoughtworks.assignment.controller.dto.UserRegistration;
import com.thoughtworks.assignment.service.UserService;
import com.thoughtworks.assignment.validator.RegistrationFailedException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.function.Function;

/**
 * Created by vrushali on 6/16/17.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    public static final Function<UserRegistration, User> registrationUserFunction = registration -> {

        User user = new User(registration.getName(),
                registration.getEmail(),
                registration.getUsername(),
                registration.getAddress(),
                registration.getPassword(),
                registration.getMobile(),
                registration.getType());

        user.setPanNumber(registration.getPanNumber());
        user.setDateOfBirth(registration.getDateOfBirth());
        user.setMonthExperience(registration.getMonthExperience());
        user.setYearExperience(registration.getYearExperience());
        user.setGender(registration.getGender());
        return user;
    };

    public static final Function<User, UserDTO> userUserDTOFunction = user -> {

        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setAddress(user.getAddress());
        dto.setMobile(user.getMobile());
        dto.setType(user.getType());

        dto.setPanNumber(user.getPanNumber());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setMonthExperience(user.getMonthExperience());
        dto.setYearExperience(user.getYearExperience());
        dto.setGender(user.getGender());
        return dto;
    };

    @RequestMapping(value = "/user",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDTO register( @RequestBody UserRegistration registration) throws RegistrationFailedException {
        return userUserDTOFunction.apply(userService.register(registrationUserFunction.apply(registration)));
    }

}
