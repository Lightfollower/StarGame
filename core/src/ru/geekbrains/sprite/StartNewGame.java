package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ScaledTouchUpButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class StartNewGame extends ScaledTouchUpButton {

    private GameScreen screen;

    public StartNewGame(TextureAtlas atlas, GameScreen screen) {
        super(atlas.findRegion("button_new_game"));
        this.screen = screen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        setBottom(-0.08f);
    }

    @Override
    public void action() {
        screen.startNewGame();
    }
}
