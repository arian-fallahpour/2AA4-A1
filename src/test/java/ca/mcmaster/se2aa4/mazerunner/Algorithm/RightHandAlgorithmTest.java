package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class RightHandAlgorithmTest {
    
    @Test
    public void shouldSolveStraightMazeCanonical() {
        Maze maze = new Maze("./examples/straight.maz.txt");
        Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getCanonicalInstructions(), "FFFF");
    }

    @Test
    public void shouldSolveStraightMazeFactored() {
        Maze maze = new Maze("./examples/straight.maz.txt");
        Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getFactoredInstructions(), "4F ");
    }
    
    @Test
    public void shouldSolveSmallMaze() {
        Maze maze = new Maze("./examples/small.maz.txt");
        Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getFactoredInstructions(), "F R F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 2F R 4F R 2F R 2F 2R 2F L 2F L 4F R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F R 2F L F ");
    }
}
