package com.tai.lab3;

public class CheckersValidator {
    Type playerColor;

    CheckersValidator(Type playerColor) {
        this.playerColor = playerColor;
    }

    boolean validate(Type[][] matrix, int x, int y, boolean playerTurn) {
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

    private boolean canJump(Type[][] matrix) {
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

    private boolean canMove(Type[][] matrix, int x, int y, boolean playerTurn) {
        if (playerTurn) {
            if (matrix[x + 1][y + 1] == Type.NONE || matrix[x - 1][y - 1] == Type.NONE)
                return true;
            else
                return true;
        }
        return false;
    }
}
