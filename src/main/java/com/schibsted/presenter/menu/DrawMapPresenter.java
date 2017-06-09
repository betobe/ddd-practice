package com.schibsted.presenter.menu;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.exceptions.CollisionFoundException;
import com.schibsted.presenter.Presenter;
import com.schibsted.view.menu.DrawMapView;

public class DrawMapPresenter extends Presenter<DrawMapView> {

    private final ApplicationService service;

    public DrawMapPresenter(ApplicationService service) {
        this.service = service;
    }

    public void move(String where) {
        try {
            switch (where) {
                case "l":
                    service.movePlayerLeft();
                    break;
                case "r":
                    service.movePlayerRight();
                    break;
                case "u":
                    service.movePlayerUp();
                    break;
                case "d":
                    service.movePlayerDown();
                    break;
            }
        } catch (CollisionFoundException e) {
            if (e.reference.type == 0) {
                getView().onTreasureChestFound(e.reference.id);
            }
        }
    }

    public void onRefreshMap() {
        getView().onRenderPlayer(service.getPlayer());
        getView().onRenderMap(service.getMap());
    }

    public void onOpenTreasure(int treasureId) {
        service.onOpenTreasure(treasureId);
    }
}
