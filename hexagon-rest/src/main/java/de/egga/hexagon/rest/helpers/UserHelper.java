package de.egga.hexagon.rest.helpers;

import de.egga.hexagon.users.User;
import de.egga.hexagon.users.UserId;
import org.springframework.web.bind.annotation.PathVariable;

public class UserHelper {

    public static User userWith(@PathVariable String userId) {
        return new User(new UserId(userId));
    }
}
