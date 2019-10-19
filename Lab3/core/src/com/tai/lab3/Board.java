package com.tai.lab3;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Board {
    private Texture blackSquare;
    private Texture whiteSquare;
    private Texture hoverBlackSquare;
    private Texture hoverWhiteSquare;

    private SpriteBatch batch;


    Board() {
        batch = new SpriteBatch();

        this.blackSquare = new Texture("BlackSquare.png");
        this.whiteSquare = new Texture("WhiteSquare.png");
        this.hoverBlackSquare = new Texture("BlackSquare_hover.png");
        this.hoverWhiteSquare = new Texture("BlackSquare_hover.png");
    }

    void render() {
        batch.begin();
        float start = (Constants.getMaxDimension() - Constants.TILE_SIZE * 8) / 2;
        System.out.println(Constants.getMaxDimension());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                batch.draw(i % 2 != j % 2 ? whiteSquare : blackSquare,
                        j * Constants.TILE_SIZE + start,
                        i * Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        Constants.TILE_SIZE);
            }
        }
        batch.end();
    }

}
