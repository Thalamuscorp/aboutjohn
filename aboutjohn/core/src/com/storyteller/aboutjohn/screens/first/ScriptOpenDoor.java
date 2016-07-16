package com.storyteller.aboutjohn.screens.first;

import com.badlogic.gdx.utils.Array;
import com.storyteller.core.EntityTexture;
import com.storyteller.core.sentenceengine.Sentence;
import com.storyteller.core.sentenceengine.SentenceEngineObserver;
import com.storyteller.core.sentenceengine.verbs.Use;

public class ScriptOpenDoor implements SentenceEngineObserver {

	private Door door;
	private Array<EntityTexture> arrayWithKey;

	public ScriptOpenDoor(Door door, Array<EntityTexture> arrayWithKey) {
		this.door = door;
		this.arrayWithKey = arrayWithKey;
	}

	public void execute(Sentence aSentence) {

	}

	@Override
	public void onNotify(Sentence sentence) {
		if ((sentence.getVerb() instanceof Use) && (sentence.getFirstObject() instanceof DoorKey)
				&& (sentence.getSecondObject() instanceof Door)) {
			this.door.usedWith(sentence.getFirstObject());
			this.arrayWithKey.removeValue(sentence.getFirstObject(), false);
		}
	}
}
