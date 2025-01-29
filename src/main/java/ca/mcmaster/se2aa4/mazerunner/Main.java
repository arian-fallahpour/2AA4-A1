package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption("i", null, true, "Maze file name.");
        options.addOption("p", null, true, "");

        try {
            CommandLine cmd = parser.parse(options, args);
            
            // Check if user provided the maze file
            String filePath = "./examples/";
            if (cmd.hasOption("i")) {
                filePath += cmd.getOptionValue("i");
            } else {
                filePath += "straight.maz.txt";
            }

            // Check if user wants to verify their provided path
            String providedInstructions = null;
            if (cmd.hasOption("p")) {
                providedInstructions = cmd.getOptionValue("p");
            }

            // Initialize maze
            Maze maze = new Maze(filePath);
            
            // If path was provided, check if it valid
            if (providedInstructions != null) {
                Path path = new Path(providedInstructions);
                Boolean isPathValid = path.verify(maze);
                String instructions = path.getInstructions();
                
                if (isPathValid) {
                    System.out.println(instructions + " solves the maze.");
                } else {
                    System.out.println(instructions + " does not solve the maze.");
                }
            }
            
            // Otherwise, find the path using the maze
            else {
                Algorithm algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
                Path path = algorithm.getPath();

                algorithm.solveMaze(maze);
                
                System.out.println(path.getCanonicalInstructions());
                System.out.println(path.getFactoredInstructions());
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
