package com.storyteller.core;

import com.badlogic.gdx.utils.Array;

public abstract class EntityTextureWordSustantiveCharacter extends EntityTextureWordSustantive {

	public Array<EntityTextureWordSustantive> inventory;

	public EntityTextureWordSustantiveCharacter(String textureImage, int width, int height, int x, int y, int zsort,
			boolean isTouchable, String sentenceText) {
		super(textureImage, width, height, x, y, zsort, isTouchable, sentenceText);
		this.inventory = new Array<EntityTextureWordSustantive>(true, 99);
	}

}
