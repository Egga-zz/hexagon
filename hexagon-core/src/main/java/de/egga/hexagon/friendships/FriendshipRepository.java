package de.egga.hexagon.friendships;

import de.egga.hexagon.users.User;

import java.util.Set;

public interface FriendshipRepository {

    void add(User userA, User userB);

    Set<User> getFriendsOf(User user);

    void remove(User user, User exfriend);
}
