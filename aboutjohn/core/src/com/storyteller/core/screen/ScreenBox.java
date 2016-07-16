package com.storyteller.core.screen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.storyteller.core.Entity;
import com.storyteller.core.EntityTextureWord;
import com.storyteller.core.Rendereable;

public abstract class ScreenBox implements Rendereable {

	private ScreenCore screen;

	private List<Entity> boxItems;

	public ScreenBox(ScreenCore aScreen) {
		this.screen = aScreen;
		this.boxItems = new ArrayList<Entity>();
	}

	public EntityTextureWord searchForClickedTexture(float x, float y) {
		Iterator<Entity> iterator = this.getBoxItems().iterator();

		while (iterator.hasNext()) {
			Entity anEntity = iterator.next();
			if (anEntity.isTouchable() && anEntity instanceof EntityTextureWord
					&& ((EntityTextureWord) anEntity).getRectangle().contains(x, y)) {
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
	public List<Entity> getBoxItems() {
		return boxItems;
	}

	/**
	 * @param boxItems
	 *            the boxItems to set
	 */
	public void setBoxItems(List<Entity> boxItems) {
		this.boxItems = boxItems;
	}

}
