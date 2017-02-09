package de.egga.timeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
class TimeLineController {

    private static final String URL = "/users/{userId}/timeline";

    final TimeLineService service;

    @Autowired
    TimeLineController(TimeLineService service) {
        this.service = service;
    }


    @RequestMapping(method = GET, value = URL)
    ResponseEntity<TimeLineView> get(@PathVariable String userId) {
        TimeLineView timeLine = service.getPostsOf(userId);
        return new ResponseEntity<>(timeLine, OK);
    }

}
