package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.domain.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/19/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Resource
    private TestEntityManager testEntityManager;

    @Resource
    private UserRepository userRepository;

    @Test
    public void shouldReturnUserWhenFindByUsername() throws Exception {
        //given
        User user = new User("test", "test_mail@test.com", "username",  "address", "password", 9999, UserType.BUYER);
        testEntityManager.persist( user);
        testEntityManager.flush();

        //when
        final User byUsername = userRepository.findByUsername("username");

        //then
        assertNotNull( byUsername);
        assertEquals( user.getName(),byUsername.getName());
    }

    @Test
    public void findByEmail() throws Exception {
        //given
        User user = new User("test", "test_mail@test.com", "username",  "address", "password", 9999, UserType.BUYER);
        testEntityManager.persist( user);
        testEntityManager.flush();

        //when
        final User byUsername = userRepository.findByEmail("test_mail@test.com");

        //then
        assertNotNull( byUsername);
        assertEquals( user.getName(),byUsername.getName());
    }

}