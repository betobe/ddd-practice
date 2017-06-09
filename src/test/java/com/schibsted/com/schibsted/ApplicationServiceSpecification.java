package com.schibsted.com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.Player;
import com.schibsted.domain.player.PlayerService;
import com.schibsted.domain.treasure.EmptyTreasure;
import com.schibsted.domain.treasure.TreasureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ApplicationServiceSpecification {

    private Map map;
    private Player player;
    private ApplicationService service;

    @Before
    public void setUp() throws Exception {
        map = Mockito.mock(Map.class);
        player = Mockito.mock(Player.class);
        service = new ApplicationService(new PlayerService(), new TreasureService(new EmptyTreasure(0)), map);
    }

    @Test
    public void player_should_be_able_to_move_left_on_map() throws Exception {
        service.movePlayerLeft();
        Mockito.verify(map, Mockito.times(1)).movePlayerLeft();
    }

    @Test
    public void player_should_be_able_to_move_right_on_map() throws Exception {
        service.movePlayerRight();
        Mockito.verify(map, Mockito.times(1)).movePlayerRight();
    }

    @Test
    public void player_should_be_able_to_move_up_on_map() throws Exception {
        service.movePlayerUp();
        Mockito.verify(map, Mockito.times(1)).movePlayerUp();
    }

    @Test
    public void player_should_be_able_to_move_down_on_map() throws Exception {
        service.movePlayerDown();
        Mockito.verify(map, Mockito.times(1)).movePlayerDown();
    }
}
