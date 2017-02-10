package de.egga.hexagon.persistence;

import de.egga.hexagon.posts.Post;
import de.egga.hexagon.posts.PostRepository;
import de.egga.hexagon.posts.UserId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SimplePostRepository implements PostRepository {

    private final List<Post> posts = new ArrayList<>();

    @Override
    public void deleteUsersPosts(UserId id) {
        posts.clear();
    }

    @Override
    public List<Post> getUsersPosts(UserId id) {
        return posts;
    }

    @Override
    public void add(Post post) {
        posts.add(post);
    }
}
