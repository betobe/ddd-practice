package com.schibsted.application;

import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.Player;
import com.schibsted.domain.player.PlayerService;
import com.schibsted.domain.treasure.Treasure;
import com.schibsted.domain.treasure.TreasureService;

public class ApplicationService {
    private final PlayerService playerService;
    private final TreasureService treasureService;
    private final Map map;

    public ApplicationService(PlayerService playerService, TreasureService treasureService, Map map) {
        this.playerService = playerService;
        this.treasureService = treasureService;
        this.map = map;
    }

    public void movePlayerLeft() {
        map.movePlayerLeft();
    }

    public void movePlayerRight() { map.movePlayerRight(); }

    public void movePlayerUp() {
        map.movePlayerUp();
    }

    public void movePlayerDown() {
        map.movePlayerDown();
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return playerService.getPlayer();
    }

    public Map onOpenTreasure(int treasureId) {
        Player player = playerService.getPlayer();
        Treasure treasure = treasureService.openTreasure(treasureId, player);
        map.updateVisitor(treasure);
        return map;
    }
}
