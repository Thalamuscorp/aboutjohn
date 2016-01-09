package com.storyteller.core.screen;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;
import com.storyteller.core.Entity;
import com.storyteller.core.EntityTextureWord;
import com.storyteller.core.Rendereable;

public abstract class ScreenBox implements Rendereable {

	private ScreenCore screen;

	private Array<Entity> boxItems;

	public ScreenBox(ScreenCore aScreen) {
		this.screen = aScreen;
		this.boxItems = new Array<Entity>();
	}

	public EntityTextureWord searchForClickedTexture(float x, float y) {
		Iterator<Entity> iterator = this.getBoxItems().iterator();

		while (iterator.hasNext()) {
			Entity anEntity = iterator.next();
			if (anEntity instanceof EntityTextureWord && ((EntityTextureWord) anEntity).getRectangle().contains(x, y)) {
				return (EntityTextureWord) anEntity;
			}
		}
		return null;
	}

	public void render(ScreenCore screen) {
		Iterator<Entity> iterator = this.getBoxItems().iterator();
		while (iterator.hasNext()) {
			Entity item = iterator.next();
			item.render(screen);
		}
	}

	/**
	 * @return the screen
	 */
	public ScreenCore getScreen() {
		return screen;
	}

	/**
	 * @param screen
	 *            the screen to set
	 */
	public void setScreen(ScreenCore screen) {
		this.screen = screen;
	}

	/**
	 * @return the boxItems
	 */
	public Array<Entity> getBoxItems() {
		return boxItems;
	}

	/**
	 * @param boxItems
	 *            the boxItems to set
	 */
	public void setBoxItems(Array<Entity> boxItems) {
		this.boxItems = boxItems;
	}

}
