package com.firrael.ifproject.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by firrael on 03.08.2015.
 */
public class GameWorld {
    private final static String TAG = GameWorld.class.getName();

    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    public void update(float delta) {
        Gdx.app.log(TAG, "update");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
    }

    public Rectangle getRect() {
        return rect;
    }


}
