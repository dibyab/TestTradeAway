package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.domain.UserType;
import com.thoughtworks.assignment.repository.UserRepository;
import com.thoughtworks.assignment.validator.UserValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.Max;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/16/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidator userValidator;

    @Test
    public void shouldBeAbleToSave() throws Exception {
        User user = new User("name", "email", "username", "address", "password", 8888888, UserType.BUYER);
        user.setId(1);
        Mockito.when( userRepository.save(user)).thenReturn( user);
        User expected = service.register(user);
        assertEquals( expected.getId(),user.getId());
    }

}