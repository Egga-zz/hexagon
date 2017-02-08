package de.egga.greetings;

import de.egga.TestBase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class GreetingsTests extends TestBase {

    @Test
    public void get_returns_proper_greetings() {

        String expected = fixture("greetings");

        String actual = get("/greetings");

        assertThat(actual).isEqualTo(expected);

    }

}
