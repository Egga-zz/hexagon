package de.egga;

import org.springframework.stereotype.Service;

@Service
class GreetingService {

    String getGreeting() {
        return "Hola!";
    }

}
