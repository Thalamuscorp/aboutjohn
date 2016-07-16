package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class PickUp extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public PickUp() {
		super("verbs/pickUp.png", 64, 32, +64, +32 + 32, 1, true, "Pick up");
	}

	@Override
	public void onNotify(Sentence sentence) {
		// TODO Auto-generated method stub

	}

}
