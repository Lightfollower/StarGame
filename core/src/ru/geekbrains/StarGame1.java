package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StarGame1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		Vector2 v1 = new Vector2(3f, 5f);
		Vector2 v2 = new Vector2(6f, 8f);
		v1.add(v2);
		System.out.println("v1.add(v2); v1.x = " + v1.x + " v1.y = " + v1.y);
		Vector2 v3 = v1.cpy().add(v2);
		System.out.println("v1.add(v2); v1.x = " + v1.x + " v1.y = " + v1.y);
		System.out.println("v3.x = " + v3.x + " v3.y = " + v3.y);

		v1.set(5, 4);
		v2.set(2, 2);
		v1.sub(v2);
		System.out.println("v1.sub(v2); v1.x = " + v1.x + " v1.y = " + v1.y);

		System.out.println("v1.len(); = " + v1.len());

		v1.set(100, 10);
		v1.scl(0.9f);
		v1.x *= 2;
		System.out.println("v1.scl(0.9f); v1.x = " + v1.x + " v1.y = " + v1.y);
		System.out.println("v1.len(); = " + v1.len());

		v1.set(100, 10);
		v1.nor();
		System.out.println("v1.scl(0.9f); v1.x = " + v1.x + " v1.y = " + v1.y);
		System.out.println("v1.len(); = " + v1.len());

		v1.set(1, 1);
		v2.set(-1, 1);
		v1.nor();
		v2.nor();
		System.out.println(Math.acos(v1.dot(v2)));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
