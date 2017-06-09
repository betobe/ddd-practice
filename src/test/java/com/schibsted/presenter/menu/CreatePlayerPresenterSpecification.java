package com.schibsted.presenter.menu;

import com.schibsted.domain.player.PlayerService;
import com.schibsted.view.menu.CreatePlayerView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreatePlayerPresenterSpecification {

    private final String A_PLAYER = "A_PLAYER";

    @Test
    public void should_create_a_player() throws Exception {
        PlayerService playerService = Mockito.mock(PlayerService.class);
        CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerService);
        createPlayerPresenter.bindView(Mockito.mock(CreatePlayerView.class));

        createPlayerPresenter.onConfirmPlayerName(A_PLAYER);

        verify(playerService, times(1)).create(A_PLAYER);
    }
}
