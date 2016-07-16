package com.storyteller.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class ScreenBoxInventory extends ScreenBox {

	public Texture texture;

	public ScreenBoxInventory(ScreenCore screen) {
		super(screen);
		texture = new Texture(Gdx.files.internal("verbs/black.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}

	@Override
	public void render(ScreenCore screen) {
		screen.game.batch.draw(this.texture, +64 + 64 + 64, 0, +640 - 64 - 64 - 64, +32 + 32 + 32);

	}

}
