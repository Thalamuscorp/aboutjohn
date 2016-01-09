package com.storyteller.aboutjohn.firstscreen;

import com.storyteller.aboutjohn.CharacterGuybrush;
import com.storyteller.core.CoreGame;
import com.storyteller.core.screen.ScreenCore;

public class FirstScreen extends ScreenCore {

	public Door door;
	public DoorKey key;

	public FirstScreen(CoreGame game) {
		super(game);

		door = new Door();
		key = new DoorKey();

		game.activeCharacter.getRectangle().setPosition(10, 300);
		((CharacterGuybrush) game.activeCharacter).setDestinationX(10);
		((CharacterGuybrush) game.activeCharacter).setDestinationY(300);
		((CharacterGuybrush) game.activeCharacter).setState(CharacterGuybrush.State.STANDING_LOOKING_RIGHT);

		this.boxScene.getBoxItems().add(door);
		this.boxScene.getBoxItems().add(key);
		this.boxScene.getBoxItems().add(this.game.activeCharacter);
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