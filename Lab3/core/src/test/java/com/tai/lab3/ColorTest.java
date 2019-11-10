package com.tai.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorTest {

    @Test
    void valueOf() {
        assertEquals(Color.valueOf("White"), Color.White);
        assertEquals(Color.valueOf("Black"), Color.Black);

        Color[] colors = {Color.White, Color.Black};
        Color[] values = Color.values();

        assertEquals(colors.length, values.length);

        for (int i = 0; i < colors.length; i++) {
            assertEquals(colors[i], values[i]);
        }
    }
}