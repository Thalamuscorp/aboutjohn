package com.storyteller.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.TimeUtils;
import com.storyteller.core.screen.ScreenCore;
import com.storyteller.core.sentenceengine.Sentence;

public class EntityLabel extends Entity {

	private BitmapFont font;

	private String message;

	private long timeToTurnOffMessage;

	private int x;

	private int y;

	int width;

	int alignment;

	/**
	 * @param message
	 * @param seconds
	 *            quantity of seconds to show the message, 0 for infinite
	 * @param x
	 * @param y
	 * @param width
	 * @param alignment
	 */
	public EntityLabel(String message, int seconds, int x, int y, int width, int alignment) {

		super(0, false);

		this.setMessage(message, seconds, x, y, width, alignment);

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-Semibold.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		font = generator.generateFont(parameter); // font size 12 pixels
		font.setColor(Color.BLACK);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	}

	@Override
	public void render(ScreenCore screen) {

		if ((this.timeToTurnOffMessage == 0) || (this.timeToTurnOffMessage > TimeUtils.millis())) {
			this.font.draw(screen.game.batch, this.message, this.x, this.y, this.width, this.alignment, true);
		} else
			this.message = "";
	}

	@Override
	public void onNotify(Sentence aSentence) {
		// TODO Auto-generated method stub

	}

	// GETTERS AND SETTERS

	public void setMessage(String message, int seconds, int x, int y, int width, int alignment) {
		this.message = message;
		this.setSecondsLeft(seconds);
		this.x = x;
		this.y = y;
		this.width = width;
		this.alignment = alignment;
	}

	/**
	 * @return the font
	 */
	public BitmapFont getFont() {
		return font;
	}

	/**
	 * @param font
	 *            the font to set
	 */
	public void setFont(BitmapFont font) {
		this.font = font;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the secondsLeft
	 */
	public float getSecondsLeft() {
		return (this.timeToTurnOffMessage - TimeUtils.millis()) / 1000;
	}

	public void setSecondsLeft(int seconds) {
		if (seconds == 0)
			this.timeToTurnOffMessage = 0;
		else
			this.timeToTurnOffMessage = TimeUtils.millis() + (1000 * seconds);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the alignment
	 */
	public int getAlignment() {
		return alignment;
	}

	/**
	 * @param alignment
	 *            the alignment to set
	 */
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

}
