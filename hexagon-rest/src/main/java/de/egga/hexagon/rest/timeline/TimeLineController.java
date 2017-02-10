package de.egga.hexagon.rest.timeline;

import de.egga.hexagon.rest.posts.PostView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
class TimeLineController {

    private static final String URL = "/users/{userId}/timeline";


    @RequestMapping(method = GET, value = URL)
    ResponseEntity<TimeLineView> get(@PathVariable String userId) {
        TimeLineView dummy = new TimeLineView(new PostView("any-post", "any-message"));
        System.err.println("= TIMELINE ===================================================");
        System.err.println("user [" + userId + "]");
        System.err.println("==============================================================");

        return new ResponseEntity<>(dummy, OK);
    }

}
