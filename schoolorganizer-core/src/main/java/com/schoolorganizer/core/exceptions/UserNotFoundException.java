package com.schoolorganizer.core.exceptions;

/**
 * Exception thrown when trying to find user that not exists in datasource.
 *
 * @author Piotr Krzyminski
 */
public class UserNotFoundException extends Throwable {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
