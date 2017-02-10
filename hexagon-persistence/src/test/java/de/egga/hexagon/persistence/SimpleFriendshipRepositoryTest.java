package de.egga.hexagon.persistence;


import de.egga.hexagon.users.User;
import de.egga.hexagon.users.UserNotFoundException;
import org.junit.Test;

import java.util.Set;

import static de.egga.hexagon.users.UserFactory.randomUser;
import static org.assertj.core.api.Assertions.assertThat;

public class SimpleFriendshipRepositoryTest {

    SimpleFriendshipRepository repository = new SimpleFriendshipRepository();

    User userA = randomUser();
    User userB = randomUser();

    @Test
    public void user_a_has_b_as_friend() {
        repository.add(userA, userB);
        Set<User> friends = repository.getFriendsOf(userA);
        assertThat(friends).containsExactly(userB);
    }

    @Test
    public void user_b_has_a_as_friend() {
        repository.add(userA, userB);
        Set<User> friends = repository.getFriendsOf(userA);
        assertThat(friends).containsExactly(userB);
    }

    @Test(expected = UserNotFoundException.class)
    public void asking_for_non_existent_user_yields_exception()  {
        repository.getFriendsOf(randomUser());

    }
}