package ca.mcmaster.se2aa4.mazerunner;

public class Player {
    Vector direction;
    Vector position;

    public Player(Vector position, Vector direction) {
        this.direction = direction;
        this.position = position;
    }

    public void moveForward() {}
    
    public void turnRight() {}
    
    public void turnLeft() {}
}
