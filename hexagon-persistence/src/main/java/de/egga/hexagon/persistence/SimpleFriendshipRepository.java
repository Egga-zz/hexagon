package de.egga.hexagon.persistence;

import de.egga.hexagon.friendships.FriendshipRepository;
import de.egga.hexagon.users.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptySet;

public class SimpleFriendshipRepository implements FriendshipRepository {

    private final Map<User, Set<User>> friendsOf = new HashMap<>();

    @Override
    public Set<User> getFriendsOf(User user) {
        Set<User> usersFriends = friendsOf.get(user);

        if (usersFriends == null) {
            return emptySet();
        }

        return usersFriends;
    }

    @Override
    public void remove(User user, User exfriend) {
        if (isRegistered(user)) {
            Set<User> friends = friendsOf.get(user);
            friends.remove(exfriend);
        }
    }

    @Override
    public void add(User userA, User userB) {
        addFriendship(userA, userB);
        addFriendship(userB, userA);
    }


    private void addFriendship(User userA, User userB) {
        ensureFriendsListFor(userA);
        friendsOf.get(userA).add(userB);
    }

    private boolean isRegistered(User user) {
        return friendsOf.containsKey(user);
    }

    private void ensureFriendsListFor(User user) {
        if (!isRegistered(user)) {
            friendsOf.put(user, new HashSet<>());
        }
    }
}
