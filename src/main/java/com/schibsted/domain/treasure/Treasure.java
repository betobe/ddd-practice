package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Visitor;
import com.schibsted.domain.player.Player;

public interface Treasure extends Visitor {
    Treasure open(Player opener);
    boolean hasId(int id);
}
