package com.storyteller.aboutjohn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.storyteller.core.EntityTextureWordSustantive;
import com.storyteller.core.EntityTextureWordSustantiveCharacter;
import com.storyteller.core.screen.ScreenCore;
import com.storyteller.core.sentenceengine.Sentence;
import com.storyteller.core.sentenceengine.verbs.WalkTo;

public class CharacterGuybrush extends EntityTextureWordSustantiveCharacter {

	public enum State {
		STANDING_LOOKING_RIGHT, STANDING_LOOKING_LEFT, WALKING_RIGHT, WALKING_LEFT
	};

	//
	private State state;
	private float destinationX;
	private float destinationY;

	private static final int FRAME_COLS = 5; // #1
	private static final int FRAME_ROWS = 2; // #2

	// variables for animation
	private Animation walkAnimationRight; // #3
	private Animation walkAnimationLeft; // #3
	private TextureRegion[] walkFramesRight; // #5
	private TextureRegion[] walkFramesLeft; // #5
	private TextureRegion currentFrame; // #7
	float stateTime; // #8

	public CharacterGuybrush(int x, int y) {
		super("textures/guy_grey/templatemanwalkside.gif", 32, 64, x, y, 1, "Guybrush");

		this.destinationX = x;
		this.destinationY = y;
		state = State.STANDING_LOOKING_RIGHT;

		// Setting Up Animation
		TextureRegion[][] tmpRight = TextureRegion.split(this.getTexture(), this.getTexture().getWidth() / FRAME_COLS,
				this.getTexture().getHeight() / FRAME_ROWS); // #10
		TextureRegion[][] tmpLeft = TextureRegion.split(this.getTexture(), this.getTexture().getWidth() / FRAME_COLS,
				this.getTexture().getHeight() / FRAME_ROWS); // #10

		walkFramesRight = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		walkFramesLeft = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {

				walkFramesRight[index] = tmpRight[i][j];
				walkFramesLeft[index] = tmpLeft[i][j];
				walkFramesLeft[index].flip(true, false);
				index++;
			}
		}
		walkAnimationRight = new Animation(0.1f, walkFramesRight); // #11
		walkAnimationLeft = new Animation(0.1f, walkFramesLeft); // #11
		stateTime = 0f;

	}

	@Override
	public void render(ScreenCore screen) {

		// DEFINING MOVEMENT STATE
		float step = 1;

		if (this.destinationX > this.getRectangle().getX()) {
			this.state = State.WALKING_RIGHT;
			this.getRectangle().setX(this.getRectangle().getX() + step);

		} else if (this.destinationX < this.getRectangle().getX()) {
			this.state = State.WALKING_LEFT;
			this.getRectangle().setX(this.getRectangle().getX() - step);
		} else {
			this.state = State.STANDING_LOOKING_RIGHT;
		}

		if (this.destinationY > this.getRectangle().getY()) {
			this.state = State.WALKING_RIGHT;
			this.getRectangle().setY(this.getRectangle().getY() + step);

		} else if (this.destinationY < this.getRectangle().getY()) {
			this.state = State.WALKING_RIGHT;
			this.getRectangle().setY(this.getRectangle().getY() - step);

		} else {
			this.state = State.STANDING_LOOKING_RIGHT;
		}

		// RUNNING THE ANIMATION STEP
		if (this.state.equals(State.STANDING_LOOKING_RIGHT)) {
			currentFrame = walkFramesRight[0];
			screen.game.batch.draw(currentFrame, this.getRectangle().x, this.getRectangle().y); // #17

		} else if (this.state.equals(State.STANDING_LOOKING_LEFT)) {
			currentFrame = walkFramesLeft[0];
			screen.game.batch.draw(currentFrame, this.getRectangle().x, this.getRectangle().y); // #17

		} else if (this.state.equals(State.WALKING_LEFT)) {
			stateTime += Gdx.graphics.getDeltaTime(); // #15
			currentFrame = walkAnimationLeft.getKeyFrame(stateTime, true);
			screen.game.batch.draw(currentFrame, this.getRectangle().x, this.getRectangle().y); // #17

		} else if (this.state.equals(State.WALKING_RIGHT)) {
			stateTime += Gdx.graphics.getDeltaTime(); // #15
			currentFrame = walkAnimationRight.getKeyFrame(stateTime, true);
			screen.game.batch.draw(currentFrame, this.getRectangle().x, this.getRectangle().y); // #17
		} else {
			currentFrame = walkFramesRight[0];
			screen.game.batch.draw(currentFrame, this.getRectangle().x, this.getRectangle().y); // #17
		}

		// super.render(screen);
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
		if (aSentence.getVerb() instanceof WalkTo) {

		}
	}

	@Override
	public void walkTo(float destinationX, float destinationY) {
		this.destinationX = destinationX;
		this.destinationY = destinationY;
	}

	//
	// GETTERS AND SETTERS
	//

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the destinationX
	 */
	public float getDestinationX() {
		return destinationX;
	}

	/**
	 * @param destinationX
	 *            the destinationX to set
	 */
	public void setDestinationX(float destinationX) {
		this.destinationX = destinationX;
	}

	/**
	 * @return the destinationY
	 */
	public float getDestinationY() {
		return destinationY;
	}

	/**
	 * @param destinationY
	 *            the destinationY to set
	 */
	public void setDestinationY(float destinationY) {
		this.destinationY = destinationY;
	}

}
