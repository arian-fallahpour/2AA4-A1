package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.Vector;

public abstract class Algorithm {
    protected Vector direction;
    protected Vector position;
    protected Path path;

    public Algorithm(Vector position, Vector direction) {
        this.direction = direction;
        this.position = position;
        this.path = new Path("");
    }

    // Moves position one step forware in current direction
    public void moveForward() {
        this.position.add(this.direction);
        this.path.addInstruction("F");
    }
    
    // Turns current direction 90 degrees clockwise
    public void turnClockwise() {
        this.direction.rotate90(1);
        this.path.addInstruction("R");
    }
    
    // Turns current direction 90 degrees counter clockwise
    public void turnCounterClockwise() {
        this.direction.rotate90(-1);
        this.path.addInstruction("L");
    }

    // Returns player's position
    public Vector getPosition() {
        return this.position;
    }
    
    // Returns player's direction
    public Vector getDirection() {
        return this.direction;
    }
    
    // Returns the path class instance the was created
    public Path getPath() {
        return this.path;
    }

    public abstract void solveMaze(Maze maze);
}
