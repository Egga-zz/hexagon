package de.egga.hexagon.posts;

import com.google.common.base.Objects;

public class PostId {

    private final String id;

    public PostId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostId postId = (PostId) o;
        return Objects.equal(id, postId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
