package com.tai.lab3;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Checkers {

    enum Type {
        NONE,
        WHITE, BLACK,
        WHITE_HOVER, BLACK_HOVER,
        WHITE_KING, BLACK_KING,
        WHITE_KING_HOVER, BLACK_KING_HOVER
    }

    Type[][] matrix;

    Type playerColor;

    private Texture blackPiece;
    private Texture whitePiece;
    private Texture hoverBlackPiece;
    private Texture hoverWhitePiece;
    private Texture blackPieceKing;
    private Texture whitePieceKing;
    private Texture hoverBlackPieceKing;
    private Texture hoverWhitePieceKing;

    private SpriteBatch batch;

    Checkers(Constants.Color color) {
        batch = new SpriteBatch();

        playerColor = (color == Constants.Color.Black ? Type.BLACK : Type.WHITE);

        matrix = new Type[Constants.SIZE][Constants.SIZE];

        this.blackPiece = new Texture("BlackPiece.png");
        this.whitePiece = new Texture("WhitePiece.png");
        this.hoverBlackPiece = new Texture("BlackPiece_hover.png");
        this.hoverWhitePiece = new Texture("WhitePiece_hover.png");
        this.blackPieceKing = new Texture("BlackKing.png");
        this.whitePieceKing = new Texture("WhiteKing.png");
        this.hoverBlackPieceKing = new Texture("BlackKing_hover.png");
        this.hoverWhitePieceKing = new Texture("WhiteKing_hover.png");

        setMatrix();
    }

    boolean setHover(int i, int j) {
        switch (matrix[i][j]) {
            case WHITE:
                matrix[i][j] = Type.WHITE_HOVER;
                return true;
            case BLACK:
                matrix[i][j] = Type.BLACK_HOVER;
                return true;
            case WHITE_HOVER:
                matrix[i][j] = Type.WHITE;
                return false;
            case BLACK_HOVER:
                matrix[i][j] = Type.BLACK;
                return false;
            case WHITE_KING:
                matrix[i][j] = Type.WHITE_KING_HOVER;
                return true;
            case BLACK_KING:
                matrix[i][j] = Type.BLACK_KING_HOVER;
                return true;
            case WHITE_KING_HOVER:
                matrix[i][j] = Type.WHITE_KING;
                return false;
            case BLACK_KING_HOVER:
                matrix[i][j] = Type.BLACK_KING;
                return false;
        }

        return true;
    }

    private void setMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = ((i % 2 != j % 2) ? Type.NONE : playerColor);
            }
        }
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = Type.NONE;
            }
        }
        Type type = (playerColor == Type.BLACK ? Type.WHITE : Type.BLACK);
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = ((i % 2 != j % 2) ? Type.NONE : type);
            }
        }
    }

    void render() {
        batch.begin();
        float start = (Constants.getMaxDimension() - Constants.TILE_SIZE * 8) / 2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Texture tile = null;
                switch (matrix[i][j]) {
                    case WHITE:
                        tile = whitePiece;
                        break;
                    case BLACK:
                        tile = blackPiece;
                        break;
                    case WHITE_HOVER:
                        tile = hoverWhitePiece;
                        break;
                    case BLACK_HOVER:
                        tile = hoverBlackPiece;
                        break;
                    case WHITE_KING:
                        tile = whitePieceKing;
                        break;
                    case BLACK_KING:
                        tile = blackPieceKing;
                        break;
                    case WHITE_KING_HOVER:
                        tile = hoverWhitePieceKing;
                        break;
                    case BLACK_KING_HOVER:
                        tile = hoverBlackPieceKing;
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
