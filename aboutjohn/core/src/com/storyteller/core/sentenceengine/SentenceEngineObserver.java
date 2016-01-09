package com.storyteller.core.sentenceengine;

/**
 * A Sentence Engine Observer is waiting a sentence execution. When sentence
 * execution ocurrs, it is called the onNotify method. The observer should
 * analyze the Sentence and react accordingly.
 * 
 * @author gastonblanco
 *
 */
public interface SentenceEngineObserver {

	/**
	 * @param aSentence
	 */
	public void onNotify(Sentence aSentence);

}
