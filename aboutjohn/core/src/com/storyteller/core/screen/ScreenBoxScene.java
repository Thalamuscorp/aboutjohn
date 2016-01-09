package com.storyteller.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Sort;
import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureSortComparator;

public class ScreenBoxScene extends ScreenBox {

	private EntityLabel generalMessage;

	public ScreenBoxScene(ScreenCore screen) {
		super(screen);
		this.generalMessage = new EntityLabel("", 1, 10, Gdx.graphics.getHeight() - 20, Gdx.graphics.getWidth() - 10,
				Align.center);
	}

	@Override
	public void render(ScreenCore screen) {
		Sort.instance().sort(this.getBoxItems(), new EntityTextureSortComparator());
		super.render(screen);
		this.generalMessage.render(screen);
	}

	public void printMessage(String message, int secondsLeft) {
		this.generalMessage.setMessage(message);
		this.generalMessage.setSecondsLeft(secondsLeft);
	}
}
