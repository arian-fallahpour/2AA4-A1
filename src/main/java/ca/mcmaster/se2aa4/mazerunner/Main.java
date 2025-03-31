package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Algorithm.Algorithm;
import ca.mcmaster.se2aa4.mazerunner.Algorithm.RightHandAlgorithm;
import ca.mcmaster.se2aa4.mazerunner.Algorithm.SimpleAlgorithm;

/*
 * Singleton for maze (done) 
 * Adapter for command line arguments (done)
 */

public class Main {
    public static void main(String[] args) {
        try {
            Arguments arguments = new Arguments(args);
            String filePath = arguments.getFilePath();
            String providedInstructions = arguments.getProvidedInstructions();
            String solvingMethod = arguments.getSolvingMethod();

            Maze maze = Maze.getInstance();
            maze.load(filePath);

            // If path was provided, check if it valid
            if (providedInstructions != null) {
                Path path = new Path(providedInstructions);
                Boolean isPathValid = path.verify(maze);
                
                if (isPathValid) {
                    System.out.println("correct path");
                } else {
                    System.out.println("incorrect path");
                }

                return;
            }
            
            // Could use the Factory Pattern to attach the specific algorithm here 

            // Otherwise, find the path using the maze
            Algorithm algorithm;
            if (solvingMethod.equals("simple")) {
                algorithm = new SimpleAlgorithm(maze.getStartPosition(), maze.getStartDirection());
            } else {
                algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
            }
            
            algorithm.solveMaze(maze);
            Path path = algorithm.getPath();
 
            System.out.println(path.getFactoredForm());
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
