package de.egga.hexagon.persistence;


import de.egga.hexagon.users.User;
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
        assertThat(friendsOf(userA)).containsExactly(userB);
    }

    @Test
    public void user_b_has_a_as_friend() {
        repository.add(userA, userB);
        assertThat(friendsOf(userA)).containsExactly(userB);
    }

    @Test
    public void non_registered_user_returns_empty_set() {
        assertThat(friendsOf(randomUser())).isEmpty();

    }

    @Test
    public void user_a_has_b_not_as_friend_anymore() {
        repository.add(userA, userB);
        repository.remove(userA, userB);
        assertThat(friendsOf(userA)).doesNotContain(userB);
    }

    @Test
    public void user_b_has_a_not_as_friend_anymore() {
        repository.add(userA, userB);
        repository.remove(userA, userB);
        assertThat(friendsOf(userA)).doesNotContain(userB);
    }


    private Set<User> friendsOf(User user) {
        return repository.getFriendsOf(user);
    }
}