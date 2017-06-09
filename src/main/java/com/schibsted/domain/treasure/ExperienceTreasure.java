package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by alberto.esposito on 9/6/17.
 */
public class ExperienceTreasure implements Treasure{
  private int id;
  private int experience;

  public ExperienceTreasure(int id, int experience) {
    this.experience = experience;
    this.id = id;
  }

  @Override
  public Treasure open(Player opener) {

    Random rand = new SecureRandom();
    int number = rand.nextInt(101);

    System.out.println("number::" + number);

    if (number >= 80) {
      opener.addExperience(experience);
      return this;
    } else if (number < 10) {
      return new EmptyTreasure(id);
    }
    else {
      opener.addExperience(experience);
      return new EmptyTreasure(id);
    }
  }

  @Override
  public boolean hasId(int id) {
    return this.id == id;
  }

  @Override
  public VisitorReference getReference(Position position) {
    return new VisitorReference(position, id, 0);
  }

}
