package com.storyteller.aboutjohn.screens.mainmenu;

import com.badlogic.gdx.utils.Align;
import com.storyteller.aboutjohn.screens.first.FirstScreen;
import com.storyteller.core.CoreGame;
import com.storyteller.core.EntityLabel;
import com.storyteller.core.screen.ScreenCore;

public class MainMenuScreen extends ScreenCore {

	public EntityLabel title;

	public EntityLabel clickToStart;

	public MainMenuScreen(CoreGame game) {
		super(game);

		title = new EntityLabel("About John", 9999, 300, 300, 300, Align.center);
		clickToStart = new EntityLabel("Click to start", 9999, 300, 200, 300, Align.center);

		this.boxScene.getBoxItems().add(title);
		this.boxScene.getBoxItems().add(clickToStart);
	}

	@Override
	public void renderBoxScene() {
		super.renderBoxScene();
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
