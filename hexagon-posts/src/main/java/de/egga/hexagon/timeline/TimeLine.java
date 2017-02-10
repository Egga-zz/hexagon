package de.egga.hexagon.timeline;

import de.egga.hexagon.posts.Post;

import java.util.ArrayList;
import java.util.List;

public class TimeLine {

    private final ArrayList<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public void addPosts(List<Post> friendsPosts) {
        posts.addAll(friendsPosts);
    }
}
