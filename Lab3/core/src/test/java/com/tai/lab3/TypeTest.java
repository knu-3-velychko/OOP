package com.tai.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeTest {

    @Test
    void valueOf() {
        assertEquals(Type.valueOf("NONE"), Type.NONE);
        assertEquals(Type.valueOf("WHITE"), Type.WHITE);
        assertEquals(Type.valueOf("BLACK"), Type.BLACK);
        assertEquals(Type.valueOf("WHITE_HOVER"), Type.WHITE_HOVER);
        assertEquals(Type.valueOf("BLACK_HOVER"), Type.BLACK_HOVER);
        assertEquals(Type.valueOf("WHITE_KING"), Type.WHITE_KING);
        assertEquals(Type.valueOf("BLACK_KING"), Type.BLACK_KING);
        assertEquals(Type.valueOf("WHITE_KING_HOVER"), Type.WHITE_KING_HOVER);
        assertEquals(Type.valueOf("BLACK_KING_HOVER"), Type.BLACK_KING_HOVER);

        Type[] types = {Type.NONE,
                Type.WHITE, Type.BLACK,
                Type.WHITE_HOVER, Type.BLACK_HOVER,
                Type.WHITE_KING, Type.BLACK_KING,
                Type.WHITE_KING_HOVER, Type.BLACK_KING_HOVER};
        Type[] values = Type.values();

        assertEquals(types.length, values.length);

        for (int i = 0; i < types.length; i++) {
            assertEquals(types[i], values[i]);
        }
    }
}