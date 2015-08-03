package com.firrael.ifproject.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.firrael.ifproject.gameobjects.Bird;

/**
 * Created by firrael on 03.08.2015.
 */
public class GameWorld {
    private final static String TAG = GameWorld.class.getName();

    private Bird bird;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }
}
