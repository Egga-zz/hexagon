package de.egga.hexagon.rest.posts;

import de.egga.hexagon.posts.Post;
import de.egga.hexagon.posts.PostId;
import de.egga.hexagon.posts.PostService;
import de.egga.hexagon.users.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static de.egga.hexagon.rest.helpers.UserHelper.userWith;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Log
@RestController
class PostController {

    static final String COLLECTION_URL = "/users/{userId}/posts";
    static final String ITEM_URL = COLLECTION_URL + "/{postId}";

    final PostService service;

    @Autowired
    PostController(PostService service) {
        this.service = service;
    }


    @RequestMapping(method = PUT, value = ITEM_URL)
    ResponseEntity put(@PathVariable String userId, @PathVariable String postId, @RequestBody PostView view) {

        log.info("PUT POST user [" + userId + "] post [" + postId + "] msg [" + view.getMessage() + "]");

        PostId id = new PostId(postId);
        User user = userWith(userId);
        String message = view.getMessage();

        service.post(new Post(id, user, message));

        return new ResponseEntity<>(NO_CONTENT);
    }

    @RequestMapping(method = DELETE, value = COLLECTION_URL)
    ResponseEntity delete() {

        log.info("DEL POSTS");

        service.deleteAll();

        return new ResponseEntity<>(NO_CONTENT);
    }

}
