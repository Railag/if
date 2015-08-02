package com.firrael.ifproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.firrael.ifproject.screens.GameScreen;

/**
 * Created by firrael on 02.08.2015.
 */
public class SampleGame extends Game {

    private final static String TAG = SampleGame.class.getName();

    @Override
    public void create() {
        Gdx.app.log(TAG, "create");
        setScreen(new GameScreen());
    }
}
