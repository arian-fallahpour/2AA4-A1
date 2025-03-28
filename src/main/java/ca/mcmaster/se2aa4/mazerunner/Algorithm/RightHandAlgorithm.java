package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Vector;

public class RightHandAlgorithm extends Algorithm {
    public RightHandAlgorithm(Vector position, Vector direction) {
        super(position, direction);
    }

    public void solveMaze(Maze maze) {
        try {
            while (!maze.isEndPosition(this.position)) {    
                if (maze.isOutOfBounds(this.position)) {
                    throw new Error("Algorithm failed to solve maze");
                }
                
                Vector nextDirection = this.direction.copy().rotate90(1);
                Vector nextPosition = this.position.copy().add(nextDirection);
                
                int rotate90FromRightCount = 0;
                while (!maze.isPositionEmpty(nextPosition)) {
                    nextDirection = nextDirection.rotate90(-1);
                    nextPosition = this.position.copy().add(nextDirection);
                    rotate90FromRightCount++;
                }
                
                Boolean shouldTurnRight = rotate90FromRightCount == 0;
                Boolean shouldTurnLeft = rotate90FromRightCount == 2;
                Boolean shouldTurnAround = rotate90FromRightCount == 3;
                if (shouldTurnRight) {
                    this.turnClockwise();
                } else if (shouldTurnLeft) {
                    this.turnCounterClockwise();
                } else if (shouldTurnAround) {
                    this.turnClockwise();
                    this.turnClockwise();
                }
                
                this.moveForward();
            }
        } catch(Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
