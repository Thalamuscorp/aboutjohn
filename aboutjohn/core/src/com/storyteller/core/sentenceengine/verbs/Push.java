package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class Push extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public Push() {
		super("verbs/push.png", 64, 32, +64 + 64, +32 + 32, 1, true, "Push");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}

}
