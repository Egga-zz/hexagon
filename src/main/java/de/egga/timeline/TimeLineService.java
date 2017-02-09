package de.egga.timeline;

import org.springframework.stereotype.Service;

@Service
class TimeLineService {

    TimeLineView getPostsOf(String userId) {
        return new TimeLineView();
    }
}
