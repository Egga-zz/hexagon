package de.egga.hexagon.rest.timeline;

import de.egga.hexagon.rest.posts.PostView;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
class TimeLineView {

    private final List<PostView> posts = new ArrayList<>();


    public TimeLineView(List<PostView> posts) {

        this.posts.addAll(posts);
    }
}
