package ru.gdx.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.gdx.base.Sprite;
import ru.gdx.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
//        size on all screen
        setHeightProportion(1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(1f);
//        Centre the texture
        this.pos.set(worldBounds.pos);
    }
}
