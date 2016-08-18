package com.storyteller.core.screen;

public class ScreenWalkingEngineSimpleBox extends ScreenWalkingEngine {

	int bottomLeftX = 0;
	int bottomLeftY = 0;
	int topRightX = 0;
	int topRightY = 0;

	public ScreenWalkingEngineSimpleBox(State facingState, int currentX, int currentY, int destinationX,
			int destinationY, int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {

		super(facingState, currentX, currentY, destinationX, destinationY);

		this.bottomLeftX = bottomLeftX;
		this.bottomLeftY = bottomLeftY;

		this.topRightX = topRightX;
		this.topRightY = topRightY;
	}

	@Override
	public void walkTo(int destinationX, int destinationY) {
		if ((destinationX >= this.bottomLeftX) && (destinationX <= this.topRightX))
			this.destinationX = destinationX;
		else if (destinationX < this.bottomLeftX)
			this.destinationX = this.bottomLeftX;
		else
			this.destinationX = this.topRightX;

		if ((destinationY >= this.bottomLeftY) && (destinationY <= this.topRightY))
			this.destinationY = destinationY;
		else if (destinationY < this.bottomLeftY)
			this.destinationY = this.bottomLeftY;
		else
			this.destinationY = this.topRightY;

	}

	@Override
	public void takeNextStep() {

		boolean walkingRight = true;

		// Already in destination position, keep everything untouched
		if ((this.destinationX == this.currentX) && (this.destinationY == this.currentY)) {
			return;
		}

		// Walking Right
		if ((this.destinationX > this.currentX) && (this.destinationY == this.currentY)) {
			this.state = State.WALKING_RIGHT;
			this.currentX++;
			walkingRight = true;
		}

		// Walking Right and Up
		if ((this.destinationX > this.currentX) && (this.destinationY > this.currentY)) {
			this.state = State.WALKING_RIGHT;
			this.currentX++;
			this.currentY++;
			walkingRight = true;
		}

		// Walking Up
		if ((this.destinationX == this.currentX) && (this.destinationY > this.currentY)) {
			this.state = State.WALKING_RIGHT;
			this.currentY++;
			walkingRight = true;
		}

		// Walking Left and Up
		if ((this.destinationX < this.currentX) && (this.destinationY > this.currentY)) {
			this.state = State.WALKING_LEFT;
			this.currentX--;
			this.currentY++;
			walkingRight = false;
		}

		// Walking Left
		if ((this.destinationX < this.currentX) && (this.destinationY == this.currentY)) {
			this.state = State.WALKING_LEFT;
			this.currentX--;
			walkingRight = false;
		}

		// Walking Left and Down
		if ((this.destinationX < this.currentX) && (this.destinationY < this.currentY)) {
			this.state = State.WALKING_LEFT;
			this.currentX--;
			this.currentY--;
			walkingRight = false;
		}

		// Walking Down
		if ((this.destinationX == this.currentX) && (this.destinationY < this.currentY)) {
			this.state = State.WALKING_RIGHT;
			this.currentY--;
			walkingRight = false;
		}

		// Walking Right and Down
		if ((this.destinationX > this.currentX) && (this.destinationY < this.currentY)) {
			this.state = State.WALKING_RIGHT;
			this.currentX++;
			this.currentY--;
			walkingRight = true;
		}

		// Got to destination position
		if ((this.destinationX == this.currentX) && (this.destinationY == this.currentY)) {
			if (walkingRight)
				this.state = State.STANDING_LOOKING_RIGHT;
			else
				this.state = State.STANDING_LOOKING_LEFT;
		}

	}
}
