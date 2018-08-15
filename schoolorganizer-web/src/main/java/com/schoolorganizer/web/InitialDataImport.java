package com.schoolorganizer.web;

import com.schoolorganizer.core.service.user.UserService;
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

    private UserService userService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        UserModel user = new UserModel();
        user.setEmail("timmy@test.com");
        user.setPassword("qwerty");
      
        userService.save(user);
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
