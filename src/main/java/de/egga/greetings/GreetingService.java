package de.egga.greetings;

import org.springframework.stereotype.Service;

@Service
class GreetingService {

    String getGreeting() {
        return "Hola!";
    }

}
