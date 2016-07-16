package com.storyteller.core;

import com.storyteller.core.screen.ScreenCore;
import com.storyteller.core.sentenceengine.SentenceEngineObserver;

public abstract class Entity implements SentenceEngineObserver, Rendereable {

	private int zsort;

	private boolean touchable;

	public Entity(int zsort, boolean touchable) {
		this.setZsort(zsort);
		this.setTouchable(touchable);
	}

	public abstract void render(ScreenCore screen);

	public void dispose() {
	}

	// GETTERS AND SETTERS

	public int getZsort() {
		return zsort;
	}

	public void setZsort(int zsort) {
		this.zsort = zsort;
	}

	public boolean isTouchable() {
		return touchable;
	}

	public void setTouchable(boolean touchable) {
		this.touchable = touchable;
	}

}
