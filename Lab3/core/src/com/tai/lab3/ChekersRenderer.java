package com.tai.lab3;

import com.badlogic.gdx.graphics.Texture;

public class ChekersRenderer {
    private Texture blackPiece;
    private Texture whitePiece;
    private Texture hoverBlackPiece;
    private Texture hoverWhitePiece;
    private Texture blackPieceKing;
    private Texture whitePieceKing;
    private Texture hoverBlackPieceKing;
    private Texture hoverWhitePieceKing;

    ChekersRenderer(){
        this.blackPiece = new Texture("BlackPiece.png");
        this.whitePiece = new Texture("WhitePiece.png");
        this.hoverBlackPiece = new Texture("BlackPiece_hover.png");
        this.hoverWhitePiece = new Texture("WhitePiece_hover.png");
        this.blackPieceKing = new Texture("BlackKing.png");
        this.whitePieceKing = new Texture("WhiteKing.png");
        this.hoverBlackPieceKing = new Texture("BlackKing_hover.png");
        this.hoverWhitePieceKing = new Texture("WhiteKing_hover.png");
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
