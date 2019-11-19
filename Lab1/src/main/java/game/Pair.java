package game;

class Pair {
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float x;
    private float y;

    Pair(float x, float y) {
        this.x = x;
        this.y = y;
    }


}