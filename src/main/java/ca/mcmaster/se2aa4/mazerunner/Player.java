package ca.mcmaster.se2aa4.mazerunner;

public class Player {
    private Vector direction;
    private Vector position;
    private Path path;

    public Player(Vector position, Vector direction, Path path) {
        this.direction = direction;
        this.position = position;
        this.path = path;
    }

    // Moves player one step forward in the direction they are facing
    public void moveForward() {
        this.position.add(this.direction);
        this.path.addInstruction("F");
    }
    
    // Turns player's direction 90 degrees clockwise
    public void turnClockwise() {
        this.direction.rotate90(1);
        this.path.addInstruction("R");
    }
    
    // Turns player's direction 90 degrees counter clockwise
    public void turnCounterClockwise() {
        this.direction.rotate90(-1);
        this.path.addInstruction("L");
    }
    
    // Traverses the maze 
    public void traverseMaze(Maze maze) {
        while (maze.isEndPosition(this.position) == false) {
            this.moveForward();
        }
    }

    // Returns player's position
    public Vector getPosition() {
        return this.position;
    }
    
    // Returns player's direction
    public Vector getDirection() {
        return this.direction;
    }
    
    // Returns the path the player took
    public Path getPath() {
        return this.path;
    }
}
