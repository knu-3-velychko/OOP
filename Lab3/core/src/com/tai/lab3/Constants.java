package com.tai.lab3;

import com.badlogic.gdx.Gdx;

public class Constants {
    static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    static final float TILE_SIZE = getMinDimension() / 8;

    static float getMinDimension() {
        return (SCREEN_HEIGHT > SCREEN_WIDTH) ? SCREEN_WIDTH : SCREEN_HEIGHT;
    }

    static float getMaxDimension() {
        return (SCREEN_HEIGHT > SCREEN_WIDTH) ? SCREEN_HEIGHT : SCREEN_WIDTH;
    }
}
