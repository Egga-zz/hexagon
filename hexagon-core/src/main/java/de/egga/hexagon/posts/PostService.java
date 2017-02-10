package de.egga.hexagon.posts;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void deleteAll(UserId id) {
        postRepository.deleteUsersPosts(id);
    }

    public List<Post>  getAllPosts(UserId id) {
        return postRepository.getUsersPosts(id);
    }

    public void post(Post post) {
        postRepository.add(post);
    }
}
