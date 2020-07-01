package game;

import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;


public class Velocity2DTest {

    private Pair<Float, Float> start=new Pair<>(10.0f, 20.0f);
    private Pair<Float, Float> vector=new Pair<>(30.0f, 40.0f);

    private Velocity2D velocity2D=new Velocity2D(start,vector);

    @Test
    public void getStart() {
        assertEquals(start,velocity2D.getStart());
    }

    @Test
    public void setStart() {
        Pair<Float, Float> newStart=new Pair<>(5.0f, 10.0f);
        velocity2D.setStart(newStart);
        assertEquals(newStart,velocity2D.getStart());
    }

    @Test
    public void getVector() {
        assertEquals(vector,velocity2D.getVector());
    }

    @Test
    public void setVector() {
        Pair<Float, Float> newVector=new Pair<>(10.0f, 30.0f);
        velocity2D.setVector(newVector);
        assertEquals(newVector,velocity2D.getVector());
    }
}