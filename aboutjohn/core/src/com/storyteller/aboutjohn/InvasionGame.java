package com.storyteller.aboutjohn;

import com.badlogic.gdx.Gdx;
import com.storyteller.core.CoreGame;

/**
 * @author gaston
 *
 */
public class InvasionGame extends CoreGame {

	public void create() {
		super.create();
		Gdx.graphics.setDisplayMode(640, 480, false);
		this.setScreen(new MainMenuScreen(this));
		this.activeCharacter = new CharacterGuybrush(10, 200);

	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
	}

}