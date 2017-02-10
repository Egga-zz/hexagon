package de.egga.hexagon.posts;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public void deleteAll(UserId id) {
        posts.clear();
    }

    public List<Post>  getAllPosts(UserId id) {
        return posts;
    }

    public void post(Post post) {
        posts.add(post);
    }
}
