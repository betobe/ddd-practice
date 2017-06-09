package com.schibsted.domain.player.model;

import com.schibsted.domain.player.Player;
import com.schibsted.domain.player.PlayerService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerServiceSpecification {

    @Test
    public void createPlayer(){
        PlayerService factory = new PlayerService();
        Player player = factory.create("A_Player");
        assertEquals(player.getName(),"A_Player");
    }
}
