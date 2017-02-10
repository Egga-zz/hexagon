package de.egga.hexagon.timeline;


import de.egga.hexagon.friendships.FriendshipRepository;
import de.egga.hexagon.friendships.FriendshipService;
import de.egga.hexagon.posts.Post;
import de.egga.hexagon.posts.PostRepository;
import de.egga.hexagon.posts.PostService;
import de.egga.hexagon.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.collect.Sets.newHashSet;
import static de.egga.hexagon.users.UserFactory.randomUser;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeLineServiceTest {

    @Mock FriendshipRepository friendshipRepository;
    @Mock PostRepository postRepository;

    @InjectMocks FriendshipService friendshipService;
    @InjectMocks PostService postService;

    @InjectMocks TimeLineService service;


    @Test
    public void user_sees_friends_post() {
        User userA = randomUser();
        User userB = randomUser();
        when(friendshipRepository.getFriendsOf(userA)).thenReturn(newHashSet(userB));

        Post post = new Post(userA);
        when(postRepository.getUsersPosts(userA.getId())).thenReturn(asList(post));

        TimeLine timeLine = service.getTimeLine(userB);

        assertThat(timeLine.getPosts()).containsExactly(post);

    }
}