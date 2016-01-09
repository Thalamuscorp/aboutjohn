package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityTextureWordVerbComposite;
import com.storyteller.core.sentenceengine.Sentence;

public class Use extends EntityTextureWordVerbComposite {

	public Use() {
		super("verbs/use.png", 64, 32, +64 + 64, 0, 1, "Use", "on");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}

}
