package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class Open extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public Open() {
		super("verbs/open.png", 64, 32, 0, +32 + 32, 1, "Open");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}
}
