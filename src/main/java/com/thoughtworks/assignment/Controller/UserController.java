package com.thoughtworks.assignment.Controller;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.dto.UserDTO;
import com.thoughtworks.assignment.dto.UserRegistration;
import com.thoughtworks.assignment.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * Created by vrushali on 6/16/17.
 */
@RestController("/user")
public class UserController {

    @Resource
    private UserService userService;

    private Function<UserRegistration, User> registrationUserFunction = registration -> {

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

    private Function<User, UserDTO> userUserDTOFunction = user -> {

        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setAddress(user.getAddress());
        dto.setMobile(user.getMobile());
        dto.setType(user.getType());

        user.setPanNumber(user.getPanNumber());
        user.setDateOfBirth(user.getDateOfBirth());
        user.setMonthExperience(user.getMonthExperience());
        user.setYearExperience(user.getYearExperience());
        user.setGender(user.getGender());
        return dto;
    };

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDTO create(@RequestBody UserRegistration registration) {
        return userUserDTOFunction.apply(userService.save(registrationUserFunction.apply(registration)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "{\"status\" : \"welcome\"}";
    }


}
