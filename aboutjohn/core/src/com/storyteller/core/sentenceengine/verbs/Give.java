package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbComposite;
import com.storyteller.core.sentenceengine.Sentence;

public class Give extends EntityTextureWordVerbComposite {

	public EntityLabel label;

	public Give() {
		super("verbs/give.png", 64, 32, 0, +32 + 32, 1, true, "Give", "to");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}
}
