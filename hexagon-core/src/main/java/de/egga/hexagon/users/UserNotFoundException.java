package de.egga.hexagon.users;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String value) {
        super("User ID [" + value + "]");
    }
}
