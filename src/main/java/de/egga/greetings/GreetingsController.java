package de.egga.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
class GreetingsController {

    private static final String COLLECTION_URL = "/greetings";
    private static final String ITEM_URL = COLLECTION_URL + "/{id}";

    final GreetingService service;

    @Autowired
    GreetingsController(GreetingService service) {
        this.service = service;
    }


    @RequestMapping(method = GET, value = COLLECTION_URL)
    ResponseEntity<List<String>> get() {
        List<String> greeting = service.getAllGreetings();
        return new ResponseEntity<>(greeting, OK);
    }


    @RequestMapping(method = GET, value = ITEM_URL)
    ResponseEntity<Greetings> get(
        @PathVariable String id
    ) {
        Greetings greeting = service.getGreetings(id);
        return new ResponseEntity<>(greeting, OK);
    }

    @RequestMapping(method = PUT, value = COLLECTION_URL + "/{id}")
    ResponseEntity put(
        @PathVariable String id,
        @RequestBody Greetings greetings
    ) {
        service.save(greetings, id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @RequestMapping(method = DELETE, value = COLLECTION_URL )
    ResponseEntity delete() {
        service.deleteAll();
        return new ResponseEntity<>(NO_CONTENT);
    }

}
