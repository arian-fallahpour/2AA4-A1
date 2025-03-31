package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {
    private String[][] grid;
    private Integer rows = 0;
    private Integer cols = 0;

    private Vector startPosition;
    private Vector startDirection;
    private Vector endPosition;

    private static Maze instance = new Maze();

    private Maze() {}

    public static Maze getInstance() {
        return instance;
    }

    public void print() {
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
                System.out.print(this.grid[r][c]);
            }
            System.out.print(System.lineSeparator());
        }
        System.out.print(System.lineSeparator());
    }

    public void load(String filePath) {
        this.setTempGrid(filePath);
        this.setSizedGrid();
        
        this.setStartPosition();
        this.setEndPosition();
        this.setStartDirection();
    }

    private void setTempGrid(String filePath) {
        this.rows = 0;
        this.cols = 0;
        
        String[][] temp = new String[10000][10000];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            String line;
            while ((line = reader.readLine()) != null) {
                for (int c = 0; c < line.length(); c++) {
                    Character character = line.charAt(c);
                    if (character == '#') { temp[this.rows][c] = "#"; }
                    if (c + 1 > this.cols) { this.cols = c + 1; }
                }
                this.rows++;
            }

            reader.close();
        } catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        this.grid = temp;
    }

    private void setSizedGrid() {
        String[][] temp = this.grid.clone();

        this.grid = new String[this.rows][this.cols];
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                this.grid[r][c] = temp[r][c] != null ? "#" : " ";
            }
        }
    }
    
    private void setStartPosition() {
        for (int r = 0; r < this.grid.length; r++) {
            if (this.grid[r][0].equals(" ")) {
                this.startPosition = new Vector(0, r);
                break;
            }
        }
    }

    private void setEndPosition() {
        Integer lastCol = this.grid[0].length - 1;
        for (int r = 0; r < this.grid.length; r++) {
            if (this.grid[r][lastCol].equals(" ")) {
                this.endPosition = new Vector(lastCol, r);
                break;
            }
        }
    }

    private void setStartDirection() {
        this.startDirection = new Vector(1, 0);
    }
    
    // Checks if the position is empty on maze at specified position
    public Boolean isPositionEmpty(Vector position) {
        return this.grid[position.y][position.x] == " ";
    }

    // Checks if the position is the end poisition on maze at specified position
    public Boolean isEndPosition(Vector position) {
        return position.x == this.endPosition.x && position.y == this.endPosition.y;
    }

    public Boolean isOutOfBounds(Vector position) {
        Integer rows = this.grid.length;
        Integer cols = this.grid[0].length;
        return position.x < 0 || position.x >= cols || position.y < 0 || position.y >= rows;
    }

    public Vector getStartPosition() {
        return this.startPosition;
    }

    public Vector getEndPosition() {
        return this.endPosition;
    }

    public Vector getStartDirection() {
        return this.startDirection;
    }
}
