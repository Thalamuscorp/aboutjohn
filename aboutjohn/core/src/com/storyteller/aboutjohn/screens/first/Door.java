package com.storyteller.aboutjohn.screens.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.storyteller.core.EntityTextureWordSustantive;
import com.storyteller.core.sentenceengine.Sentence;

public class Door extends EntityTextureWordSustantive {

	public boolean locked = true;

	Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/key_in_door.mp3"));

	private enum State {
		LOCKED, UNLOCKED, OPEN
	};

	private State state;

	public Door(int zsort) {
		super("door.png", 32, 64, 500, 200, zsort, true, "door");
		this.state = State.LOCKED;
	}

	@Override
	public void open() {

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lookAt() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pull() {
		// TODO Auto-generated method stub

	}

	@Override
	public void push() {
		// TODO Auto-generated method stub

	}

	@Override
	public void talkTo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void usedWith(EntityTextureWordSustantive something) {
		if (something instanceof DoorKey && this.state == State.LOCKED) {
			this.state = State.UNLOCKED;
			this.sound.play();
		}
	}

	@Override
	public void usedOn(EntityTextureWordSustantive something) {
		// TODO Auto-generated method stub

	}

	@Override
	public void givedTo(EntityTextureWordSustantive somebody) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receive(EntityTextureWordSustantive something) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNotify(Sentence aSentence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void walkTo(int destinationX, int destinationY) {
		// TODO Auto-generated method stub

	}

}
