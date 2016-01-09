package com.storyteller.core;

public abstract class EntityTextureWord extends EntityTexture {

	private String sentenceText = "";

	public EntityTextureWord(String textureImage, int width, int height, int x, int y, int zsort, String sentenceText) {
		super(textureImage, width, height, x, y, zsort);
		this.sentenceText = sentenceText;

	}

	public String getSentenceText() {
		return this.sentenceText;
	}

	public void setSentenceText(String sentenceText) {
		this.sentenceText = sentenceText;
	}

}
