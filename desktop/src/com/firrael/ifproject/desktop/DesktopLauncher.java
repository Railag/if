package com.firrael.ifproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.firrael.ifproject.SampleGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Zombie Bird";
        config.width = 900;
        config.height = 1200;
		new LwjglApplication(new SampleGame(), config);
	}
}
