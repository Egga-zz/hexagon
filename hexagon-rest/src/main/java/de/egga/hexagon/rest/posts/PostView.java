package de.egga.hexagon.rest.posts;


public class PostView {

    private String message;

    public PostView() {
    }

    public PostView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
