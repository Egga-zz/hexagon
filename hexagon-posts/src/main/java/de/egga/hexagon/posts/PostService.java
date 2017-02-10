package de.egga.hexagon.posts;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public void deleteAll(UserId id) {
        repository.deleteUsersPosts(id);
    }

    public List<Post>  getAllPosts(UserId id) {
        return repository.getUsersPosts(id);
    }

    public void post(Post post) {
        repository.add(post);

    }
}
