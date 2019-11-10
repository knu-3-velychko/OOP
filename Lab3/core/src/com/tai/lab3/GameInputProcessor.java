package com.tai.lab3;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

class GameInputProcessor implements InputProcessor {

    private Checkers checkers;

    private boolean playerTurn;
    private boolean pieceHover = false;

    GameInputProcessor(Checkers checkers, boolean playerTurn) {
        this.checkers = checkers;
        this.playerTurn = playerTurn;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // ignore if its not left mouse button or first touch pointer
        if (button != Input.Buttons.LEFT || pointer > 0 || !playerTurn) return false;
        if (!pieceHover)
            pieceHover = checkers.setHover(screenX, screenY, true);
        else
            pieceHover = checkers.movePiece(screenX, screenY, true);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}