package ru.gdx.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gdx.base.Sprite;
import ru.gdx.math.Rect;

public class SpaceShip extends Sprite {
    private final float V_LEN = 0.005f;

    private Rect worldBounds;
    Vector2 v = new Vector2();
    ;
    Vector2 buff = new Vector2();
    ;
    Vector2 destination = new Vector2();
    private boolean moveLeft;
    private boolean moveRight;

    public SpaceShip(TextureAtlas atlas) {
        super(new TextureRegion(atlas.findRegion("main_ship"), 0, 0, 200, 300));
        setHeightProportion(0.15f);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        pos.x = 0;
        setBottom(worldBounds.getBottom() + 0.05f);
    }

    @Override
    public void update(float delta) {
        buff.set(destination.cpy());
        if (buff.sub(pos).len() > V_LEN) {
            pos.add(v);
        } else if (v.len() != 0) {
            pos.set(destination);
            v.setLength(0);
        }
        if (moveLeft) {
            if (getLeft() > worldBounds.getLeft()) {
                pos.x -= V_LEN;
            }
        }
        if (moveRight) {
            if (getRight() < worldBounds.getRight()) {
                pos.x += V_LEN;
            }
        }
    }

    public boolean keyDown(int keycode) {

        switch (keycode) {
            case 21:
                moveLeft = true;
                break;
            case 22:
                moveRight = true;
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        switch (keycode) {
            case 21:
                moveLeft = false;
                break;
            case 22:
                moveRight = false;
                break;
        }
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        destination.x = touch.x;
        System.out.println("X " + touch.x);
        System.out.println("right " + (worldBounds.getRight() - halfWidth));
        if (touch.x < worldBounds.getLeft() + halfWidth) {
            destination.x = worldBounds.getLeft() + halfWidth;
        }
        if (touch.x > worldBounds.getRight() - halfWidth) {
            destination.x = worldBounds.getRight() - halfWidth;
        }
        destination.y = -0.375f;
        buff.set(destination);
        System.out.println("pos " + pos);
        v.set(buff.sub(pos)).setLength(V_LEN);
        System.out.println("dest " + destination);
        System.out.println("velocity " + v);
        return false;
    }

}