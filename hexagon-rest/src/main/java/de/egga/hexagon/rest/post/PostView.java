package de.egga.hexagon.rest.post;


public class PostView {

    private final String id;

    private final String value;


    public PostView(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
