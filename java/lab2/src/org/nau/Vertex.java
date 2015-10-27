package org.nau;

/**
 * Represents a vertex of a shape.
 */
public class Vertex {
    private final int x;

    private final int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ".";
    }
}
