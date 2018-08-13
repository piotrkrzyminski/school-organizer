package com.schoolorganizer.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * A model that stores data used during user authentication.
 *
 * @author Piotr Krzyminski
 */
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", unique = true)
    @NotEmpty
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
