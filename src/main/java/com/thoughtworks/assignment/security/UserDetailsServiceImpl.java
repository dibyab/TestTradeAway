package com.thoughtworks.assignment.security;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.repository.UserBaseRepository;
import com.thoughtworks.assignment.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * Created by vrushali on 6/20/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Assert.notNull( userName,"username should not be null");
        final User byUsername = userRepository.findByUsername(userName);
        if( null == byUsername) {
            throw new UsernameNotFoundException(userName);
        }
        return new org.springframework.security.core.userdetails.User(byUsername.getUsername(),byUsername.getPassword(),new HashSet<>());
    }
}
