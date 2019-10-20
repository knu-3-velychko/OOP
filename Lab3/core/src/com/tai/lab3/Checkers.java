package com.tai.lab3;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Checkers {

    short[][] matrix = {
            {2, 0, 2, 0, 2, 0, 2, 0},
            {0, 2, 0, 2, 0, 2, 0, 2},
            {2, 0, 2, 0, 2, 0, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1}
    };

    private Texture blackPiece;
    private Texture whitePiece;
    private Texture hoverBlackPiece;
    private Texture hoverWhitePiece;

    private SpriteBatch batch;

    Checkers(Constants.Color color) {
        batch = new SpriteBatch();

        this.blackPiece = new Texture("BlackPiece.png");
        this.whitePiece = new Texture("WhitePiece.png");
        this.hoverBlackPiece = new Texture("BlackPiece_hover.png");
        this.hoverWhitePiece = new Texture("WhitePiece_hover.png");
    }

    void render() {
        batch.begin();
        float start = (Constants.getMaxDimension() - Constants.TILE_SIZE * 8) / 2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Texture tile = null;
                switch (matrix[i][j]) {
                    case 1:
                        tile = whitePiece;
                        break;
                    case 2:
                        tile = blackPiece;
                        break;
                }
                if (tile != null) {
                    batch.draw(tile,
                            j * Constants.TILE_SIZE + start,
                            i * Constants.TILE_SIZE,
                            Constants.TILE_SIZE,
                            Constants.TILE_SIZE);
                }
            }
        }
        batch.end();
    }
}
