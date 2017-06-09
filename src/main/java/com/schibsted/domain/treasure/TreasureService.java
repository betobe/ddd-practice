package com.schibsted.domain.treasure;

import com.schibsted.domain.player.Player;

public class TreasureService {
    private TreasureRepository treasureRepository;

    public TreasureService(TreasureRepository treasureRepository) {
        this.treasureRepository = treasureRepository;
    }

    public Treasure openTreasure(int treasureId, Player player) {

        Treasure treasure = treasureRepository.get(treasureId);

        treasure = treasure.open(player);
        return treasure;
    }
}
