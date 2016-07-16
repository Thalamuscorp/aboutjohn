package com.storyteller.core;

import java.util.Comparator;

public class EntityTextureSortComparator implements Comparator<Entity> {

	@Override
	public int compare(Entity o1, Entity o2) {

		Entity texture1 = (Entity) o1;
		Entity texture2 = (Entity) o2;
		
		return texture1.getZsort() - texture2.getZsort();
	}
}
