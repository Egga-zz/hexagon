package de.egga.hexagon.users;

import com.google.common.base.Objects;

public class UserId {

    private final String value;

    public UserId(String value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equal(value, userId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
