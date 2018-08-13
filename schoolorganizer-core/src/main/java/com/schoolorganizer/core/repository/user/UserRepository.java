package com.schoolorganizer.core.repository.user;

import com.schoolorganizer.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link UserModel} entity. Allows to perform basic CRUD operations and find by properties.
 *
 * @author Piotr Krzyminski
 */
public interface UserRepository extends JpaRepository<UserModel, Long> {

    /**
     * Find user in datasource using unique email value.
     *
     * @param email user's email
     * @return user object with specified email.
     */
    UserModel findByEmail(final String email);
}
