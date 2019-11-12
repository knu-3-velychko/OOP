package game;


import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    private final float x = 1.0f;
    private final float y = 3.0f;
    private final float e = (float) 10.0e-10;
    private Pair pair = new Pair(x, y);

    @Test
    public void getX() {
        assertEquals(pair.getX(), x, e);
    }

    @Test
    public void getY() {
        assertEquals(pair.getY(), y, e);
    }

    @Test
    public void setX() {
        pair.setX(5.0f);
        assertEquals(pair.getX(), 5.0d, e);
    }

    @Test
    public void setY() {
        pair.setY(7.0f);
        assertEquals(pair.getY(), 7.0d, e);
    }
}