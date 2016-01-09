package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class LookAt extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public LookAt() {
		super("verbs/lookAt.png", 64, 32, +64, +32, 1, "Look at");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}

}
