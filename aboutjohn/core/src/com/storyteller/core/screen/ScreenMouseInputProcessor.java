package com.storyteller.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

public class ScreenMouseInputProcessor extends InputAdapter {

	public ScreenCore screenST;

	public ScreenMouseInputProcessor(ScreenCore screen) {
		this.screenST = screen;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		Vector3 touchPos = new Vector3();
		touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		this.screenST.camera.unproject(touchPos);

		if (Input.Buttons.LEFT == button)
			this.screenST.mouseLeftButtonClicked(touchPos.x, touchPos.y, pointer);
		else if (Input.Buttons.RIGHT == button)
			this.screenST.mouseRightButtonClicked(touchPos.x, touchPos.y, pointer);
		return super.touchUp(screenX, screenY, pointer, button);
	}
}
