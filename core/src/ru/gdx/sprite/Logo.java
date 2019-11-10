package ru.gdx.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

import ru.gdx.base.Sprite;

public class Logo extends Sprite {
    private static final float V_LEN = 0.001f;

    Vector2 tchCpy = new Vector2();
    Vector2 touch = new Vector2();
    Vector2 v = new Vector2();

    public Logo(TextureRegion region) {
        super(region);
    }

    float i;

    @Override
    public void draw(SpriteBatch batch) {
        i = tchCpy.cpy().sub(pos).len();

        if (i > V_LEN) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }

    public void update(Vector2 touch) {
        System.out.println("updating");
        this.touch = touch;
        tchCpy.set(this.touch);
        System.out.println("tchcpy " + tchCpy);

        v.set(tchCpy.cpy().sub(pos));
        v.setLength(V_LEN);
        System.out.println("velocity " + v);
//        System.out.println("tchcpy " + tchCpy);
        System.out.println("pos " + pos);
        System.out.println();
        System.out.println();

//        pos.set(touch);
//        if ((tchCpy.sub(pos)).len() > V_LEN) {
//            pos.add(v);
//        } else {
//            pos.set(touch);
//        }
//        tchCpy.set(touch);
//        v.set(tchCpy.sub(pos).setLength(V_LEN)).mul(screenToWorld);
//        pos.mul(screenToWorld);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
//        System.out.println();
//        System.out.println();
//        this.touch = touch;
//        tchCpy.set(this.touch);
//        System.out.println("tchcpy " + tchCpy);
//
//        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
//        System.out.println("velocity " + v);
//        System.out.println("tchcpy " + tchCpy);
//        System.out.println("pos " + pos);
//        pos.set(touch);
        return false;
    }


    public void showCondition() {
        System.out.println("Condition: ");
        System.out.println("velocity " + v);
        System.out.println("distance " + i);
        System.out.println("tchcpy " + tchCpy);
        System.out.println("pos " + pos);
        System.out.println();
        System.out.println();
    }
}
