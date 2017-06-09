package com.schibsted.domain.player.model;

import com.schibsted.domain.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerSpecification {

    @Test
    public void should_have_initial_attributes() throws Exception {
        Player player = new Player("A_Player");
        assertEquals(player.getName(),"A_Player");
        assertEquals(player.getHitPoints(), 10);
        assertEquals(player.getAttackPoints(), 2);
        assertEquals(player.getDefensePoints(), 2);
        assertEquals(player.getLevel(), 1);
        assertEquals(player.getExperience(), 0);
        assertEquals(player.getGold(), 0);
    }
}
