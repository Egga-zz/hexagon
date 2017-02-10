package de.egga.hexagon.posts;


import de.egga.hexagon.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static de.egga.hexagon.posts.PostFactory.randomPost;
import static de.egga.hexagon.users.UserFactory.randomUser;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private final User randomUser = randomUser();


    @Mock
    PostRepository repository;

    @InjectMocks
    PostService service;


    @Test
    public void delete_all_triggers_repository() {
        service.deleteAll(randomUser.getId());
        verify(repository).deleteUsersPosts(randomUser.getId());
    }

    @Test
    public void get_all_returns_users_posts() {
        Post post = randomPost();
        when(repository.getUsersPosts(randomUser.getId())).thenReturn(asList(post));
        List<Post> allPosts = service.getAllPosts(randomUser.getId());
        assertThat(allPosts).containsExactly(post);
    }

    @Test
    public void post_gets_persisted() {
        Post post = randomPost();
        service.post(post);
        verify(repository).add(post);
    }
}