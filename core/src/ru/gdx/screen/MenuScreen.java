package ru.gdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Matrix3;

import ru.gdx.base.BaseScreen;
import ru.gdx.math.Rect;
import ru.gdx.sprite.Background;
import ru.gdx.sprite.Logo;

public class MenuScreen extends BaseScreen {

    int count = 0;

    private Texture img;
    private Texture bg;
    private Logo logo;
    private Background background;

    //Old
    private static final float V_LEN = 2.5f;

//    private Vector2 touch;
//    private Vector2 v;
//    private Vector2 pos;

//    private Texture img;

    private boolean rightButtonPressed;
    private boolean leftButtonPressed;
    private boolean upButtonPressed;
    private boolean downButtonPressed;

//    private Vector2 tchCpy;

    @Override
    public void show() {
        super.show();
        img = new Texture("pig.png");
        bg = new Texture("textures/bg.png");
        logo = new Logo(new TextureRegion(img));
//        determines the size
        logo.setHeightProportion(0.5f);
        background = new Background(new TextureRegion(bg));

        //old
//        super.show();
        img = new Texture("pig.png");
//        pos = new Vector2();
//        v = new Vector2();
//        touch = new Vector2();
//        tchCpy = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        count++;
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
        if(count % 60 == 0) {
          logo.showCondition();
        }
//        logo.update();
//        logo.update(touch, screenToWorld);
//
//        tchCpy.set(touch);
//        if((tchCpy.sub(pos)).len() > V_LEN) {
//            pos.add(v);
//        } else {
//            pos.set(touch);
//        }
//
//
//        if (rightButtonPressed) {
//            pos.x++;
//        }
//        if (leftButtonPressed) {
//            pos.x--;
//        }
//        if (upButtonPressed) {
//            pos.y++;
//        }
//        if (downButtonPressed) {
//            pos.y--;
//        }

        //Old
//        super.render(delta);
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.draw(img, pos.x, pos.y);
//        batch.end();
//        tchCpy.set(touch);
//        if((tchCpy.sub(pos)).len() > V_LEN) {
//            pos.add(v);
//        } else {
//            pos.set(touch);
//        }
//
//
//        if (rightButtonPressed) {
//            pos.x++;
//        }
//        if (leftButtonPressed) {
//            pos.x--;
//        }
//        if (upButtonPressed) {
//            pos.y++;
//        }
//        if (downButtonPressed) {
//            pos.y--;
//        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
//        stretch the background
        background.resize(worldBounds);
    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
//        this.touch.set(touch);
        logo.update(touch);
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
//        pos.x = screenX;
//        pos.y = Gdx.graphics.getHeight() - screenY;
//        touch = pos.cpy();
        return super.touchDragged(screenX, screenY, pointer);
    }


}

