package com.storyteller.aboutjohn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.storyteller.aboutjohn.screens.mainmenu.MainMenuScreen;
import com.storyteller.core.CoreGame;

public class AboutJohnGame extends CoreGame {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create() {
		super.create();
		batch = new SpriteBatch();

		Gdx.graphics.setDisplayMode(640, 480, false);
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
