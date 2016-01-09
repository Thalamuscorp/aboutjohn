package com.storyteller.core;

public abstract class EntityTextureWordVerbComposite extends EntityTextureWordVerb {

	private String secondText;

	public EntityTextureWordVerbComposite(String textureImage, int width, int height, int x, int y, int zsort,
			String sentenceFirstText, String sentenceSecondText) {
		super(textureImage, width, height, x, y, zsort, sentenceFirstText);
		this.secondText = sentenceSecondText;
	}

	public String getSentenceSecondText() {
		return this.secondText;
	}
}
