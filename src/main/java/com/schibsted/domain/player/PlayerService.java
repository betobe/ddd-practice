package com.schibsted.domain.player;

public class PlayerService {
    private Player player;

    public Player create(String playerName) {
        player = new Player(playerName);
        return player;
    }

    public Player getPlayer() {
        return player;
    }
}
