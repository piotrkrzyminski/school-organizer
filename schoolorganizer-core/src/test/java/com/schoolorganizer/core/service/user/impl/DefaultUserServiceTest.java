package com.schoolorganizer.core.service.user.impl;

import com.schoolorganizer.core.exceptions.UserNotFoundException;
import com.schoolorganizer.core.repository.user.UserRepository;
import com.schoolorganizer.model.user.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Test for {@link DefaultUserService}
 *
 * @author Piotr Krzyminski
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultUserServiceTest {

    private final static String EMAIL = "email@test.com";
    private final static String EMAIL_NOT_EXISTS = "not_exists@email.com";
    private final static String PASSWORD = "qwerty";

    @InjectMocks
    private DefaultUserService userService;

    @Mock
    private UserRepository userRepository;

    private UserModel user;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        user = new UserModel();
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);

        when(userRepository.findByEmail(EMAIL)).thenReturn(user);
        when(userRepository.findByEmail(EMAIL_NOT_EXISTS)).thenReturn(null);
    }

    /**
     * Test get user for email when it is exists in datasource.
     * This should return user with specified email.
     */
    @Test
    public void testGetUserForEmailWhenExists() throws UserNotFoundException {
        UserModel result = userService.getUserForEmail(EMAIL);

        assertNotNull(result);
        assertEquals(user, result);
    }

    /**
     * Test get user for email when it is not exists in datasource.
     * This should throw exception {@link UserNotFoundException}.
     */
    @Test(expected = UserNotFoundException.class)
    public void testGetUserForEmailWhenNotExists() throws UserNotFoundException {
        userService.getUserForEmail(EMAIL_NOT_EXISTS);
    }
}