package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class EnemyShip extends Sprite {

    private final Vector2 v = new Vector2(0f, -0.3f);

    private Rect worldBounds;

    public EnemyShip(TextureAtlas atlas) {
        super(atlas.findRegion("enemy1"), 1, 2, 2);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.15f);
        setBottom(worldBounds.getTop());
    }

    @Override
    public void update(float delta) {
        if(!destroyed)
        pos.mulAdd(v, delta);
        if(getBottom() < worldBounds.getBottom()+0.5){
            destroy();
        }

    }

}