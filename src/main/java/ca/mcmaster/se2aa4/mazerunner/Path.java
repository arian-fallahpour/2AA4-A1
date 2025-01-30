package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.lang3.math.NumberUtils;

public class Path {
    private String instructions = "";

    public Path(String instructions) {
        if (instructions != null) {
            this.instructions = instructions;
        }
    }

    // Returns true if the provided path solves the maze, otherwise false
    public Boolean verify(Maze maze) {
        Vector position = maze.getStartPosition();
        Vector direction = maze.getStartDirection();
        
        for (int i = 0; i < this.instructions.length(); i++) {
            String c = Character.toString(this.instructions.charAt(i));

            // Check if number was provided before the instruction
            Integer count = 1;
            if (NumberUtils.isCreatable(c)) {
                count = Integer.valueOf(c);
                i++;
            }

            c = Character.toString(this.instructions.charAt(i));
            for (int j = 0; j < count; j++) {
                if (!maze.isPositionEmpty(position) || maze.isOutOfBounds(position)) {
                    return false;
                }

                if (c.equals("F")) {
                    position = position.add(direction);
                } else if (c.equals("R")) {
                    direction.rotate90(1);
                } else if (c.equals("L")) {
                    direction.rotate90(-1);
                }
            }

        }

        if (!maze.isEndPosition(position)) {
            return false;
        }

        return true;
    }

    public void addInstruction(String instruction) {
        this.instructions += instruction;
    }

    public String getInstructions() {
        return this.instructions;
    }

    // Returns a more readable instructions in canonical form
    public String getCanonicalInstructions() {
        String canonicalInstructions = "";

        for (int i = 0; i < this.instructions.length(); i++) {
            Boolean sameAsLastCharacter = i == 0 || this.instructions.charAt(i) == this.instructions.charAt(i - 1);
            if (!sameAsLastCharacter) {
                canonicalInstructions += " ";
            } 

            canonicalInstructions += this.instructions.charAt(i);
        }
        
        return canonicalInstructions;
    }
    
    // Returns a more readable instructions in factored form
    public String getFactoredInstructions() {
        String factoredInstructions = "";
        Integer length = this.instructions.length();

        for (int l = 0; l < length; l++) {
            int r = l;
            int count = 0;
            while (r < length && this.instructions.charAt(l) == this.instructions.charAt(r)) {
                r++;
                count++;
            }

            if (count > 1) {
                factoredInstructions += count;
            }
            factoredInstructions += this.instructions.charAt(l);
            factoredInstructions += " ";
            l = r - 1;
        }
        
        return factoredInstructions;

    }
}
