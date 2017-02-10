package de.egga.hexagon.users;

import de.egga.hexagon.posts.UserId;

public class User {

    private final UserId id;

    public User(UserId id) {
        this.id = id;
    }

    public UserId getId() {
        return id;
    }
}
