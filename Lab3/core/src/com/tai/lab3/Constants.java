package com.tai.lab3;

import com.badlogic.gdx.Gdx;

enum Type {
    NONE,
    WHITE, BLACK,
    WHITE_HOVER, BLACK_HOVER,
    WHITE_KING, BLACK_KING,
    WHITE_KING_HOVER, BLACK_KING_HOVER
}

enum Color {White, Black}


class Constants {

    static final int SIZE = 8;

    static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    static final float TILE_SIZE = getMinDimension() / 8;

    static final float BUTTON_WIDTH = SCREEN_WIDTH / 4;
    static final float BUTTON_HEIGHT = SCREEN_HEIGHT / 10;

    static float getMinDimension() {
        return (SCREEN_HEIGHT > SCREEN_WIDTH) ? SCREEN_WIDTH : SCREEN_HEIGHT;
    }

    static float getMaxDimension() {
        return (SCREEN_HEIGHT > SCREEN_WIDTH) ? SCREEN_HEIGHT : SCREEN_WIDTH;
    }
}
