package com.schibsted.domain.map.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapSpecification {

    private Map map;

    @Before
    public void setUp() throws Exception {
        map = new Map();
    }

    @Test
    public void should_move_player_left() throws Exception {
        Position finalPosition = map.movePlayerLeft();

        Assert.assertEquals(finalPosition, map.initialPosition.left());
    }

    @Test
    public void should_move_player_right() throws Exception {
        Position finalPosition = map.movePlayerRight();

        Assert.assertEquals(finalPosition, map.initialPosition.right());
    }

    @Test
    public void should_move_player_up() throws Exception {
        Position finalPosition = map.movePlayerUp();

        Assert.assertEquals(finalPosition, map.initialPosition.up());
    }

    @Test
    public void should_move_player_down() throws Exception {
        Position finalPosition = map.movePlayerDown();

        Assert.assertEquals(finalPosition, map.initialPosition.down());
    }

    @Test
    public void should_fail_if_out_of_left_bounds() {
        map.movePlayerLeft();
        map.movePlayerLeft();

        map.movePlayerLeft();

        Assert.assertEquals(new Position(0,3), map.movePlayerLeft());
    }

    @Test
    public void should_fail_if_out_of_right_bounds() {
        map.movePlayerRight();
        map.movePlayerRight();
        map.movePlayerRight();

        Position boundaryPosition = map.movePlayerRight();

        Assert.assertEquals(new Position(7,3), map.movePlayerRight());
    }

    @Test
    public void should_fail_if_out_of_upper_bounds() {
        map.movePlayerUp();
        map.movePlayerUp();

        map.movePlayerUp();

        Assert.assertEquals(new Position(3,0), map.movePlayerUp());
    }

    @Test
    public void should_fail_if_out_of_lower_bounds() {
        map.movePlayerDown();
        map.movePlayerDown();
        map.movePlayerDown();

        Position boundaryPosition = map.movePlayerDown();

        Assert.assertEquals(new Position(3,7), map.movePlayerDown());
    }
}
