package de.egga.hexagon.rest.timeline;

import de.egga.hexagon.rest.helpers.UserHelper;
import de.egga.hexagon.rest.posts.PostView;
import de.egga.hexagon.timeline.TimeLine;
import de.egga.hexagon.timeline.TimeLineService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Log
@RestController
class TimeLineController {

    static final String URL = "/users/{userId}/timeline";

    final TimeLineService service;

    @Autowired
    TimeLineController(TimeLineService service) {
        this.service = service;
    }

    @RequestMapping(method = GET, value = URL)
    ResponseEntity<TimeLineView> get(@PathVariable String userId) {

        log.info("GET TIMELINE user [" + userId + "]");

        TimeLine timeLine = service.getTimeLine(UserHelper.userWith(userId));
        List<PostView> collect = timeLine.getPosts()
            .stream()
            .map(p -> new PostView(p.getMessage()))
            .collect(toList());
        TimeLineView timeLineView = new TimeLineView(collect);

        return new ResponseEntity<>(timeLineView, OK);
    }

}
