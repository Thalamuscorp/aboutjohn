package com.storyteller.aboutjohn.screens.first;

import com.storyteller.aboutjohn.CharacterGuybrush;
import com.storyteller.core.CoreGame;
import com.storyteller.core.screen.ScreenCore;
import com.storyteller.core.screen.ScreenWalkingEngine;
import com.storyteller.core.screen.ScreenWalkingEngineSimpleBox;

public class FirstScreen extends ScreenCore {

	public Door door;
	public DoorKey key;

	public FirstScreenBackground background;
	int WALKABLE_X0 = 0;
	int WALKABLE_Y0 = 128;
	int WALKABLE_X1 = 640;
	int WALKABLE_Y1 = 128 + 79;

	int WORLD_WIDTH = 640;
	int WORLD_HEIGHT = 512;

	public FirstScreen(CoreGame game) {
		super(game, new ScreenWalkingEngineSimpleBox(ScreenWalkingEngine.State.STANDING_LOOKING_RIGHT, 0, 128, 0, 128,
				0, 128, 640, 128 + 70));

		background = new FirstScreenBackground(1);
		door = new Door(3);
		key = new DoorKey(4);
		game.activeCharacter = new CharacterGuybrush(4, this.walkingEngine);

		this.boxScene.getBoxItems().add(this.background);
		this.boxScene.getBoxItems().add(door);
		this.boxScene.getBoxItems().add(key);
		this.boxScene.getBoxItems().add(this.game.activeCharacter);
		System.out.println("FIRST SCREEN:" + this.boxScene.getBoxItems());
		this.boxScene.printMessage("Mmm... i got to get through that door...but how?", 5);

		this.game.sentenceEngine.removeAllObservers();
		this.game.sentenceEngine.addObserver(this.door);
		this.game.sentenceEngine.addObserver(this.key);
		this.game.sentenceEngine.addObserver(game.activeCharacter);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
	}

}