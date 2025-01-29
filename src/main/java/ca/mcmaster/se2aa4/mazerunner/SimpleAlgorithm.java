package ca.mcmaster.se2aa4.mazerunner;

public class SimpleAlgorithm extends Algorithm {
    public SimpleAlgorithm(Vector position, Vector direction) {
        super(position, direction);
    }

    public void solveMaze(Maze maze) {
        try {
            while (!maze.isEndPosition(this.position)) {
                if (!maze.isPositionEmpty(this.position)) {
                    throw new Error("Algorithm failed to solve maze");
                }
            
                this.moveForward();
            }
        } catch(Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
