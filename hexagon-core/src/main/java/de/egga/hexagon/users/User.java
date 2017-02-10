package de.egga.hexagon.users;

import com.google.common.base.Objects;

public class User {

    private final UserId id;

    public User(UserId id) {
        this.id = id;
    }

    public UserId getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
