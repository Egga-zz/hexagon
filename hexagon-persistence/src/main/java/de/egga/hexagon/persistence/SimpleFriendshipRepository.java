package de.egga.hexagon.persistence;

import de.egga.hexagon.friendships.FriendshipRepository;
import de.egga.hexagon.posts.UserId;
import de.egga.hexagon.users.User;
import de.egga.hexagon.users.UserNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleFriendshipRepository implements FriendshipRepository {

    private final Map<UserId, Set<User>> friends = new HashMap<>();

    @Override
    public Set<User> getFriendsOf(User user) {
        Set<User> usersFriends = friends.get(user.getId());

        if (usersFriends == null) {
            throw new UserNotFoundException(user.getId().getValue());
        }

        return usersFriends;
    }

    @Override
    public void add(User userA, User userB) {
        addFriendship(userA, userB);
        addFriendship(userB, userA);
    }


    private void addFriendship(User userA, User userB) {
        ensureFriendsListFor(userA);
        this.friends.get(userA.getId()).add(userB);
    }

    private void ensureFriendsListFor(User userA) {
        if (!friends.containsKey(userA)) {
            friends.put(userA.getId(), new HashSet<>());
        }
    }
}
