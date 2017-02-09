package de.egga.timeline;

import de.egga.TestBase;
import org.junit.Before;
import org.junit.Test;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class TimeLineTest extends TestBase {

    String anyPost = fixture("post");

    @Before
    public void setUp() throws Exception {
        delete("/posts");

    }

    @Test
    public void a_user_can_see_own_post_on_timeline() {

        put(anyPost, "/users/{userId}/posts/{postId}",
            "userId", "any-user",
            "postId", "any-post"
        );

        String actual = get("/users/{userId}/posts", "any-user");

        assertThatJson(actual).isEqualTo("[\"any-post\"]");
    }


}
