package com.thoughtworks.assignment.interceptor;

import com.thoughtworks.assignment.service.TokenService;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vrushali on 6/19/17.
 */
@Component
public class OauthInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    private static final String ACCESS_TOKEN_HEADER = "access_token";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        final String accessToken = httpServletRequest.getHeader(ACCESS_TOKEN_HEADER);
        if(StringUtils.isEmpty( accessToken)){
            throw new AuthorizationServiceException("Token is empty");
        }

        if( !tokenService.validate( accessToken)){
            throw new AuthorizationServiceException("Token is not valid");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
