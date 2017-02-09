package de.egga.timeline;

import de.egga.TestBase;
import org.junit.Before;
import org.junit.Test;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class TimeLineTest extends TestBase {

    String timeline = fixture("timeline");

    @Before
    public void setUp() {
        delete("/users/{userId}/posts", "any-user");

    }

    @Test
    public void a_user_can_see_own_post_on_timeline() {

        put(timeline, "/users/{userId}/posts/{postId}",
            "userId", "any-user",
            "postId", "any-post"
        );

        String actual = get("/users/{userId}/timeline", "any-user");

        assertThatJson(actual).isEqualTo(timeline);
    }


}
