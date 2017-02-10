package de.egga.hexagon.rest.friendships;

import de.egga.hexagon.friendships.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
class FriendshipController {

    private static final String URL = "/users/{userId}/friends/{friendId}";

    final FriendshipService service;

    @Autowired
    FriendshipController(FriendshipService service) {
        this.service = service;
    }


    @RequestMapping(method = PUT, value = URL)
    ResponseEntity put(
        @PathVariable String userId,
        @PathVariable String friendId
    ) {

        return new ResponseEntity<>(NO_CONTENT);
    }

    @RequestMapping(method = DELETE, value = URL)
    ResponseEntity delete(
        @PathVariable String userId,
        @PathVariable String friendId
    ) {

        return new ResponseEntity<>(NO_CONTENT);
    }

}
