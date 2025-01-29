package ca.mcmaster.se2aa4.mazerunner;

public class Vector {
    public Integer x;
    public Integer y;

    public Vector(Integer x, Integer y) {
        this.x = x != null ? x : 0;
        this.y = y != null ? y : 0;
    }

    public Vector copy() {
        return new Vector(this.x, this.y);
    }

    public Vector add(Vector vector) {
        Integer x2 = this.x + vector.x;
        Integer y2 = this.y + vector.y;
        this.x = x2;
        this.y = y2;
        return this;
    }

    // Rotates the vector 90 degrees in the specified direction and magnitude
    public Vector rotate90(Integer direction) {
        Integer x2 = this.y * (-direction % 2);
        Integer y2 = -this.x * (-direction % 2);
        this.x = x2;
        this.y = y2;
        return this;   
    }
}
