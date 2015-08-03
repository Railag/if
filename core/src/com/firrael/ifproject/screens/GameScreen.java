package com.firrael.ifproject.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.firrael.ifproject.gameworld.GameRenderer;
import com.firrael.ifproject.gameworld.GameWorld;

/**
 * Created by firrael on 02.08.2015.
 */
public class GameScreen implements Screen {
    private static final String TAG = GameScreen.class.getName();

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {
        world = new GameWorld();
        renderer = new GameRenderer(world);
    }

    @Override
    public void show() {
        Gdx.app.log(TAG, "show");
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();

        Gdx.app.log(TAG + " FPS", (1 / delta) + "");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "resize");
    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "pause");
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "resume");
    }

    @Override
    public void hide() {
        Gdx.app.log(TAG, "hide");
    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose");
    }
}
