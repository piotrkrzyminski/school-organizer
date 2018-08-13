package com.schoolorganizer.core.service.user;

import com.schoolorganizer.core.exceptions.UserNotFoundException;
import com.schoolorganizer.model.user.UserModel;

/**
 * Service for {@link com.schoolorganizer.model.user.UserModel}
 *
 * @author Piotr Krzyminski
 */
public interface UserService {

    UserModel getUserForEmail(final String email) throws UserNotFoundException;
}
