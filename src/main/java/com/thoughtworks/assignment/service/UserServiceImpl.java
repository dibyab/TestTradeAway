package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Buyer;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.repository.BuyerBaseRepository;
import com.thoughtworks.assignment.repository.SellerBaseRepository;
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
    private SellerBaseRepository sellerRepository;

    @Resource
    private BuyerBaseRepository buyerRepository;

    @Resource
    private UserValidator userValidator;

    @Override
    public void register(User user) throws RegistrationFailedException {
        userValidator.validate( user);
        if( user.isSeller()){
            sellerRepository.save((Seller) user);
        } else {
            buyerRepository.save((Buyer)user);
        }
    }
}
