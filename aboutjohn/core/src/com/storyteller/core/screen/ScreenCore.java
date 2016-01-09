package com.storyteller.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.storyteller.core.CoreGame;
import com.storyteller.core.EntityTextureWord;
import com.storyteller.core.sentenceengine.verbs.WalkTo;

public abstract class ScreenCore implements Screen {

	public CoreGame game;

	public OrthographicCamera camera;
	public FitViewport viewport;
	public Stage stage; // puede ser que no lo necesite porque lo programe a
						// mano

	public ScreenBoxInventory boxInventory;
	public ScreenBoxScene boxScene;
	public ScreenBoxSentence boxSentence;
	public ScreenBoxVerbs boxVerbs;

	public ScreenCore(final CoreGame game) {
		super();
		this.game = game;

		this.game.sentenceEngine.removeAllObservers();

		// initialize screen sections
		this.boxInventory = new ScreenBoxInventory(this);
		this.boxScene = new ScreenBoxScene(this);
		this.boxSentence = new ScreenBoxSentence(this);
		this.boxVerbs = new ScreenBoxVerbs(this);

		// initialize camera
		this.camera = new OrthographicCamera();
		// viewport = new FitViewport(640, 480, camera);
		// viewport.apply();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// Mouse processor
		ScreenMouseInputProcessor processor = new ScreenMouseInputProcessor(this);
		Gdx.input.setInputProcessor(processor);
	}

	@Override
	public void show() { // TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// first processInput(), then update() AI and Physics advance, then
		// render()

		// CLEAR EVERYTHING
		this.clearScreen(); // clear the screen

		camera.update(); // tell the SpriteBatch to render in the coordinate
							// system specified by the camera.

		game.batch.setProjectionMatrix(camera.combined); // tell the camera to
															// update its
															// matrices.

		// PROCESS INPUT
		// this.sentence.process();

		// RENDER
		game.batch.begin();

		this.renderBoxVerbs();
		this.renderBoxInventory();
		this.renderBoxScene();
		this.renderBoxSentence();

		game.batch.end();

		// TODO Auto-generated method stub

	}

	//
	public void renderBoxVerbs() {
		this.boxVerbs.render(this);
	}

	public void renderBoxScene() {
		this.boxScene.render(this);
	}

	public void renderBoxInventory() {
		this.boxInventory.render(this);
	}

	public void renderBoxSentence() {
		this.boxSentence.render(this);

	}

	// MOUSE MANAGEMENT
	public void mouseLeftButtonClicked(float x, float y, int pointer) {

		// SEARCH CLICK IN SCENE
		EntityTextureWord clickedWord = null;

		// SEARCH CLICK IN SCENE
		clickedWord = this.boxScene.searchForClickedTexture(x, y);

		// SEARCH CLICK IN VERBS
		if (clickedWord == null)
			clickedWord = this.boxVerbs.searchForClickedTexture(x, y);

		// SEARCH CLICK IN INVENTORY

		// PROCESS
		if (clickedWord != null) {
			this.boxSentence.sentence.addWord((EntityTextureWord) clickedWord);
			this.game.sentenceEngine.execute(this.boxSentence.sentence);
		} else {
			if (this.boxSentence.sentence.getVerb() instanceof WalkTo) {
				this.game.activeCharacter.walkTo(Math.round(x), Math.round(y));
			}
		}
	}

	public void mouseRightButtonClicked(float x, float y, int pointer) {
		this.boxSentence.sentence.clean();
		this.boxSentence.sentence.setVerb(new WalkTo());
	}

	// UTILITY METHODS
	public void clearScreen() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	// UNUSED METHOS SO FAR
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
