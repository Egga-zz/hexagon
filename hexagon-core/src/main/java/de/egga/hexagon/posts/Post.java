package de.egga.hexagon.posts;

import de.egga.hexagon.users.User;

public class Post {

    private final PostId id;
    private final User user;
    private final String message;


    public Post(PostId id, User user, String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
