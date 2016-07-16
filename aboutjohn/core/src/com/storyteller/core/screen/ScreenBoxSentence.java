package com.storyteller.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.storyteller.core.sentenceengine.Sentence;
import com.storyteller.core.sentenceengine.verbs.WalkTo;

public class ScreenBoxSentence extends ScreenBox {

	public Texture texture;

	public Sentence sentence;

	public ScreenBoxSentence(ScreenCore screen) {
		super(screen);
		texture = new Texture(Gdx.files.internal("verbs/black.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sentence = new Sentence();
		sentence.setVerb(new WalkTo());
	}

	@Override
	public void render(ScreenCore screen) {
		screen.game.batch.draw(this.texture, 0, +32 + 32 + 32, 640, 32);
		screen.game.font14white.draw(screen.game.batch, this.sentence.toString(), 40, +32 + 32 + 32 + 21);
	}

}
