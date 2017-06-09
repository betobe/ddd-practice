package com.schibsted.domain.treasure;

import com.schibsted.domain.map.model.Position;
import com.schibsted.domain.map.model.VisitorReference;
import com.schibsted.domain.player.Player;

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
  public EmptyTreasure open(Player opener) {
    opener.addExperience(experience);
    return new EmptyTreasure(id);
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
