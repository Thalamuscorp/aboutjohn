package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class Pull extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public Pull() {
		super("verbs/pull.png", 64, 32, +64 + 64, +32, 1, "Pull");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}

}
