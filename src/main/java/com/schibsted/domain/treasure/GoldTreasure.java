package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

public class GoldTreasure implements Treasure {
  private final int id;
  private final int gold;

  public GoldTreasure(int id, int gold) {
    this.id = id;
    this.gold = gold;
  }

  public boolean hasId(int id) {
    return this.id == id;
  }

  @Override
  public EmptyTreasure open(Player opener) {
    opener.addGold(gold);
    return new EmptyTreasure(id);
  }

  @Override
  public VisitorReference getReference(Position position) {
    return new VisitorReference(position, id, 0);
  }
}
