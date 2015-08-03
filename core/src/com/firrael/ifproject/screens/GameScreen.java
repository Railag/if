package com.firrael.ifproject.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.firrael.ifproject.gameworld.GameRenderer;
import com.firrael.ifproject.gameworld.GameWorld;
import com.firrael.ifproject.zbhelpers.InputHandler;

/**
 * Created by firrael on 02.08.2015.
 */
public class GameScreen implements Screen {
    private static final String TAG = GameScreen.class.getName();

    private GameWorld world;
    private GameRenderer renderer;

    private float runtime = 0;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));

    }

    @Override
    public void show() {
        Gdx.app.log(TAG, "show");
    }

    @Override
    public void render(float delta) {
        runtime += delta;
        world.update(delta);
        renderer.render(runtime);

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
