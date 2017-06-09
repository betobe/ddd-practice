package com.schibsted.domain.map.model;

public class VisitorReference {
    public final Position position;
    public final int id;
    public final int type;

    public VisitorReference(Position position, int id, int type) {
        this.position = position;
        this.id = id;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitorReference that = (VisitorReference) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
