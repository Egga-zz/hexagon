package de.egga.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
class GreetingsController {

    private final GreetingService service;

    @Autowired
    GreetingsController(GreetingService service) {
        this.service = service;
    }


    @RequestMapping(method = GET, value = "/greetings")
    ResponseEntity<String> get() {
        String greeting = service.getGreeting();
        return new ResponseEntity<>(greeting, OK);
    }

}
