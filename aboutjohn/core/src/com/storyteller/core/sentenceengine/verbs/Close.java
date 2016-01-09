package com.storyteller.core.sentenceengine.verbs;

import com.storyteller.core.EntityLabel;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.Sentence;

public class Close extends EntityTextureWordVerbSimple {

	public EntityLabel label;

	public Close() {
		super("verbs/close.png", 64, 32, 0, +32, 1, "Close");
	}

	@Override
	public void onNotify(Sentence aSentence) {
		// TODO Auto-generated method stub

	}

}
