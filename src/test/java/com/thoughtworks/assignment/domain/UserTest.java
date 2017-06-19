package com.thoughtworks.assignment.domain;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vrushali on 6/16/17.
 */
public class UserTest {

    @Test
    public void shouldCreateUser() {
        assertNotNull( new User("name", "email", "username", "address", "password", 8888888, UserType.BUYER));


    }

}