package com.firrael.ifproject.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by firrael on 03.08.2015.
 */
public class GameRenderer {
    private final static String TAG = GameRenderer.class.getName();

    private GameWorld world;

    private OrthographicCamera camera;

    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld world) {
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, 204);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void render() {
        Gdx.app.log(TAG, "render");

        Gdx.app.log("GameRenderer", "render");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        shapeRenderer.rect(world.getRect().x, world.getRect().y,
                world.getRect().width, world.getRect().height);

        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        shapeRenderer.rect(world.getRect().x, world.getRect().y,
                world.getRect().width, world.getRect().height);

        shapeRenderer.end();
    }
}
