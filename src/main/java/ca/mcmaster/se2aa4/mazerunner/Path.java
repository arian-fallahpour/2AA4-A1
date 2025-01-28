package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    private String instructions;

    public Path(String instructions) {
        this.instructions = instructions;
    }

    // Returns true if the provided path solves the maze, otherwise false
    public Boolean verify(Maze maze) {
        Vector position = maze.getStartPosition();
        Vector direction = maze.getStartDirection();
        
        for (int i = 0; i < this.instructions.length(); i++) {
            if (!maze.isPositionEmpty(position)) {
                return false;
            }

            char c = this.instructions.charAt(i);
            if (c == 'F') {
                position = position.add(direction);
            } else if (c == 'R') {
                direction.rotate90(1);
            } else if (c == 'L') {
                direction.rotate90(-1);
            }
        }

        if (!maze.isEndPosition(position)) {
            return false;
        }

        return true;

        return true;
    }

    public void addInstruction(String instruction) {
        this.instructions += instruction;
    }

    public String getInstructions() {
        return this.instructions;
    }
}
