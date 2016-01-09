package com.storyteller.aboutjohn;

import com.storyteller.aboutjohn.firstscreen.FirstScreen;
import com.storyteller.core.CoreGame;
import com.storyteller.core.screen.ScreenCore;

public class MainMenuScreen extends ScreenCore {

	public MainMenuScreen(CoreGame game) {
		super(game);
	}

	@Override
	public void renderBoxScene() {
		super.renderBoxScene();

		this.game.font24black.draw(game.batch, "INVASION", 300, 300);
		this.game.font14black.draw(game.batch, "Click to start", 300, 200);

	}

	@Override
	public void mouseLeftButtonClicked(float x, float y, int pointer) {
		game.setScreen(new FirstScreen(game));
		dispose();

	}

	@Override
	public void mouseRightButtonClicked(float x, float y, int pointer) {
		// TODO Auto-generated method stub

	}

}
