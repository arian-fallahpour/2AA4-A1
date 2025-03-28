package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Path;

public class PathTest {
    private Maze maze = new Maze("./examples/straight.maz.txt");

    @Test
    public void shouldAcceptPath() {
        Path path = new Path("FFFF");
        Assertions.assertTrue(path.verify(this.maze));
    }   
    
    @Test public void shouldRejectPath() {
        Path path = new Path("FLFRFRFLF");
        Assertions.assertFalse(path.verify(this.maze));
    }

    @Test
    public void shouldReturnCanonicalPath() {
        Path path = new Path("");
        path.addInstruction("F");
        path.addInstruction("F");
        path.addInstruction("F");
        path.addInstruction("F");
        Assertions.assertEquals(path.getCanonicalInstructions(), "FFFF");
    }   
    
    @Test
    public void shouldReturnFactoredPath() {
        Path path = new Path("");
        path.addInstruction("F");
        path.addInstruction("F");
        path.addInstruction("F");
        path.addInstruction("F");
        Assertions.assertEquals(path.getFactoredInstructions(), "4F ");
    }   
}
