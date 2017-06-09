package com.schibsted.domain.treasure;

/**
 * Created by alberto.esposito on 9/6/17.
 */
public interface TreasureRepository {
  Treasure get(int treasureId);
  Treasure add(Treasure treasure);
}
