package de.egga.hexagon.rest.timeline;

import de.egga.TestBase;
import org.junit.Before;
import org.junit.Test;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class TimeLineTest extends TestBase {

    String userB = "any-friend";
    String userA = "any-user";

    String timeline = fixture("timeline");
    String post = fixture("post");

    @Before
    public void setUp() {
        delete("/users/{userId}/posts", userA);

    }

    @Test
    public void a_user_can_see_own_post_on_timeline() {

        put(post, "/users/{userId}/posts/{postId}",
            "userId", userA,
            "postId", "any-post"
        );
        put("", "/users/{userId}/friends/{friendId}",
            "userId", userA,
            "friendId", userB
        );

        String actual = get("/users/{userId}/timeline", userB);

        assertThatJson(actual).isEqualTo(timeline);
    }


}
