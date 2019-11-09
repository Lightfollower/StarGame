package ru.gdx.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import ru.gdx.base.Sprite;

public class Logo extends Sprite {
    private static final float V_LEN = 2.5f;

    Vector2 tchCpy = new Vector2();
    Vector2 touch = new Vector2();
    Vector2 v = new Vector2();
    public Logo(TextureRegion region) {
        super(region);
    }

    @Override
    public void draw(SpriteBatch batch) {
//        if((tchCpy.sub(pos)).len() > V_LEN) {
//            pos.add(v);
//        } else {
//            pos.set(touch);
//        }
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }

    public void update(Vector2 touch, Matrix3 screenToWorld) {

//        tchCpy.set(touch);
//        v.set(tchCpy.sub(pos).setLength(V_LEN)).mul(screenToWorld);
//        pos.mul(screenToWorld);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        System.out.println("touch " + touch);
        System.out.println("pos " + pos);
        pos.set(touch);
        return false;
    }
}
