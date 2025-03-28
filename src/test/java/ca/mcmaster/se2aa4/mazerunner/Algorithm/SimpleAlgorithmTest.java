package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class SimpleAlgorithmTest {
    @Test
    public void shouldSolveStraightMaze() {
        Maze maze = new Maze("./examples/straight.maz.txt");
        Algorithm algorithm = new SimpleAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getFactoredInstructions(), "4F ");
    }

    @Test
    public void shouldNotSolveSmallMaze() {
        try {
            Maze maze = new Maze("./examples/straight.maz.txt");
            Algorithm algorithm = new SimpleAlgorithm(maze.getStartPosition(), maze.getStartDirection());
            algorithm.solveMaze(maze);
        } catch(Exception e) {
            Assertions.assertNotNull(e);
        }
    }
}
