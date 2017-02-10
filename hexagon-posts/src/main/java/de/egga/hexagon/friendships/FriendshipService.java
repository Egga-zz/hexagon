package de.egga.hexagon.friendships;

import de.egga.hexagon.users.User;

import java.util.Set;

public class FriendshipService {

    private final FriendshipRepository repository;

    public FriendshipService(FriendshipRepository repository) {
        this.repository = repository;
    }

    public void addFriendship(User userA, User userB) {
        repository.add(userA, userB);
    }

    public Set<User> getFriends(User user) {
        return repository.getFriendsOf(user);
    }
}
