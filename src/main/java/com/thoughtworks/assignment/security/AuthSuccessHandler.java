package com.thoughtworks.assignment.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.assignment.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vrushali on 6/20/17.
 */
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final ObjectMapper mapper;

    @Autowired
    AuthSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
        this.mapper = messageConverter.getObjectMapper();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
//        UserDetails userDetails = (User) authentication.getPrincipal();
//        User user = userDetails.
//        userDetails.setUser(user);
//
//        LOGGER.info(userDetails.getUsername() + " got is connected ");
//
//        PrintWriter writer = response.getWriter();
//        mapper.writeValue(writer, user);
//        writer.flush();
    }
}
