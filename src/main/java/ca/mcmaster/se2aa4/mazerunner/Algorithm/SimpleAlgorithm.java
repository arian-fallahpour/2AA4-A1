package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Vector;

public class SimpleAlgorithm extends Algorithm {
    public SimpleAlgorithm(Vector position, Vector direction) {
        super(position, direction);
    }

    public void solveMaze(Maze maze) {
        try {
            while (!maze.isEndPosition(this.position)) {
                if (maze.isOutOfBounds(this.position)) {
                    throw new Error("Algorithm failed to solve maze");
                }
            
                this.moveForward();
            }
        } catch(Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
