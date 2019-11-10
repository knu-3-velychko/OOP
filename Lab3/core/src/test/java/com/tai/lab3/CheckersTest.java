package com.tai.lab3;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

class CheckersTest {
    Constants constants = mock(Constants.class);

    Checkers checkersBlack = new Checkers(constants, Color.Black);
    Checkers checkersWhite = new Checkers(constants, Color.White);

    CheckersTest(){
        
    }

    @Test
    void setHover() {
        assertEquals(checkersBlack.setHover());
    }

    @Test
    void movePiece() {
    }
}