package de.egga.hexagon.posts;


import de.egga.hexagon.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static de.egga.hexagon.users.UserFactory.randomId;
import static de.egga.hexagon.users.UserFactory.randomUser;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private final UserId anyId = randomId();


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

    @Test
    public void user_sees_friends_post() {
        User userA = randomUser();
        User userB = randomUser();



        Post post = new Post();
        service.post(post);

    }


}