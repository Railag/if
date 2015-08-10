package com.firrael.ifproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.firrael.ifproject.SampleGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Zombie Bird";
        config.width = 1024;
        config.height = 768;
		config.fullscreen = true;
		config.vSyncEnabled = true;

		new LwjglApplication(new SampleGame(), config);
	}
}
