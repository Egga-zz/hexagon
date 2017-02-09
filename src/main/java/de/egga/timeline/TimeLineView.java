package de.egga.timeline;

import de.egga.post.PostView;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class TimeLineView {

    private final List<PostView> posts = new ArrayList<>();


    public TimeLineView(PostView... posts) {

        for (PostView post : posts) {
            this.posts.add(post);
        }

    }
}
