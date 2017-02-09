package de.egga.greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class GreetingService {

    private final GreetingsRepository repository;

    @Autowired
    GreetingService(GreetingsRepository repository) {
        this.repository = repository;
    }


    List<String> getAllGreetings() {

        List<String> ids = new ArrayList<>();

        for (Greetings greetings : repository.findAll()) {
            ids.add(greetings.getId());
        }

        return ids;
    }

    Greetings getGreetings(String id) {
        return repository.findOne(id);

    }

    void save(Greetings greetings, String id) {
        greetings.setId(id);
        repository.save(greetings);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
