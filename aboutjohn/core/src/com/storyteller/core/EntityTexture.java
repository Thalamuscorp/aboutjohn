package com.storyteller.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.storyteller.core.screen.ScreenCore;

public abstract class EntityTexture extends Entity {

	private CoreRectangle rectangle;

	private Texture texture;

	public EntityTexture(String textureImage, float width, float height, float x, float y, int zsort) {
		super(zsort);

		texture = new Texture(Gdx.files.internal(textureImage));

		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		this.rectangle = new CoreRectangle(x, y, width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
		this.texture.dispose();
	}

	@Override
	public void render(ScreenCore screen) {
		screen.game.batch.draw(this.texture, this.getRectangle().x, this.getRectangle().y);
	}

	// GETTERS AND SETTERS

	/**
	 * @return the texture
	 */
	public Texture getTexture() {
		return texture;
	}

	/**
	 * @param texture
	 *            the texture to set
	 */
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	/**
	 * @return the rectangle
	 */
	public CoreRectangle getRectangle() {
		return rectangle;
	}

	/**
	 * @param rectangle
	 *            the rectangle to set
	 */
	public void setRectangle(CoreRectangle rectangle) {
		this.rectangle = rectangle;
	}

}
