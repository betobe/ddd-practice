package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

public class EmptyTreasure implements Treasure {
    private final int id;

    public EmptyTreasure(int id) {
        this.id = id;
    }

    public boolean hasId(int id) {
        return this.id == id;
    }

    @Override
    public EmptyTreasure open(Player opener) {
        return this;
    }

    @Override
    public VisitorReference getReference(Position position) {
        return new VisitorReference(position, id, 1);
    }
}
