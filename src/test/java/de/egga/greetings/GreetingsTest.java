package de.egga.greetings;

import de.egga.TestBase;
import org.junit.Before;
import org.junit.Test;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class GreetingsTest extends TestBase {

    String anyEntity = fixture("greetings");

    @Before
    public void setUp() throws Exception {
        delete("/greetings");

    }

    @Test
    public void a_persisted_entity_can_be_retrieved() {

        put(anyEntity, "/greetings/{id}", "id", "any-id");

        String actual = get("/greetings/{id}", "any-id");

        assertThatJson(actual).isEqualTo(anyEntity);
    }

    @Test
    public void persisted_entities_can_be_listed() {

        put(anyEntity, "/greetings/{id}", "id", "new-id");

        String actual = get("/greetings");

        assertThatJson(actual).isEqualTo("[\"new-id\"]");
    }
}
