package com.firrael.ifproject.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.firrael.ifproject.gameobjects.Bird;
import com.firrael.ifproject.gameobjects.ScrollHandler;

/**
 * Created by firrael on 03.08.2015.
 */
public class GameWorld {
    private final static String TAG = GameWorld.class.getName();

    private Bird bird;

    private ScrollHandler scroller;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
