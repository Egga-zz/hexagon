package de.egga.greetings;

import de.egga.TestBase;
import org.junit.Test;

public class GreetingsTest extends TestBase {

    @Test
    public void a_persisted_entity_can_be_retrieved() {

        String entity = fixture("greetings");

        put(entity, "/greetings/{id}", "id", "any-id");

        String actual = get("/greetings/{id}", "any-id");

        assertThat(actual).isEqualTo(entity);

    }
}
