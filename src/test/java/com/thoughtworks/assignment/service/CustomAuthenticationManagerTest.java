package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.domain.UserType;
import com.thoughtworks.assignment.repository.UserBaseRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by vrushali on 6/19/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomAuthenticationManagerTest {

    @InjectMocks
    private CustomAuthenticationManager manager = new CustomAuthenticationManager();

//    @MockBean
//    private StandardPasswordEncoder encoder;

    @Mock
    private UserBaseRepository userRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this.getClass());
    }

    @Test
    @Ignore
    public void shouldAuthenticate() throws Exception {

        final User user = new User("test", "test_mail@test.com", "username", "address", "abcx", 9999, UserType.BUYER);
        when( userRepository.findByUsername(anyString())).thenReturn( user);
       // when( encoder.encode(anyString())).thenReturn("abcx");
//        final User authenticate = manager.authenticate(new UserCredentails("username", "password"));
//        assertNotNull( authenticate);
    }

}