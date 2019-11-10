package com.tai.lab3;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static com.badlogic.gdx.Input.Buttons;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameInputProcessorTest {
    private Checkers checkers = mock(Checkers.class);
    private GameInputProcessor blackInputProcessor = new GameInputProcessor(checkers, false);
    private GameInputProcessor whiteInputProcessor = new GameInputProcessor(checkers, true);


    @Test
    void keyDown() {
        assertFalse(blackInputProcessor.keyDown(10));
        assertFalse(whiteInputProcessor.keyDown(10));
    }

    @Test
    void keyUp() {
        assertFalse(blackInputProcessor.keyUp(10));
        assertFalse(whiteInputProcessor.keyUp(10));
    }

    @Test
    void keyTyped() {
        assertFalse(blackInputProcessor.keyTyped('A'));
        assertFalse(whiteInputProcessor.keyTyped('A'));
    }

    @Test
    void touchDownHover() {
        Checkers mock = mock(Checkers.class);

        when(mock.setHover(anyInt(), anyInt(), anyBoolean())).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) {
                return true;
            }
        });

        when(mock.movePiece(anyInt(), anyInt(), anyBoolean())).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) {
                return true;
            }
        });

        GameInputProcessor blackInputProcessorNew = new GameInputProcessor(mock, false);
        GameInputProcessor whiteInputProcessorNew = new GameInputProcessor(mock, true);

        assertFalse(blackInputProcessorNew.touchDown(10, 10, 0, Buttons.LEFT));
        assertFalse(blackInputProcessorNew.touchDown(10, 10, 0, Buttons.RIGHT));

        assertFalse(blackInputProcessorNew.touchDown(10, 10, 1, Buttons.LEFT));
        assertFalse(blackInputProcessorNew.touchDown(10, 10, 1, Buttons.RIGHT));

        assertTrue(whiteInputProcessorNew.touchDown(10, 10, 0, Buttons.LEFT));

        assertTrue(whiteInputProcessorNew.touchDown(10, 10, 0, Buttons.LEFT));
        assertFalse(whiteInputProcessorNew.touchDown(10, 10, 0, Buttons.RIGHT));
        assertFalse(whiteInputProcessorNew.touchDown(10, 10, 1, Buttons.LEFT));
        assertFalse(whiteInputProcessorNew.touchDown(10, 10, 1, Buttons.RIGHT));
    }

    @Test
    void touchDownNotHover() {

        assertFalse(blackInputProcessor.touchDown(10, 10, 0, Buttons.LEFT));
        assertFalse(blackInputProcessor.touchDown(10, 10, 0, Buttons.RIGHT));
        assertFalse(blackInputProcessor.touchDown(10, 10, 1, Buttons.LEFT));
        assertFalse(blackInputProcessor.touchDown(10, 10, 1, Buttons.RIGHT));

        assertTrue(whiteInputProcessor.touchDown(10, 10, 0, Buttons.LEFT));
        assertFalse(whiteInputProcessor.touchDown(10, 10, 0, Buttons.RIGHT));
        assertFalse(whiteInputProcessor.touchDown(10, 10, 1, Buttons.LEFT));
        assertFalse(whiteInputProcessor.touchDown(10, 10, 1, Buttons.RIGHT));
    }

    @Test
    void touchUp() {
        assertFalse(blackInputProcessor.touchUp(10, 10, 10, Buttons.LEFT));
        assertFalse(blackInputProcessor.touchUp(10, 10, 10, Buttons.RIGHT));

        assertFalse(whiteInputProcessor.touchUp(10, 10, 10, Buttons.LEFT));
        assertFalse(whiteInputProcessor.touchUp(10, 10, 10, Buttons.RIGHT));
    }

    @Test
    void touchDragged() {
        assertFalse(blackInputProcessor.touchDragged(1, 2, 3));
        assertFalse(whiteInputProcessor.touchDragged(1, 2, 3));
    }

    @Test
    void mouseMoved() {
        assertFalse(blackInputProcessor.mouseMoved(10, 10));
        assertFalse(whiteInputProcessor.mouseMoved(10, 10));
    }

    @Test
    void scrolled() {
        assertFalse(blackInputProcessor.scrolled(100));
        assertFalse(whiteInputProcessor.scrolled(100));
    }
}