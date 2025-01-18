package ca.mcmaster.se2aa4.mazerunner;

public class Vector {
    public Integer x;
    public Integer y;

    public Vector(Integer x, Integer y) {
        this.x = x != null ? x : 0;
        this.y = y != null ? y : 0;
    }

    public Vector add(Vector vector) {
        return this;
    }

    public Vector rotate(Integer count) {
        return this;
    }
}
