package de.egga;

import org.json.JSONException;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class JsonAssertion {

    private static final boolean STRICT_MODE = true;


    private final String actual;

    JsonAssertion(String actual) {
        this.actual = actual;
    }


    public void isEqualTo(String expected) {

        try {
            assertEquals(actual, expected, STRICT_MODE);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
