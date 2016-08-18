package com.storyteller.core.screen;

public abstract class ScreenWalkingEngine {

	int destinationX = 0;
	int destinationY = 0;

	int currentX = 0;
	int currentY = 0;

	public enum State {
		STANDING_LOOKING_RIGHT, STANDING_LOOKING_LEFT, WALKING_RIGHT, WALKING_LEFT
	};

	State state = State.STANDING_LOOKING_RIGHT;

	public ScreenWalkingEngine(State facingState, int currentX, int currentY, int destinationX, int destinationY) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.destinationX = destinationX;
		this.destinationY = destinationY;
		this.state = facingState;
	}

	public abstract void walkTo(int destinationX, int destinationY);

	public abstract void takeNextStep();

	public int getDestinationX() {
		return destinationX;
	}

	public void setDestinationX(int destinationX) {
		this.destinationX = destinationX;
	}

	public int getDestinationY() {
		return destinationY;
	}

	public void setDestinationY(int destinationY) {
		this.destinationY = destinationY;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
