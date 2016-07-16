package com.storyteller.aboutjohn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.storyteller.core.EntityTextureWordSustantive;
import com.storyteller.core.EntityTextureWordSustantiveCharacter;
import com.storyteller.core.screen.ScreenCore;
import com.storyteller.core.screen.ScreenWalkingEngine;
import com.storyteller.core.sentenceengine.Sentence;
import com.storyteller.core.sentenceengine.verbs.WalkTo;

/**
 * @author gastonblanco
 *
 */
public class CharacterGuybrush extends EntityTextureWordSustantiveCharacter {

	// Walking engine
	ScreenWalkingEngine engine;

	// Sprite sections
	private static final int FRAME_COLS = 5; // #1
	private static final int FRAME_ROWS = 2; // #2

	// variables for animation
	private Animation walkAnimationRight; // #3
	private Animation walkAnimationLeft; // #3
	private TextureRegion[] walkFramesRight; // #5
	private TextureRegion[] walkFramesLeft; // #5
	private TextureRegion currentFrame; // #7
	float stateTime; // #8

	/**
	 * @param x
	 * @param y
	 * @param zsort
	 * @param walkingEngine
	 */
	public CharacterGuybrush(int zsort, ScreenWalkingEngine walkingEngine) {
		super("textures/guy_grey/templatemanwalkside.png", 32, 64, walkingEngine.getCurrentX(),
				walkingEngine.getCurrentY(), zsort, false, "Guybrush");

		this.engine = walkingEngine;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.storyteller.core.EntityTexture#render(com.storyteller.core.screen.
	 * ScreenCore)
	 */
	@Override
	public void render(ScreenCore screen) {

		this.engine.takeNextStep();

		// RUNNING THE ANIMATION STEP
		if (this.engine.getState().equals(ScreenWalkingEngine.State.STANDING_LOOKING_RIGHT)) {
			currentFrame = walkFramesRight[0];
			screen.game.batch.draw(currentFrame, this.engine.getCurrentX(), this.engine.getCurrentY()); // #17

		} else if (this.engine.getState().equals(ScreenWalkingEngine.State.STANDING_LOOKING_LEFT)) {
			currentFrame = walkFramesLeft[0];
			screen.game.batch.draw(currentFrame, this.engine.getCurrentX(), this.engine.getCurrentY()); // #17

		} else if (this.engine.getState().equals(ScreenWalkingEngine.State.WALKING_LEFT)) {
			stateTime += Gdx.graphics.getDeltaTime(); // #15
			currentFrame = walkAnimationLeft.getKeyFrame(stateTime, true);
			screen.game.batch.draw(currentFrame, this.engine.getCurrentX(), this.engine.getCurrentY()); // #17

		} else if (this.engine.getState().equals(ScreenWalkingEngine.State.WALKING_RIGHT)) {
			stateTime += Gdx.graphics.getDeltaTime(); // #15
			currentFrame = walkAnimationRight.getKeyFrame(stateTime, true);
			screen.game.batch.draw(currentFrame, this.engine.getCurrentX(), this.engine.getCurrentY()); // #17
		} else {
			currentFrame = walkFramesRight[0];
			screen.game.batch.draw(currentFrame, this.engine.getCurrentX(), this.engine.getCurrentY()); // #17
		}
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
	public void walkTo(int destinationX, int destinationY) {
		this.engine.walkTo(destinationX, destinationY);
	}

	//
	// GETTERS AND SETTERS
	//

}
