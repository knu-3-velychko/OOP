package com.tai.lab3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class CheckersGameScreen implements Screen {

    final MainCore gameCore;

    private Board board;
    private Checkers checkers;

    public CheckersGameScreen(MainCore gameCore, Constants.Color color) {
        this.gameCore = gameCore;

        board = new Board();
        checkers = new Checkers(color);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        board.render();
        checkers.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
