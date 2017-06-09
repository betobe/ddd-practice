package com.schibsted.view.menu;

import com.schibsted.application.ApplicationService;
import com.schibsted.presenter.menu.CreatePlayerPresenter;
import com.schibsted.presenter.menu.DrawMapPresenter;
import com.schibsted.view.View;

import java.io.Reader;
import java.io.Writer;

public class CreatePlayerView extends View {
    private final CreatePlayerPresenter presenter;
    private final ApplicationService service;

    public CreatePlayerView(Reader reader, Writer writer, CreatePlayerPresenter presenter, ApplicationService service) {
        super(reader, writer);
        this.presenter = (CreatePlayerPresenter) presenter.bindView(this);
        this.service = service;
    }

    @Override
    public void onRender() {
        getWriter().print("Enter player name: ");
        getWriter().flush();
    }

    @Override
    public void onCommand(String command) {
        presenter.onConfirmPlayerName(command);
    }

    public void onPlayerCreated() {
        this.navigateTo(new DrawMapView(getReader(), getWriter(), new DrawMapPresenter(service)));
    }
}
