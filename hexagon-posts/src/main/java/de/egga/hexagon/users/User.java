package de.egga.hexagon.users;

import de.egga.hexagon.posts.UserId;

public class User {

    private final UserId id;

    User(UserId id) {
        this.id = id;
    }

    UserId getId() {
        return id;
    }
}
