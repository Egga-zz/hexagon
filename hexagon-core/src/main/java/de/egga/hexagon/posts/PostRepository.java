package de.egga.hexagon.posts;

import de.egga.hexagon.users.UserId;

import java.util.List;

public interface PostRepository {


    void deleteAllPosts();

    List<Post> getUsersPosts(UserId id);

    void add(Post post);
}
