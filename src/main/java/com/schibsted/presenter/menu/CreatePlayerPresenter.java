package com.schibsted.presenter.menu;

import com.schibsted.domain.player.PlayerService;
import com.schibsted.presenter.Presenter;
import com.schibsted.view.menu.CreatePlayerView;

public class CreatePlayerPresenter extends Presenter<CreatePlayerView> {
    private final PlayerService playerService;

    public CreatePlayerPresenter(PlayerService playerService) {
        super();
        this.playerService = playerService;
    }

    public void onConfirmPlayerName(String playerName) {
        System.out.println(">> " + playerName);
        playerService.create(playerName);
        getView().onPlayerCreated();
    }
}
