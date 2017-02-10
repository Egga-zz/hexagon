package de.egga.hexagon.posts;

import de.egga.hexagon.users.User;

import static de.egga.hexagon.users.UserFactory.randomUser;
import static java.util.UUID.randomUUID;

public class PostFactory {

    public static Post randomPost() {
        return new Post(randomPostId(), randomUser(), randomMessage());
    }

    public static PostId randomPostId() {
        return new PostId(randomUUID().toString());
    }

    public static String randomMessage() {
        return randomUUID().toString();
    }

    public static Post randomPostOf(User user) {
        return new Post(randomPostId(), user, randomMessage());
    }
}
