package com.firrael.ifproject.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.firrael.ifproject.gameobjects.Bird;
import com.firrael.ifproject.gameobjects.ScrollHandler;
import com.firrael.ifproject.zbhelpers.AssetLoader;

/**
 * Created by firrael on 03.08.2015.
 */
public class GameWorld {
    private final static String TAG = GameWorld.class.getName();

    private Bird bird;

    private Rectangle ground;

    private ScrollHandler scroller;

    public boolean isReady() {
        return currentState.equals(GameState.READY);
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public boolean isGameOver() {
        return currentState.equals(GameState.GAMEOVER);
    }

    public enum GameState {
        READY, RUNNING, GAMEOVER
    }

    private GameState currentState;

    private int score = 0;

    public int midPointY;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
        currentState = GameState.READY;
        this.midPointY = midPointY;
    }

    public void updateRunning(float delta) {

        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;
        }
    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;

            case RUNNING:
            default:
                updateRunning(delta);
                break;
        }

    }

    private void updateReady(float delta) {
        // Пока что ничего не делаем
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }
}
