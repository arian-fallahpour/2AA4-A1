package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class RightHandAlgorithmTest {
    private static Maze maze = Maze.getInstance();
    
    @Test
    public void shouldSolveStraightMazeCanonical() {
        maze.load("./examples/straight.maz.txt");
        Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getCanonicalForm(), "FFFF");
    }

    @Test
    public void shouldSolveStraightMazeFactored() {
        maze.load("./examples/straight.maz.txt");
        Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getFactoredForm(), "4F ");
    }
    
    @Test
    public void shouldSolveSmallMaze() {
        maze.load("./examples/small.maz.txt");
        Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
        algorithm.solveMaze(maze);
        Assertions.assertEquals(algorithm.getPath().getFactoredForm(), "F R F 2R 2F R 2F R 2F 2R 4F R 2F R 4F 2R 2F R 4F R 2F R 2F 2R 2F L 2F L 4F R 2F R 2F 2R 4F R 2F R 2F 2R 2F R 2F R 4F R 2F L 2F R 2F L F ");
    }
}
