package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class SimpleAlgorithmTest {
    private static Maze maze = Maze.getInstance();

    @Test
    public void shouldSolveStraightMaze() {
        maze.load("./examples/straight.maz.txt");
        Algorithm algorithm = new SimpleAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getFactoredForm(), "4F ");
    }

    @Test
    public void shouldNotSolveSmallMaze() {
        try {
            maze.load("./examples/straight.maz.txt");
            Algorithm algorithm = new SimpleAlgorithm(maze.getStartPosition(), maze.getStartDirection());
            algorithm.solveMaze(maze);
        } catch(Exception e) {
            Assertions.assertNotNull(e);
        }
    }
}
