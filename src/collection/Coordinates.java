package collection;

public class Coordinates {
    private float x;
    private int y;

    public Coordinates(float x, int y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
