package com.schibsted.domain.map.model;

import com.schibsted.domain.map.exceptions.CollisionFoundException;

import java.util.HashSet;
import java.util.Set;

public class Map {

    public final Position UPPER_LEFT_BOUND = new Position(0, 0);
    public final Position LOWER_RIGHT_BOUND = new Position(7, 7);

    public final Position initialPosition = new Position(3, 3);
    public final Set<VisitorReference> visitors;

    public Position getPlayerPosition() {
        return playerPosition;
    }

    private Position playerPosition;

    public Map() {
        this.playerPosition = initialPosition;
        this.visitors = new HashSet<>();
    }

    public Map addVisitor(Visitor visitor, int x, int y) {
        VisitorReference reference = visitor.getReference(new Position(x, y));
        visitors.remove(reference);
        visitors.add(reference);
        return this;
    }

    public Position movePlayerLeft() {
        if (playerPosition.getX() > UPPER_LEFT_BOUND.getX()) {
            this.playerPosition = ensureAccessToNextPosition(this.playerPosition.left());
        }

        return playerPosition;
    }

    public Position movePlayerRight() {
        if (playerPosition.getX() < LOWER_RIGHT_BOUND.getX()) {
            playerPosition = ensureAccessToNextPosition(playerPosition.right());
        }

        return playerPosition;
    }

    public Position movePlayerUp() {
        if (playerPosition.getY() > UPPER_LEFT_BOUND.getY()) {
            playerPosition = ensureAccessToNextPosition(playerPosition.up());
        }

        return playerPosition;
    }

    public Position movePlayerDown() {
        if(playerPosition.getY() < LOWER_RIGHT_BOUND.getY()) {
            playerPosition = ensureAccessToNextPosition(playerPosition.down());
        }

        return playerPosition;
    }

    private Position ensureAccessToNextPosition(Position position) {
        visitors.stream().filter(visitor -> position.equals(visitor.position))
            .forEach(visitor -> {
                throw new CollisionFoundException(visitor);
            });

        return position;
    }

    public Map updateVisitor(Visitor visitor) {
        VisitorReference visitorReference = visitors.stream()
                .filter(ref -> ref.id == visitor.getReference(new Position(0, 0)).id)
                .findFirst().get();

        return addVisitor(visitor, visitorReference.position.getX(), visitorReference.position.getY());
    }
}
