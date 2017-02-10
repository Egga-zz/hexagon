package de.egga.hexagon.rest.posts;

import de.egga.hexagon.posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
class PostController {

    private static final String COLLECTION_URL = "/users/{userId}/posts";
    private static final String ITEM_URL = COLLECTION_URL + "/{id}";

    final PostService service;

    @Autowired
    PostController(PostService service) {
        this.service = service;
    }


    @RequestMapping(method = PUT, value = ITEM_URL)
    ResponseEntity put(
        @PathVariable String userId,
        @PathVariable String postId,
        @RequestBody PostView post
    ) {
        //service.save(post, userId, postId);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @RequestMapping(method = DELETE, value = COLLECTION_URL)
    ResponseEntity delete(@PathVariable String userId) {
        //service.deleteAll();
        return new ResponseEntity<>(NO_CONTENT);
    }

}
