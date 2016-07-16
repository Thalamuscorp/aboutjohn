package com.storyteller.core.sentenceengine;

import com.storyteller.core.EntityTextureWordSustantive;

public interface SentenceEngineObserverSustantive extends SentenceEngineObserver {

	public void open();

	public void close();

	public void lookAt();

	public void pickUp();

	public void pull();

	public void push();

	public void talkTo();

	public void walkTo(int destinationX, int destinationY);

	public void usedWith(EntityTextureWordSustantive something);

	public void usedOn(EntityTextureWordSustantive something);

	public void givedTo(EntityTextureWordSustantive somebody);

	public void receive(EntityTextureWordSustantive something);

}
