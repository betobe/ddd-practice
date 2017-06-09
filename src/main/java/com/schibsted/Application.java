package com.schibsted;

import com.schibsted.application.ApplicationService;
import com.schibsted.domain.map.model.Map;
import com.schibsted.domain.player.PlayerService;
import com.schibsted.domain.treasure.*;
import com.schibsted.infrastructure.treasure.InMemoryRepository;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.view.menu.CreatePlayerView;

import java.io.*;

public class Application {
    public static final Map MAP = new Map();

    public static void main(String[] args) throws IOException {
        final Reader reader = new InputStreamReader(System.in);
        final Writer writer = new PrintWriter(System.out);
        final Treasure treasure = new GoldTreasure(1, 250);

        MAP.addVisitor(treasure, 4, 6);

        final Treasure treasure2 = new GoldTreasure(2, 500);

        MAP.addVisitor(treasure2, 2, 3);

        final Treasure treasure3 = new ExperienceTreasure(3,500);

        MAP.addVisitor(treasure3, 1,1);

        final PlayerService playerService = new PlayerService();
        final TreasureRepository treasureRepository = new InMemoryRepository();

        treasureRepository.add(treasure);
        treasureRepository.add(treasure2);
        treasureRepository.add(treasure3);

        final TreasureService treasureService = new TreasureService(treasureRepository);

        final ApplicationService applicationService = new ApplicationService(playerService, treasureService, MAP);

        final CreatePlayerPresenter createPlayerPresenter = new CreatePlayerPresenter(playerService);
        final CreatePlayerView createPlayerView = new CreatePlayerView(reader, writer, createPlayerPresenter, applicationService);

        createPlayerView.show();
    }
}
