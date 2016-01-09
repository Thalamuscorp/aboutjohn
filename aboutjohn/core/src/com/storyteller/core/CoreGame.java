package com.storyteller.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.storyteller.core.sentenceengine.SentenceEngine;

public class CoreGame extends Game {

	public SpriteBatch batch;

	public SentenceEngine sentenceEngine;

	public BitmapFont font14black;
	public BitmapFont font24black;
	public BitmapFont font14white;
	public BitmapFont font24white;

	public EntityTextureWordSustantiveCharacter activeCharacter;
	
	@Override
	public void create() {

		this.batch = new SpriteBatch();

		this.sentenceEngine = new SentenceEngine();

		initializeFonts();
	}

	private void initializeFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-Semibold.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();

		// font 14
		parameter.size = 14;
		font14black = generator.generateFont(parameter); // font size 12 pixels
		font14black.setColor(Color.BLACK);
		font14black.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		parameter.size = 14;
		font14white = generator.generateFont(parameter); // font size 12 pixels
		font14white.setColor(Color.WHITE);
		font14white.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		// font 24
		parameter.size = 24;
		font24black = generator.generateFont(parameter); // font size 12 pixels
		font24black.setColor(Color.BLACK);
		font24black.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		parameter.size = 24;
		font24white = generator.generateFont(parameter); // font size 12 pixels
		font24white.setColor(Color.WHITE);
		font24white.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	}

}
