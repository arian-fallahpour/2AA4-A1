package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private String file;
    private String[][] maze;
    private Vector startPosition;
    private Vector endPosition;

    public Maze(String file) {
        this.file = file;
    }

    public void loadMaze() {}

    public void displayMaze() {}
    
    public Boolean isPositionEmpty(Vector position) {
        return false;
    }
}
