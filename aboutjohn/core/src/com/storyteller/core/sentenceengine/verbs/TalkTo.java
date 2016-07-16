package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class TalkTo extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public TalkTo() {
		super("verbs/talkTo.png", 64, 32, +64, 0, 1, true, "Talk to");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}

}
