package com.tai.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {

    @Test
    void valueOf() {
        assert (Type.valueOf("NONE") == Type.NONE);
        assert (Type.valueOf("WHITE") == Type.WHITE);
        assert (Type.valueOf("BLACK") == Type.BLACK);
        assert (Type.valueOf("WHITE_HOVER") == Type.WHITE_HOVER);
        assert (Type.valueOf("BLACK_HOVER") == Type.BLACK_HOVER);
        assert (Type.valueOf("WHITE_KING") == Type.WHITE_KING);
        assert (Type.valueOf("BLACK_KING") == Type.BLACK_KING);
        assert (Type.valueOf("WHITE_KING_HOVER") == Type.WHITE_KING_HOVER);
        assert (Type.valueOf("BLACK_KING_HOVER") == Type.BLACK_KING_HOVER);

        Type[] types = {Type.NONE,
                Type.WHITE, Type.BLACK,
                Type.WHITE_HOVER, Type.BLACK_HOVER,
                Type.WHITE_KING, Type.BLACK_KING,
                Type.WHITE_KING_HOVER, Type.BLACK_KING_HOVER};
        Type[] values = Type.values();

        assert (types.length == values.length);

        for (int i = 0; i < types.length; i++) {
            assert (types[i] == values[i]);
        }
    }
}