package de.egga.hexagon.friendships;


import de.egga.hexagon.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static de.egga.hexagon.users.UserFactory.randomUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FriendshipServiceTest {

    @Mock
    FriendshipRepository repository;

    @InjectMocks
    FriendshipService service;

    User userA = randomUser();
    User userB = randomUser();

    @Test
    public void new_friendships_are_persisted() {
        service.addFriendship(userA, userB);
        verify(repository).add(userA, userB);
    }

    @Test
    public void users_can_be_friends() {
        when(repository.getFriendsOf(userA)).thenReturn(newHashSet(userB));
        Set<User> friends = service.getFriends(userA);
        assertThat(friends).containsExactly(userB);
    }
}