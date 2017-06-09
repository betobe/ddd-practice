package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

import java.security.SecureRandom;
import java.util.Random;

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
  public Treasure open(Player opener) {
    Random rand = new SecureRandom();
    int number = rand.nextInt(101);

    System.out.println("number::" + number);

    if (number >= 80) {
      opener.addGold(gold);
      return this;
    } else if (number < 10) {
      return new EmptyTreasure(id);
    }
    else {
      opener.addGold(gold);
      return new EmptyTreasure(id);
    }
  }


  @Override
  public VisitorReference getReference(Position position) {
    return new VisitorReference(position, id, 0);
  }
}
