package com.schoolorganizer.core.service.user.impl;

import com.schoolorganizer.core.exceptions.UserNotFoundException;
import com.schoolorganizer.core.repository.user.UserRepository;
import com.schoolorganizer.core.service.user.UserService;
import com.schoolorganizer.model.user.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default implementation of {@link UserService}
 *
 * @author Piotr Krzyminski
 */
@Service("userService")
public class DefaultUserService implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

    private UserRepository userRepository;

    @Override
    public UserModel getUserForEmail(String email) throws UserNotFoundException {

        LOG.debug("Searching for user with email " + email);

        UserModel user = getUserRepository().findByEmail(email);
        if (user == null) {
            LOG.debug("User with email " + email + " not found");
            throw new UserNotFoundException("User with email " + email + " not found");
        }

        return user;
    }

    @Override
    public void save(UserModel user) {

        UserModel result = userRepository.findByEmail(user.getEmail());
        if (result == null) {
            LOG.debug("Saving new user");
            userRepository.save(user);
        } else {
            LOG.debug("User with " + user.getEmail() + " already exists. Cannot add another user with the same email");
        }
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
