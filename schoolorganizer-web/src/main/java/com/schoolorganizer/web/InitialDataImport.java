package com.schoolorganizer.web;

import com.schoolorganizer.core.repository.user.UserRepository;
import com.schoolorganizer.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * This class is used to save to database example data when application is launched.
 *
 * @author Piotr Krzyminski
 */
@Component
public class InitialDataImport implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        UserModel user = new UserModel();
        user.setEmail("timmy@test.com");
        user.setPassword("qwerty");

        userRepository.save(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
