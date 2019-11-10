package com.tai.lab3;

import com.badlogic.gdx.graphics.Texture;

public class Board {
    private Texture blackSquare;
    private Texture whiteSquare;
    private Texture hoverBlackSquare;
    private Texture hoverWhiteSquare;


    public Board() {
        this.blackSquare = new Texture("@drawable/ic_blacksquare");
        this.whiteSquare = new Texture("@drawable/ic_whitesquare");
        this.hoverBlackSquare = new Texture("@drawable/ic_blacksquare_square");
        this.hoverWhiteSquare = new Texture("@drawable/ic_blacksquare_hover");
    }

    public void render(CustomSpriteBatch batch) {
        drawCorners(batch);
        drawEdges(batch);
        drawInternal(batch);
    }

    private void drawCorners(CustomSpriteBatch batch) {
        //top left
        batch.draw(blackSquare, 0, Constants.SCREEN_HEIGHT - Constants.TILE_SIZE, false, false);

        //top right
        batch.draw(whiteSquare,
                Constants.SCREEN_WIDTH - Constants.TILE_SIZE,
                Constants.SCREEN_HEIGHT - Constants.TILE_SIZE,
                true, false);

        //bottom left
        batch.draw(whiteSquare, 0, 0, false, true);

        //bootom right
        batch.draw(blackSquare, Constants.SCREEN_WIDTH - Constants.TILE_SIZE, 0, true, true);
    }

    private void drawEdges(CustomSpriteBatch batch) {
        for (int i = 1; i < 7; i++) {
            //left
            batch.draw((i % 2) == 0 ? whiteSquare : blackSquare, 0, i * Constants.TILE_SIZE, 90);

            //right
            batch.draw((i % 2) != 0 ? whiteSquare : blackSquare, Constants.SCREEN_WIDTH - Constants.TILE_SIZE, i * Constants.TILE_SIZE, 270);

            //bottom
            batch.draw((i % 2) == 0 ? whiteSquare : blackSquare, i * Constants.TILE_SIZE, 0, 180);

            //top
            batch.draw((i % 2) != 0 ? whiteSquare : blackSquare, i * Constants.TILE_SIZE, Constants.SCREEN_HEIGHT - Constants.TILE_SIZE, 0);
        }
    }

    private void drawInternal(CustomSpriteBatch batch) {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                batch.draw(i % 2 != j % 2 ? blackSquare : whiteSquare, i * Constants.TILE_SIZE, j * Constants.TILE_SIZE);
            }
        }
    }

}
