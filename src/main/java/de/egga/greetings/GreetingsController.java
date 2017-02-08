package de.egga.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
class GreetingsController {

    final GreetingService service;

    @Autowired
    GreetingsController(GreetingService service) {
        this.service = service;
    }


    @RequestMapping(method = GET, value = "/greetings")
    ResponseEntity<Greetings> get() {
        Greetings greeting = service.getGreetings();
        return new ResponseEntity<>(greeting, OK);
    }

}
