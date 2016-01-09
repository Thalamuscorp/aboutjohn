package com.storyteller.core.sentenceengine;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;
import com.storyteller.core.Entity;
import com.storyteller.core.sentenceengine.verbs.Close;
import com.storyteller.core.sentenceengine.verbs.Give;
import com.storyteller.core.sentenceengine.verbs.LookAt;
import com.storyteller.core.sentenceengine.verbs.Open;
import com.storyteller.core.sentenceengine.verbs.PickUp;
import com.storyteller.core.sentenceengine.verbs.Push;
import com.storyteller.core.sentenceengine.verbs.TalkTo;
import com.storyteller.core.sentenceengine.verbs.Use;

public class SentenceEngine {

	Array<SentenceEngineObserver> observers;

	public SentenceEngine() {
		this.observers = new Array<SentenceEngineObserver>();
	}

	/**
	 * Validates if aSentence is valid, then notifies all observers
	 * 
	 * @param aSentence
	 */
	public void execute(Sentence aSentence) {

		if (aSentence.isSentenceValidForExecution()) {

			Iterator<SentenceEngineObserver> iterator = observers.iterator();

			while (iterator.hasNext()) {

				SentenceEngineObserver observer = iterator.next();

				observer.onNotify(aSentence);

				// Case when the observer is a sustantive, call the appropriate
				// verb function
				if (observer instanceof SentenceEngineObserverSustantive) {

					SentenceEngineObserverSustantive sustantiveObserver = (SentenceEngineObserverSustantive) observer;

					if (aSentence.getFirstObject().equals(sustantiveObserver)) {
						if (aSentence.getVerb() instanceof Close)
							sustantiveObserver.open();
						else if (aSentence.getVerb() instanceof LookAt)
							sustantiveObserver.close();
						else if (aSentence.getVerb() instanceof Open)
							sustantiveObserver.open();
						else if (aSentence.getVerb() instanceof PickUp)
							sustantiveObserver.open();
						else if (aSentence.getVerb() instanceof Push)
							sustantiveObserver.open();
						else if (aSentence.getVerb() instanceof TalkTo)
							sustantiveObserver.open();
						else if (aSentence.getVerb() instanceof Give)
							sustantiveObserver.givedTo(aSentence.getSecondObject());
						else if (aSentence.getVerb() instanceof Use)
							sustantiveObserver.usedOn(aSentence.getSecondObject());
					}

					if (aSentence.getSecondObject().equals(sustantiveObserver)) {
						if (aSentence.getVerb() instanceof Give)
							sustantiveObserver.receive(aSentence.getFirstObject());
						else if (aSentence.getVerb() instanceof Use)
							sustantiveObserver.usedWith(aSentence.getFirstObject());
					}
				}
			}

			aSentence.clean();
		}
	}

	public void addObserver(SentenceEngineObserver anObserver) {
		this.observers.add(anObserver);
	}

	public void removeObserver(SentenceEngineObserver anObserver) {
		this.observers.removeValue(anObserver, false);
	}

	public void addObserverArray(Array<Entity> observers) {
		this.observers.addAll(observers);
	}

	public void removeAllObservers() {
		if (this.observers.size > 0)
			this.observers.removeRange(0, this.observers.size);
	}

}
