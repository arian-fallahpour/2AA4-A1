package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Player {
    private Vector direction;
    private Vector position;
    private ArrayList<String> instructions;

    public Player(Vector position, Vector direction) {
        this.direction = direction;
        this.position = position;
        this.instructions = new ArrayList<String>();
    }

    // Moves player one step forward in the direction they are facing
    public void moveForward() {
        this.position.add(this.direction);
        this.instructions.add("F");
    }
    
    // Turns player's direction 90 degrees clockwise
    public void turnClockwise() {
        this.direction.rotate90(1);
        this.instructions.add("R");
    }
    
    // Turns player's direction 90 degrees counter clockwise
    public void turnCounterClockwise() {
        this.direction.rotate90(-1);
        this.instructions.add("L");
    }
    
    // Traverses the maze 
    public void traverseMaze(Maze maze) {
        Vector endPosition = maze.getEndPosition();
        while (this.position.x != endPosition.x || this.position.y != endPosition.y) {
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

    // Returns player's instructions
    public ArrayList<String> getInstructions() {
        return this.instructions;
    }

    // Displays player's instructions
    public void displayInstructions() {
        for (int i = 0; i < this.instructions.size(); i++) {
            System.out.print(this.instructions.get(i));
        }
        System.out.print(System.lineSeparator());
    }
}
