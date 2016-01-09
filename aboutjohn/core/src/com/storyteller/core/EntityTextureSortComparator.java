package com.storyteller.core;

import java.util.Comparator;

public class EntityTextureSortComparator implements Comparator<Entity> {

	@Override
	public int compare(Entity o1, Entity o2) {

		EntityTexture texture1 = (EntityTexture) o1;
		EntityTexture texture2 = (EntityTexture) o2;

		return texture1.getZsort() - texture2.getZsort();
	}
}
