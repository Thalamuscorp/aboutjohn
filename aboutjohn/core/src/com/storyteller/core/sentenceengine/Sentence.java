package com.storyteller.core.sentenceengine;

import com.storyteller.core.EntityTextureWord;
import com.storyteller.core.EntityTextureWordSustantive;
import com.storyteller.core.EntityTextureWordVerb;
import com.storyteller.core.EntityTextureWordVerbComposite;
import com.storyteller.core.EntityTextureWordVerbSimple;
import com.storyteller.core.sentenceengine.verbs.WalkTo;

public class Sentence {

	private EntityTextureWordVerb verb;
	private EntityTextureWordSustantive firstObject;
	private EntityTextureWordSustantive secondObject;

	public void EntitySentence() {
		this.verb = new WalkTo();
	}

	public void clear() {
		this.verb = null;
		this.firstObject = null;
		this.secondObject = null;
	}

	public void addWord(EntityTextureWord aWord) {

		if (aWord instanceof EntityTextureWordVerb) { // If it is a verb, start
														// sentence
														// all over
			this.verb = (EntityTextureWordVerb) aWord;
			this.firstObject = null;
			this.secondObject = null;
		} else if (aWord instanceof EntityTextureWordSustantive) { // If a
																	// sustantive...

			if ((this.verb instanceof EntityTextureWordVerbSimple) && (this.firstObject == null)) {
				this.firstObject = (EntityTextureWordSustantive) aWord;

			} else if ((this.verb instanceof EntityTextureWordVerbComposite) && (this.firstObject == null)) {
				this.firstObject = (EntityTextureWordSustantive) aWord;

			} else if ((this.verb instanceof EntityTextureWordVerbComposite) && (this.firstObject != null)) {
				this.secondObject = (EntityTextureWordSustantive) aWord;
			}
		}
	}

	public void clean() {
		this.verb = new WalkTo();
		this.firstObject = null;
		this.secondObject = null;
	}

	public boolean isSentenceValidForExecution() {

		if ((this.verb instanceof EntityTextureWordVerbSimple) && (this.verb != null) && (this.firstObject != null))
			return true;

		if ((this.verb instanceof EntityTextureWordVerbComposite) && (this.verb != null) && (this.firstObject != null)
				&& (this.secondObject != null))
			return true;

		return false;

	}

	@Override
	public String toString() {

		String answer = "";

		if (this.verb == null)
			return answer;

		if (this.verb != null) {
			answer += " " + this.verb.getSentenceText();
		}

		if (this.firstObject != null) {
			answer += " " + this.firstObject.getSentenceText();
		}

		if ((this.verb instanceof EntityTextureWordVerbComposite) && (this.firstObject != null)) {
			answer += " " + ((EntityTextureWordVerbComposite) verb).getSentenceSecondText();
		}

		if (this.secondObject != null) {
			answer += " " + this.secondObject.getSentenceText();
		}

		return answer;
	}

	// GETTERS AND SETTERS

	/**
	 * @return the verb
	 */
	public EntityTextureWordVerb getVerb() {
		return verb;
	}

	/**
	 * @param verb
	 *            the verb to set
	 */
	public void setVerb(EntityTextureWordVerb verb) {
		this.verb = verb;
	}

	/**
	 * @return the firstObject
	 */
	public EntityTextureWordSustantive getFirstObject() {
		return firstObject;
	}

	/**
	 * @param firstObject
	 *            the firstObject to set
	 */
	public void setFirstObject(EntityTextureWordSustantive firstObject) {
		this.firstObject = firstObject;
	}

	/**
	 * @return the secondObject
	 */
	public EntityTextureWordSustantive getSecondObject() {
		return secondObject;
	}

	/**
	 * @param secondObject
	 *            the secondObject to set
	 */
	public void setSecondObject(EntityTextureWordSustantive secondObject) {
		this.secondObject = secondObject;
	}

}
