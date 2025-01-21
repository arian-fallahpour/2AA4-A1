package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {
    private String filePath;
    private String[][] maze;
    private Vector startPosition;
    private Vector endPosition;

    public Maze(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }

        this.filePath = filePath;
    }

    // Loads the maze from the file specified into private variable
    public void loadMaze() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
            String[][] temp = new String[1000][1000];

            // Read maze and ssve it to temp array
            String line;
            Integer maxRows = 0;
            Integer maxCols = 0;
            while ((line = reader.readLine()) != null) {
                for (int c = 0; c < line.length(); c++) {
                    Character character = line.charAt(c);
                    if (character == '#') {
                        temp[maxRows][c] = "#";
                    } else {
                        temp[maxRows][c] = " ";
                    }

                    if (c > maxCols) {
                        maxCols = c;
                    }
                }
                maxRows++;
            }

            reader.close();

            // Copy temp array to maze array with correct size
            this.maze = new String[maxRows][maxCols];
            for (int r = 0; r < maxRows; r++) {
                for (int c = 0; c < maxCols; c++) {
                    this.maze[r][c] = temp[r][c];
                }
            }

            // Set start and end positions
            this.setStartPosition();
            this.setEndPosition();
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    // Displays the maze in the output
    public void displayMaze() {
        for (int r = 0; r < this.maze.length; r++) {
            for (int c = 0; c < this.maze[r].length; c++) {
                System.out.print(this.maze[r][c]);
            }
            System.out.print(System.lineSeparator());
        }
        System.out.print(System.lineSeparator());
    }
    
    private void setStartPosition() {
        for (int r = 0; r < this.maze.length; r++) {
            if (this.maze[r][0] == " ") {
                this.startPosition = new Vector(0, r);
                break;
            }
        }
    }

    private void setEndPosition() {
        Integer lastCol = this.maze[0].length - 1;
        for (int r = 0; r < this.maze.length; r++) {
            if (this.maze[r][lastCol] == " ") {
                this.endPosition = new Vector(lastCol, r);
                break;
            }
        }
    }
    
    // Checks if the position is empty on maze at specified position
    public Boolean isPositionEmpty(Vector position) {
        return this.maze[position.y][position.x] == " ";
    }

    // Checks if the position is the end poisition on maze at specified position
    public Boolean isEndPosition(Vector position) {
        return position.x == this.endPosition.x && position.y == this.endPosition.y;
    }

    public Vector getStartPosition() {
        return this.startPosition;
    }

    public Vector getEndPosition() {
        return this.endPosition;
    }
}
