package de.egga.hexagon.timeline;


import de.egga.hexagon.friendships.FriendshipService;
import de.egga.hexagon.posts.Post;
import de.egga.hexagon.posts.PostService;
import de.egga.hexagon.users.User;

import java.util.List;
import java.util.Set;

public class TimeLineService {

    private final FriendshipService friendshipService;
    private final PostService postService;

    public TimeLineService(FriendshipService friendshipService, PostService postService) {
        this.friendshipService = friendshipService;
        this.postService = postService;
    }

    public TimeLine getTimeLine(User user) {

        TimeLine timeLine = new TimeLine();

        Set<User> friends = friendshipService.getFriends(user);
        for (User friend : friends) {
            List<Post> friendsPosts = postService.getAllPosts(friend.getId());
            timeLine.addPosts(friendsPosts);
        }

        return timeLine;
    }
}
