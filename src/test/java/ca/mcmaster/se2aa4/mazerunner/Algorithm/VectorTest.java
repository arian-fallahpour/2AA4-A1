package ca.mcmaster.se2aa4.mazerunner.Algorithm;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ca.mcmaster.se2aa4.mazerunner.Vector;

public class VectorTest {
    @Test
    public void shouldRotate90Degrees() {
        Vector v1 = new Vector(0, 1);
        v1.rotate90(+1);

        Assertions.assertEquals((int) v1.x, -1);
        Assertions.assertEquals((int) v1.y, 0);
    }

    @Test
    public void shouldAddVectors() {
        Vector v1 = new Vector(0, 0);
        Vector v2 = new Vector(2, 2);
        v1.add(v2);

        Assertions.assertEquals((int) v1.x, (int) v2.x);
        Assertions.assertEquals((int) v1.y, (int) v2.y);
    }
}
