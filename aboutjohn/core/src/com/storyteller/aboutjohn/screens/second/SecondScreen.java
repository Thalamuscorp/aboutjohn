package com.storyteller.aboutjohn.screens.second;

import com.storyteller.core.CoreGame;
import com.storyteller.core.screen.ScreenCore;

public class SecondScreen extends ScreenCore {

	public SecondScreen(CoreGame game) {
		super(game);

	}
	
	@Override
	public void renderBoxScene() {
		super.renderBoxScene();
		this.game.font24black.draw(game.batch, "YOU WON", 100, 500);

	}
	

	@Override
	public void dispose() {
	}
}