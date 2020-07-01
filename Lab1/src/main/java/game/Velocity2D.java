package game;

import javafx.util.Pair;

public class Velocity2D {
    private Pair<Float,Float> start;

    public Pair<Float,Float> getStart() {
        return start;
    }

    public void setStart(Pair<Float,Float> start) {
        this.start = start;
    }

    public Pair<Float,Float> getVector() {
        return vector;
    }

    public void setVector(Pair<Float,Float> vector) {
        this.vector = vector;
    }

    private Pair vector;

    Velocity2D(Pair<Float,Float> start, Pair<Float,Float> vector) {
        this.start = start;
        this.vector = vector;
    }
}
