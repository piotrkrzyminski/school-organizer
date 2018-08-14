package com.schoolorganizer.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class stores configuration for spring security module.
 *
 * @author Piotr Krzyminski
 */
@Configuration
public class WebApplicationConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .anyRequest().authenticated()
                .and().formLogin().permitAll();
    }
}
