package de.egga.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GreetingService {

    private final GreetingsRepository repository;

    @Autowired
    GreetingService(GreetingsRepository repository) {
        this.repository = repository;
    }


    Greetings getGreetings(String id) {
        return repository.findOne(id);

    }

    void save(Greetings greetings, String id) {
        greetings.setId(id);
        repository.save(greetings);
    }
}
