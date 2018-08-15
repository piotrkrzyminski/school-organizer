package com.schoolorganizer.web;

import com.schoolorganizer.core.exceptions.UserNotFoundException;
import com.schoolorganizer.core.service.user.UserService;
import com.schoolorganizer.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * This is custom authentication provider performing login authentication.
 *
 * @author Piotr Krzyminski
 */
@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            UserModel user = getUserService().getUserForEmail(email);

            if (!user.getPassword().equals(password))
                throw new BadCredentialsException("Bad email or password");

        } catch (UserNotFoundException e) {
            throw new BadCredentialsException("Bad email or password");
        }

        return new UsernamePasswordAuthenticationToken(email, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
