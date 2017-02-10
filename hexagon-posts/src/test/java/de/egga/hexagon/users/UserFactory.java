package de.egga.hexagon.users;

import de.egga.hexagon.posts.UserId;

import static java.util.UUID.randomUUID;

public class UserFactory {

    public static User randomUser() {
        return new User(randomId());
    }

    public static UserId randomId() {
        return new UserId(randomUUID().toString());
    }

}
