package de.egga.hexagon.posts;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostServiceTest {

    private final UserId anyId = new UserId("some-user");
    PostService service = new PostService();

    @Test
    public void user_has_no_posts_after_delete_all() {
        service.deleteAll(anyId);
        List<Post> allPosts = service.getAllPosts(anyId);
        assertThat(allPosts).isEmpty();
    }

    @Test
    public void user_has_post_after_posting() {
        Post post = new Post();
        service.post(post);
        List<Post> allPosts = service.getAllPosts(anyId);
        assertThat(allPosts).containsExactly(post);
    }
}