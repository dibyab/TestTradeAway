package com.thoughtworks.assignment.config;

import com.thoughtworks.assignment.security.AuthFailureHandler;
import com.thoughtworks.assignment.security.AuthSuccessHandler;
import com.thoughtworks.assignment.security.HttpAuthenticationEntryPoint;
import com.thoughtworks.assignment.security.HttpLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/**
 * Created by vrushali on 6/19/17.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(value = "com.thoughtworks.assignment.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    public static final String ROOT = "/user";
    public static final String LOGIN = "/login";
    private static final String LOGIN_PATH =  LOGIN;


    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private StandardPasswordEncoder standardPasswordEncoder;

    @Resource
    private HttpAuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AuthSuccessHandler authSuccessHandler;

    @Resource
    private AuthFailureHandler authFailureHandler;
    @Resource
    private HttpLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
     //   authenticationProvider.setPasswordEncoder(standardPasswordEncoder);

        return authenticationProvider;
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/").permitAll() // TODO : check whether USER_ROLE
//                .antMatchers("/testLogin").permitAll()
//                .antMatchers(HttpMethod.POST,"/user").permitAll()
//                .and().csrf().disable();

            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/**").permitAll()
                    .antMatchers("/favicon.ico").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .and()
                    .formLogin()
                    .permitAll()
                    .loginProcessingUrl(LOGIN_PATH)
                    .successHandler(authSuccessHandler)
                    .failureHandler(authFailureHandler)
                    .and()
                    .logout()
                    .permitAll()
                    .logoutRequestMatcher(new AntPathRequestMatcher(LOGIN_PATH, "DELETE"))
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .and()
                    .sessionManagement()
                    .maximumSessions(1);

            http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public StandardPasswordEncoder passwordEncoder() {
        StandardPasswordEncoder bCryptPasswordEncoder = new StandardPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
