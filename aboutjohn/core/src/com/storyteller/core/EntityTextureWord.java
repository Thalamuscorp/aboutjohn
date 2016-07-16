package com.storyteller.core;

public abstract class EntityTextureWord extends EntityTexture {

	private String sentenceText = "";

	public EntityTextureWord(String textureImage, int width, int height, int x, int y, int zsort, boolean isTouchable,
			String sentenceText) {
		super(textureImage, width, height, x, y, zsort, isTouchable);
		this.sentenceText = sentenceText;

	}

	public String getSentenceText() {
		return this.sentenceText;
	}

	public void setSentenceText(String sentenceText) {
		this.sentenceText = sentenceText;
	}

}
