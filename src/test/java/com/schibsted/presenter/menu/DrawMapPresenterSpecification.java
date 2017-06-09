package com.schibsted.presenter.menu;

import com.schibsted.application.ApplicationService;
import com.schibsted.view.menu.DrawMapView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DrawMapPresenterSpecification {

    private ApplicationService service;
    private DrawMapPresenter drawMapPresenter;
    private DrawMapView drawMapView;

    @Before
    public void setUp(){
        service = Mockito.mock(ApplicationService.class);
        drawMapPresenter = new DrawMapPresenter(service);
        drawMapView = Mockito.mock(DrawMapView.class);
        drawMapPresenter.bindView(drawMapView);
    }

    @Test
    public void should_move_a_player_to_the_left() throws Exception {
        drawMapPresenter.move("l");
        Mockito.verify(service, Mockito.times(1)).movePlayerLeft();
    }

    @Test
    public void should_move_a_player_to_the_right() throws Exception {
        drawMapPresenter.move("r");
        Mockito.verify(service, Mockito.times(1)).movePlayerRight();
    }

    @Test
    public void should_move_a_player_up() throws Exception {
        drawMapPresenter.move("u");
        Mockito.verify(service, Mockito.times(1)).movePlayerUp();
    }

    @Test
    public void should_move_a_player_down() throws Exception {
        drawMapPresenter.move("d");
        Mockito.verify(service, Mockito.times(1)).movePlayerDown();
    }
}
