package ru.gdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gdx.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Vector2 destination;
    private Vector2 direction;

    private Vector2 pos;
    private Vector2 v;

    private Texture img;

    private boolean rightButtonPressed;
    private boolean leftButtonPressed;
    private boolean upButtonPressed;
    private boolean downButtonPressed;
    private Vector2 startPosition;

    @Override
    public void show() {
        destination = new Vector2();
        super.show();
        img = new Texture("pig.png");

        pos = new Vector2();
        v = new Vector2();
        direction = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();

        if (rightButtonPressed) {
            pos.x++;
        }
        if (leftButtonPressed) {
            pos.x--;
        }
        if (upButtonPressed) {
            pos.y++;
        }
        if (downButtonPressed) {
            pos.y--;
        }

        //Движение по оси X
        if (v.x < 0) {
            if (pos.x > destination.x) {
                pos.x += v.x;
            }
        } else {
            if (pos.x < destination.x)
                pos.x += v.x;
        }

        //Движение по оси Y
        if (v.y < 0) {
            if (pos.y > destination.y) {
                pos.y += v.y;
            }
        } else {
            if (pos.y < destination.y)
                pos.y += v.y;
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        destination.x = screenX;
        destination.y = Gdx.graphics.getHeight() - screenY;
        direction = destination.cpy();
        direction.sub(pos);
        direction.nor();
        startPosition = pos.cpy();
        //Скорость свиньи будет магическим числом
        v = direction.scl(2);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case 19:
                upButtonPressed = true;
                break;
            case 20:
                downButtonPressed = true;
                break;
            case 21:
                leftButtonPressed = true;
                break;
            case 22:
                rightButtonPressed = true;
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case 19:
                upButtonPressed = false;
                break;
            case 20:
                downButtonPressed = false;
                break;
            case 21:
                leftButtonPressed = false;
                break;
            case 22:
                rightButtonPressed = false;
                break;
        }
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        pos.x = screenX;
        pos.y = Gdx.graphics.getHeight() - screenY;
        destination = pos.cpy();
        return super.touchDragged(screenX, screenY, pointer);
    }
}

