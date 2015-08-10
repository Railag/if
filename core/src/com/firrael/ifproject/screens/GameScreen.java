package com.firrael.ifproject.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
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

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen() {

        Graphics graphics = Gdx.graphics;

        float screenWidth = graphics.getWidth();
        float screenHeight = graphics.getHeight();

        Graphics.DisplayMode displayMode = null;
        Graphics.DisplayMode[] modes = graphics.getDisplayModes();

        for (int i = 0; i < modes.length; i++)
        {
            if (modes[i].width == screenWidth
                    && modes[i].height == screenHeight)
            {
                displayMode = modes[i];
            }
        }
        //graphics.setDisplayMode(graphics.getDesktopDisplayMode().width, graphics.getDesktopDisplayMode().height, true);
        graphics.setDisplayMode(displayMode);
        graphics.setVSync(true);

        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
        renderer = new GameRenderer(world, (int) gameHeight, midPointY);
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(delta, runTime);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}