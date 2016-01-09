package com.storyteller.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class CoreRectangle extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean isGrabbable = false;
	public boolean isGrabbed = false;

	public CoreRectangle(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void processGrabbing(OrthographicCamera camera) {

		if (!isGrabbable)
			return;

		if (!Gdx.input.isTouched()) {
			this.isGrabbed = false;
			return;
		}

		Vector3 touchPos = new Vector3();
		touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(touchPos);

		if (isGrabbed) {
			this.x = touchPos.x - this.width / 2;
			this.y = touchPos.y - this.height / 2;

			// make sure the object stays in the screen
			if (this.x < 0)
				this.x = 0;
			if (this.x > camera.viewportWidth - this.width)
				this.x = camera.viewportWidth - this.width;

			if (this.y < 0)
				this.y = 0;
			if (this.y > camera.viewportHeight - this.height)
				this.y = camera.viewportHeight - this.height;

		} else {
			if (this.contains(touchPos.x, touchPos.y)) {
				this.isGrabbed = true;
				this.x = touchPos.x - this.width / 2;
				this.y = touchPos.y - this.height / 2;
			}
		}
	}
}
