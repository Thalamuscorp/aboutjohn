package com.storyteller.core;

import com.storyteller.core.screen.ScreenCore;
import com.storyteller.core.sentenceengine.SentenceEngineObserver;

public abstract class Entity implements SentenceEngineObserver, Rendereable {

	private int zsort;

	public Entity(int zsort) {
		this.setZsort(zsort);
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

}
