package de.egga.hexagon.posts;

import java.util.List;

public interface PostRepository {


    void deleteUsersPosts(UserId id);

    List<Post> getUsersPosts(UserId id);

    void add(Post post);
}
