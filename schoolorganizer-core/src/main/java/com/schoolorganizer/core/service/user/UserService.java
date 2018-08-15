package com.schoolorganizer.core.service.user;

import com.schoolorganizer.core.exceptions.UserNotFoundException;
import com.schoolorganizer.model.user.UserModel;

/**
 * Service for {@link com.schoolorganizer.model.user.UserModel}
 *
 * @author Piotr Krzyminski
 */
public interface UserService {

    /**
     * Get user with specified email.
     *
     * @param email email to find.
     * @return user with specified email.
     * @throws UserNotFoundException user with specified email was not found.
     */
    UserModel getUserForEmail(final String email) throws UserNotFoundException;

    /**
     * Saves new user to datasource. If user with specified email already exists then do nothing.
     *
     * @param user user to save.
     */
    void save(UserModel user);
}
