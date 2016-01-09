package com.storyteller.aboutjohn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.storyteller.aboutjohn.AboutJohnGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "About John";
		config.width = 640;
		config.height = 480;
		new LwjglApplication(new AboutJohnGame(), config);
	}
}