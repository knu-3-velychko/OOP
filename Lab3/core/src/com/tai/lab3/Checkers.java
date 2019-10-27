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

    private Type playerColor;

    float start;

    private int x;
    private int y;

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


    boolean setHover(int xPos, int yPos, boolean playerTurn) {

        int j = (int) ((xPos - start) / Constants.TILE_SIZE);
        int i = 7 - (int) (yPos / Constants.TILE_SIZE);
        System.out.println(i);
        System.out.println(j);
        System.out.println(matrix[i][j]);
        if (!validate(i, j, playerTurn))
            return false;

        x = i;
        y = j;

        return setPieceState();
    }

    private boolean setPieceState() {
        switch (matrix[x][y]) {
            case WHITE:
                matrix[x][y] = Type.WHITE_HOVER;
                return true;
            case BLACK:
                matrix[x][y] = Type.BLACK_HOVER;
                return true;
            case WHITE_HOVER:
                matrix[x][y] = Type.WHITE;
                return false;
            case BLACK_HOVER:
                matrix[x][y] = Type.BLACK;
                return false;
            case WHITE_KING:
                matrix[x][y] = Type.WHITE_KING_HOVER;
                return true;
            case BLACK_KING:
                matrix[x][y] = Type.BLACK_KING_HOVER;
                return true;
            case WHITE_KING_HOVER:
                matrix[x][y] = Type.WHITE_KING;
                return false;
            case BLACK_KING_HOVER:
                matrix[x][y] = Type.BLACK_KING;
                return false;
        }
        return false;
    }

    boolean movePiece(int xPos, int yPos, boolean playerTurn) {

        int j = (int) ((xPos - start) / Constants.TILE_SIZE);
        int i = 7 - (int) (yPos / Constants.TILE_SIZE);

        if (i == x && j == y)
            return setPieceState();

        if (playerTurn && i <= x)
            return true;
        if (!playerTurn && i >= x)
            return true;

        if (j != y + 2 && j != y + 1 && j != y - 2 && j != y - 1)
            return true;

        System.out.println(i);
        System.out.println(j);

        if (j == y + 1 || j == y - 1) {

            if (i != x + 1 && i != x - 1)
                return true;

            if (matrix[i][j] != Type.NONE)
                return true;

        }

        if (j == y + 2 || j == y - 2) {
            if (i != x + 2 && i != x - 2)
                return true;
            if (matrix[i][j] != Type.NONE)
                return true;

            if (j == y + 2) {
                if (matrix[i - 1][j - 1] == Type.NONE || isPlayerColor(matrix[i - 1][j - 1]))
                    return true;
                else
                    matrix[i - 1][j - 1] = Type.NONE;
            } else if (j == y - 2) {
                if (matrix[i - 1][j + 1] == Type.NONE || isPlayerColor(matrix[i - 1][j - 1]))
                    return true;
                else
                    matrix[i - 1][j + 1] = Type.NONE;
            } else
                return true;

        }
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = Type.NONE;
        x = i;
        y = j;
        return setPieceState();
    }

    private boolean validate(int x, int y, boolean playerTurn) {
        if (x >= 8 || y >= 8)
            return false;
        boolean valid;
        valid = isPlayerColor(matrix[x][y]);
        return valid && playerTurn;
    }

    private boolean isPlayerColor(Type color) {
        if (playerColor == Type.BLACK)
            return isBlack(color);
        else
            return isWhite(color);
    }

    boolean canJump() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isPlayerColor(playerColor)) {
                    if (!isPlayerColor(matrix[i + 1][j + 1]) &&
                            matrix[i + 2][j + 2] == Type.NONE)
                        return true;
                    if (!isPlayerColor(matrix[i + 1][j - 1]) &&
                            matrix[i + 2][j - 2] == Type.NONE)
                        return true;
                }
            }
        }
        return false;
    }

    boolean canMove(int x, int y, boolean playerTurn) {
        if (playerTurn) {
            if (matrix[x + 1][y + 1] == Type.NONE || matrix[x - 1][y - 1] == Type.NONE)
                return true;
            else
                return true;
        }
        return false;
    }

    private boolean isBlack(Type color) {
        return color == Type.BLACK ||
                color == Type.BLACK_KING ||
                color == Type.BLACK_HOVER ||
                color == Type.BLACK_KING_HOVER;
    }

    private boolean isWhite(Type color) {
        return color == Type.WHITE ||
                color == Type.WHITE_KING ||
                color == Type.WHITE_HOVER ||
                color == Type.WHITE_KING_HOVER;
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
        start = (Constants.getMaxDimension() - Constants.TILE_SIZE * 8) / 2;
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
