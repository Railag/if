package com.firrael.ifproject.zbhelpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by firrael on 03.08.2015.
 */
public class AssetLoader {
    public static AssetManager manager;

    public static Sound dead;

    public static Texture texture;
    public static TextureRegion bg, grass;

    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;

    public static TextureRegion skullUp, skullDown, bar;

    public static void load() {
        manager = new AssetManager();

        manager.load("data/texture.png", Texture.class);
        manager.load("data/dead.wav", Sound.class);
        manager.finishLoadingAsset("data/texture.png");
        manager.finishLoadingAsset("data/dead.wav");

        if (manager.isLoaded("data/texture.png")) {
            texture = manager.get("data/texture.png", Texture.class);

            texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

            bg = new TextureRegion(texture, 0, 0, 136, 43);
            bg.flip(false, true);

            grass = new TextureRegion(texture, 0, 43, 143, 11);
            grass.flip(false, true);

            birdDown = new TextureRegion(texture, 136, 0, 17, 12);
            birdDown.flip(false, true);

            bird = new TextureRegion(texture, 153, 0, 17, 12);
            bird.flip(false, true);

            birdUp = new TextureRegion(texture, 170, 0, 17, 12);
            birdUp.flip(false, true);

            TextureRegion[] birds = {birdDown, bird, birdUp};
            birdAnimation = new Animation(0.06f, birds);
            birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

            skullUp = new TextureRegion(texture, 192, 0, 24, 14);

            skullDown = new TextureRegion(skullUp);
            skullDown.flip(false, true);

            bar = new TextureRegion(texture, 136, 16, 22, 3);
            bar.flip(false, true);
        }

        if (manager.isLoaded("data/dead.wav"))
            dead = manager.get("data/dead.wav");
    }

    public static void dispose() {
        texture.dispose();
    }
}
