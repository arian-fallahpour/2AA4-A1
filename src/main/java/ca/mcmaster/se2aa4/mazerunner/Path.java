package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;

import ca.mcmaster.se2aa4.mazerunner.enums.Instruction;

public class Path {
    private ArrayList<Instruction> instructions;

    public Path(String instructions) {
        this.setInstructions(instructions);
    }

    private void setInstructions(String instructions) {
        this.instructions = new ArrayList<Instruction>();
        if (instructions == null) return;

        for (int i = 0; i < instructions.length(); i++) {
            String c = Character.toString(instructions.charAt(i));

            Integer instructionCount = 1;
            Boolean isNumber = NumberUtils.isCreatable(c);
            if (isNumber) {
                instructionCount = Integer.valueOf(c);
                i++;
            }

            c = Character.toString(instructions.charAt(i));
            for (int j = 0; j < instructionCount; j++) {
                Instruction instruction = Instruction.valueOf(c);
                this.instructions.add(instruction);
            }
        }
    }

    // Returns true if the provided path solves the maze, otherwise false
    public Boolean verify(Maze maze) {
        Vector position = maze.getStartPosition();
        Vector direction = maze.getStartDirection();
        
        for (int i = 0; i < this.instructions.size(); i++) {
            if (maze.isOutOfBounds(position) || !maze.isPositionEmpty(position)) {
                return false;
            }

            Instruction instruction = this.instructions.get(i);
            if (instruction.equals(Instruction.F)) {
                position.add(direction);
            } else {
                direction.rotate(instruction);
            }
        }

        if (!maze.isEndPosition(position)) {
            return false;
        }

        return true;
    }

    public void addInstruction(Instruction instruction) {
        this.instructions.add(instruction);
    }

    public ArrayList<Instruction> getInstructions() {
        return this.instructions;
    }

    // Returns a more readable instructions in canonical form
    public String getCanonicalForm() {
        String canonicalInstructions = "";

        for (int i = 0; i < this.instructions.size(); i++) {
            Instruction instruction = this.instructions.get(i);
            Boolean sameAsLastCharacter = i == 0 || instruction == this.instructions.get(i - 1);
            if (!sameAsLastCharacter) {
                canonicalInstructions += " ";
            } 

            canonicalInstructions += instruction.toString();
        }
        
        return canonicalInstructions;
    }
    
    // Returns a more readable instructions in factored form
    public String getFactoredForm() {
        String factoredForm = "";
        
        Integer length = this.instructions.size();
        for (int l = 0; l < length; l++) {
            int r = l;

            int count = 0;
            while (r < length && this.instructions.get(l) == this.instructions.get(r)) {
                r++;
                count++;
            }

            if (count > 1) factoredForm += count;
            factoredForm += this.instructions.get(l);
            l = r - 1;
            if (l < length - 1) factoredForm += " ";
        }
        
        return factoredForm;
    }
}
