package com.tai.lab3;

class Checkers {

    private Type[][] matrix;
    private CheckersValidator validator;

    private Type playerColor;

    private float start;

    private int x;
    private int y;

    private CheckersRenderer checkersRenderer;

    private Constants constants;

    Checkers(Constants constants, Color color) {
        this.constants = constants;

        start = (Constants.getMaxDimension() - Constants.TILE_SIZE * 8) / 2;

        playerColor = (color == Color.Black ? Type.BLACK : Type.WHITE);

        matrix = new Type[Constants.SIZE][Constants.SIZE];

        setMatrix();

        checkersRenderer = new CheckersRenderer(start);
        validator = new CheckersValidator(playerColor);
    }

    void render() {
        checkersRenderer.render(matrix);
    }

    boolean setHover(int xPos, int yPos, boolean playerTurn) {
        int j = (int) ((xPos - start) / Constants.TILE_SIZE);
        int i = 7 - (int) (yPos / Constants.TILE_SIZE);

        if (!validator.validate(matrix, i, j, playerTurn))
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
//
//        if (playerTurn && i <= x)
//            return true;
//        if (!playerTurn && i >= x)
//            return true;
//
//        if (j != y + 2 && j != y + 1 && j != y - 2 && j != y - 1)
//            return true;
//
//        System.out.println(i);
//        System.out.println(j);
//
//        if (j == y + 1 || j == y - 1) {
//
//            if (i != x + 1 && i != x - 1)
//                return true;
//
//            if (matrix[i][j] != Type.NONE)
//                return true;
//
//        }
//
//        if (j == y + 2 || j == y - 2) {
//            if (i != x + 2 && i != x - 2)
//                return true;
//            if (matrix[i][j] != Type.NONE)
//                return true;
//
//            if (j == y + 2) {
//                if (matrix[i - 1][j - 1] == Type.NONE || isPlayerColor(matrix[i - 1][j - 1]))
//                    return true;
//                else
//                    matrix[i - 1][j - 1] = Type.NONE;
//            } else if (j == y - 2) {
//                if (matrix[i - 1][j + 1] == Type.NONE || isPlayerColor(matrix[i - 1][j - 1]))
//                    return true;
//                else
//                    matrix[i - 1][j + 1] = Type.NONE;
//            } else
//                return true;
//
//        }
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = Type.NONE;
        x = i;
        y = j;
        return setPieceState();
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


}
