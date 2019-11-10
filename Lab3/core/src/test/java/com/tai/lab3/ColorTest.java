package com.tai.lab3;

import org.junit.jupiter.api.Test;

class ColorTest {

    @Test
    void valueOf() {
        assert (Color.valueOf("White") == Color.White);
        assert (Color.valueOf("Black") == Color.Black);

        Color[] colors = {Color.White, Color.Black};
        Color[] values = Color.values();

        assert (colors.length == values.length);

        for (int i = 0; i < colors.length; i++) {
            assert (colors[i] == values[i]);
        }
    }
}