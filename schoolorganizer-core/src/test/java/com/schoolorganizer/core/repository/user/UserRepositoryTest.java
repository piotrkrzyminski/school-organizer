package com.schoolorganizer.core.repository.user;

import com.schoolorganizer.model.user.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Test for {@link UserRepository}
 *
 * @author Piotr Krzyminski
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@SpringBootTest
@EntityScan(basePackages = {"com.schoolorganizer.model"})
@EnableJpaRepositories(basePackages = {"com.schoolorganizer.core.repository"})
public class UserRepositoryTest {

    private static final String EMAIL = "email@test.com";
    private static final String PASSWORD = "qwerty";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    /**
     * Dummy user configuration. Insert user to database.
     */
    @Before
    public void init() {
        UserModel user = new UserModel();
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);

        entityManager.persist(user);
        entityManager.flush();
    }

    /**
     * Test find user using unique email, when exists in datasource.
     * If user exists in datasource then should return only one user because it is unique value.
     * Otherwise if user not exists then should return null.
     */
    @Test
    public void testFindUserByEmail() {
        UserModel foundUser = userRepository.findByEmail(EMAIL);

        assertNotNull(foundUser);
    }

    /**
     * Test find user by unique email when not exists in datasource.
     * When user not exists in datasource, repository should return null.
     */
    @Test
    public void testFindUserByEmailWhenNotExists() {
        UserModel foundUser = userRepository.findByEmail("no_email@test.com");

        assertNull(foundUser);
    }

    @SpringBootApplication
    static class TestConfiguration {
        //empty
    }
}