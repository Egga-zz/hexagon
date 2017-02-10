package de.egga.hexagon.posts;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private final UserId anyId = new UserId(randomUUID().toString());

    @Mock
    PostRepository repository;

    @InjectMocks
    PostService service;

    @Test
    public void delete_all_triggers_repository() {
        service.deleteAll(anyId);
        verify(repository).deleteUsersPosts(anyId);
    }

    @Test
    public void get_all_returns_users_posts() {
        Post post = new Post();
        when(repository.getUsersPosts(anyId)).thenReturn(asList(post));
        List<Post> allPosts = service.getAllPosts(anyId);
        assertThat(allPosts).containsExactly(post);
    }

    @Test
    public void post_gets_persisted() {
        Post post = new Post();
        service.post(post);
        verify(repository).add(post);
    }
}