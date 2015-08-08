package com.firrael.ifproject.gameobjects;

import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by firrael on 04.08.2015.
 */
public class Pipe extends Scrollable {

    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;

    private Rectangle skullUp, skullDown, barUp, barDown;

    private float groundY;

    private Random r;

    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {

        super(x, y, width, height, scrollSpeed);

        r = new Random();

        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();
        this.groundY = groundY;

    }

    @Override
    public void update(float delta) {
        super.update(delta);

        // Метод set() позволяет выставить координаты верзнего лего угла - x, y
        // вместе с width и height прямоугольника

        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                groundY - (position.y + height + VERTICAL_GAP));

        // Ширина черепа 24 пикселя. Ширина трубы всего 22 пикселя. Так что череп
        // должен быть смещен на 1 пиксель влево (так что череп будет отцентрирован
        // относительно трубы).

        // Смещение равнозначно: (SKULL_WIDTH - width) / 2
        skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height
                - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);

    }

    @Override
    public void reset(float newX) {
        super.reset(newX);
        // Измените высоту на случайное значение
        height = r.nextInt(90) + 15;
    }

    public Rectangle getSkullUp() {
        return skullUp;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getBarDown() {
        return barDown;
    }
}