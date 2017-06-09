package com.schibsted.infrastructure.treasure;

import com.schibsted.domain.treasure.EmptyTreasure;
import com.schibsted.domain.treasure.GoldTreasure;
import com.schibsted.domain.treasure.Treasure;
import com.schibsted.domain.treasure.TreasureRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alberto.esposito on 9/6/17.
 */
public class InMemoryRepository implements TreasureRepository {

  private Set<Treasure> list;

  public InMemoryRepository (){
    list = new HashSet<>();
  }


  @Override
  public Treasure get(int treasureId) {
    return list.stream().filter(
            item -> item.hasId(treasureId))
            .findFirst()
            .get();
  }

  @Override
  public Treasure add(Treasure treasure) {
    list.add(treasure);
    return treasure;
  }


}
