package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.controller.dto.UserRegistration;
import com.thoughtworks.assignment.domain.Buyer;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.UserType;
import com.thoughtworks.assignment.service.UserService;
import com.thoughtworks.assignment.validator.RegistrationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * Created by vrushali on 6/16/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    public static final Function<UserRegistration, Buyer> registrationBuyerFunction = registration -> {

        Buyer user = new Buyer(registration.getName(),
                registration.getEmail(),
                registration.getUsername(),
                registration.getAddress(),
                registration.getPassword(),
                registration.getMobile());
        return user;
    };

    public static final Function<UserRegistration, Seller> registrationSellerFunction = registration -> {

        Seller user = new Seller(registration.getName(),
                registration.getEmail(),
                registration.getUsername(),
                registration.getAddress(),
                registration.getPassword(),
                registration.getMobile());
        return user;
    };

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void register( @RequestBody UserRegistration registration) throws RegistrationFailedException {

        if( UserType.BUYER == registration.getType()){

            final Buyer buyer = registrationBuyerFunction.apply(registration);
            buyer.setGender(registration.getGender());
            buyer.setDateOfBirth(registration.getDateOfBirth());
            userService.register(buyer);

        } else {
            final Seller seller = registrationSellerFunction.apply(registration);
            seller.setMonthExperience(registration.getMonthExperience());
            seller.setYearExperience(registration.getYearExperience());
            seller.setPanNumber(registration.getPanNumber());
            userService.register(seller);
        }
    }

}
