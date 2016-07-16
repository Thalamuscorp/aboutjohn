package com.storyteller.core;

import com.storyteller.core.sentenceengine.SentenceEngineObserverSustantive;

public abstract class EntityTextureWordSustantive extends EntityTextureWord
		implements SentenceEngineObserverSustantive {

	public EntityTextureWordSustantive(String textureImage, int width, int height, int x, int y, int zsort,
			boolean isTouchable, String sentenceText) {
		super(textureImage, width, height, x, y, zsort, isTouchable, sentenceText);
	}

}
