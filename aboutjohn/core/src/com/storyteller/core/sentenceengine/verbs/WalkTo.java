package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class WalkTo extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public WalkTo() {
		super("verbs/close.png", 64, 32, 0, +32, 1, "Walk to");
	}

	@Override
	public void onNotify(Sentence aSentence) {
		// TODO Auto-generated method stub

	}

}
