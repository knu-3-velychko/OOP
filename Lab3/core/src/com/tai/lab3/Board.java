package com.tai.lab3;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Board {
    private enum Color {BLACK, WHITE, WHITE_HOVER, BLACK_HOVER, HIGHTLIGHTED}

    private Texture blackSquare;
    private Texture whiteSquare;
    private Texture hoverBlackSquare;
    private Texture hoverWhiteSquare;
    private Texture highlightedSquare;

    private SpriteBatch batch;

    private Color[][] matrix;

    Board() {
        batch = new SpriteBatch();
        matrix = new Color[Constants.SIZE][Constants.SIZE];

        this.blackSquare = new Texture("BlackSquare.png");
        this.whiteSquare = new Texture("WhiteSquare.png");
        this.hoverBlackSquare = new Texture("BlackSquare_hover.png");
        this.hoverWhiteSquare = new Texture("WhiteSquare_hover.png");
        this.highlightedSquare = new Texture("HighlightedSquare.png");

        setMatrix();
    }

    void setMatrix() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = ((i % 2 != j % 2) ? Color.WHITE : Color.BLACK);
            }
        }
    }

    void setHightlighted(int i, int j) {
        matrix[i][j] = Color.HIGHTLIGHTED;
    }

    void setHover(int i, int j) {
        if (matrix[i][j] == Color.BLACK)
            matrix[i][j] = Color.BLACK_HOVER;
        else
            matrix[i][j] = Color.WHITE_HOVER;
    }

    void render() {
        batch.begin();
        float start = (Constants.getMaxDimension() - Constants.TILE_SIZE * 8) / 2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Texture square = null;
                switch (matrix[i][j]) {
                    case BLACK:
                        square = blackSquare;
                        break;
                    case WHITE:
                        square = whiteSquare;
                        break;
                    case BLACK_HOVER:
                        square = hoverBlackSquare;
                        matrix[i][j] = Color.BLACK;
                        break;
                    case WHITE_HOVER:
                        square = hoverWhiteSquare;
                        matrix[i][j] = Color.WHITE;
                        break;
                    case HIGHTLIGHTED:
                        square = highlightedSquare;
                        break;
                    default:
                }
                batch.draw(square,
                        j * Constants.TILE_SIZE + start,
                        i * Constants.TILE_SIZE,
                        Constants.TILE_SIZE,
                        Constants.TILE_SIZE);
            }
        }
        batch.end();
    }

}
