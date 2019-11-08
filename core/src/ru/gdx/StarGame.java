package ru.gdx;

import com.badlogic.gdx.Game;

import ru.gdx.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen());
	}
}
