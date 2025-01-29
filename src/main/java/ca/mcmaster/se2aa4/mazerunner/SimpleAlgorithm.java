package ca.mcmaster.se2aa4.mazerunner;

public class SimpleAlgorithm extends Algorithm {
    public SimpleAlgorithm(Vector position, Vector direction) {
        super(position, direction);
    }

    public void solveMaze(Maze maze) {
        while (!maze.isEndPosition(this.position)) {
            this.moveForward();
        }
    }
}
