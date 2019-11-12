package game;

public class Velocity2D {
    private Pair start;

    public Pair getStart() {
        return start;
    }

    public void setStart(Pair start) {
        this.start = start;
    }

    public Pair getVector() {
        return vector;
    }

    public void setVector(Pair vector) {
        this.vector = vector;
    }

    private Pair vector;

    Velocity2D(Pair start, Pair vector) {
        this.start = start;
        this.vector = vector;
    }
}
