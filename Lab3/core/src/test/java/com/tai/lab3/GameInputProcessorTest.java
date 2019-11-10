package com.tai.lab3;

import org.junit.jupiter.api.Test;

class GameInputProcessorTest {
    private GameInputProcessor gameInputProcessor = new GameInputProcessor();

    @Test
    void keyDown() {
        assert (!gameInputProcessor.keyDown(10));
    }

    @Test
    void keyUp() {
        assert (!gameInputProcessor.keyUp(10));
    }

    @Test
    void keyTyped() {
        assert (!gameInputProcessor.keyTyped('A'));
    }

    @Test
    void touchDown() {
        //TODO
    }

    @Test
    void touchUp() {
        assert (!gameInputProcessor.touchUp(1, 2, 3, 4));
    }

    @Test
    void touchDragged() {
        assert (!gameInputProcessor.touchDragged(1, 2, 3));
    }

    @Test
    void mouseMoved() {
        assert (!gameInputProcessor.mouseMoved(10, 10));
    }

    @Test
    void scrolled() {
        assert (!gameInputProcessor.scrolled(100));
    }
}