package com.schibsted.domain.map.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position left() {
        return new Position(x - 1, y);
    }

    public Position rigth() {
        return new Position(x + 1, y);
    }

    public Position up() {
        return new Position(x, y + 1);
    }
    public Position down() {
        return new Position(x, y - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}