package com.tai.lab3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

class CheckersMain extends ApplicationAdapter {
    private CustomSpriteBatch batch;
    Board board;

    @Override
    public void create() {
        batch = new CustomSpriteBatch();
        board = new Board();
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        board.render(batch);
        batch.end();
    }
}
