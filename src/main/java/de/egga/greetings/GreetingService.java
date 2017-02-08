package de.egga.greetings;

import org.springframework.stereotype.Service;

@Service
class GreetingService {

    Greetings getGreetings() {
        return new Greetings("Hola!", "Noon");
    }

}
