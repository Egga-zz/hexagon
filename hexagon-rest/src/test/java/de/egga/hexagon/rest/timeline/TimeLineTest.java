package de.egga.hexagon.rest.timeline;

import de.egga.TestBase;
import org.junit.Before;
import org.junit.Test;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class TimeLineTest extends TestBase {

    String userA = "any-user";
    String userB = "any-friend";

    String post = fixture("post");

    String emptyTimeLine = "{\"posts\":[]}";
    String timeline = fixture("timeline");


    @Before
    public void setUp() {
        delete("/users/{userId}/posts", userA);

    }


    @Test
    public void user_can_see_friends_post_on_timeline() {

        makePost(userA, post);
        befriend(userA, userB);

        String actual = fetchTimeLine(userB);

        assertThatJson(actual).isEqualTo(timeline);
    }

    @Test
    public void user_can_not_see_own_post_on_timeline() {

        makePost(userA, post);

        String actual = fetchTimeLine(userA);

        assertThatJson(actual).isEqualTo(emptyTimeLine);
    }


    private String fetchTimeLine(String user) {
        return get("/users/{userId}/timeline", user);
    }

    private void makePost(String user, String post) {
        put(post, "/users/{userId}/posts/{postId}",
            "userId", user,
            "postId", "any-post"
        );
    }

    private void befriend(String userA, String userB) {
        put("", "/users/{userId}/friends/{friendId}",
            "userId", userA,
            "friendId", userB
        );
    }
}
