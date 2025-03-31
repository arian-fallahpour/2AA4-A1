package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.enums.Instruction;

public class PathTest {
    private static Maze maze = Maze.getInstance();

    @Test
    public void shouldAcceptPath() {
        maze.load("./examples/straight.maz.txt");

        Path path = new Path("FFFF");
        Assertions.assertTrue(path.verify(maze));
    }   
    
    @Test public void shouldRejectPath() {
        maze.load(("./examples/straight.maz.txt"));
        
        Path path = new Path("FLFRFRFLF");
        Assertions.assertFalse(path.verify(maze));
    }

    @Test
    public void shouldReturnCanonicalPath() {
        Path path = new Path("");
        path.addInstruction(Instruction.F);
        path.addInstruction(Instruction.F);
        path.addInstruction(Instruction.F);
        path.addInstruction(Instruction.F);
        Assertions.assertEquals(path.getCanonicalForm(), "FFFF");
    }   
    
    @Test
    public void shouldReturnFactoredPath() {
        Path path = new Path("");
        path.addInstruction(Instruction.F);
        path.addInstruction(Instruction.F);
        path.addInstruction(Instruction.F);
        path.addInstruction(Instruction.F);
        Assertions.assertEquals(path.getFactoredForm(), "4F ");
    }   
}
