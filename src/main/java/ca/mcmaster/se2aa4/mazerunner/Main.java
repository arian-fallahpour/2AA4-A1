package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption("i", null, true, "Sets the maze to the filename provided.");
        options.addOption("p", null, true, "Allows you to verify if a path is valid.");
        options.addOption("method", null, true, "Allows you to choose the maze solving algorithm to use.");

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

            // Determine algorithm to use in order to solve maze
            String solvingMethod = "righthand";
            if (cmd.hasOption("method")) {
                solvingMethod = cmd.getOptionValue("method");
            }

            // Initialize maze
            Maze maze = new Maze(filePath);
            
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
            
            // Otherwise, find the path using the maze
            Algorithm algorithm;
            if (solvingMethod.equals("simple")) {
                algorithm = new SimpleAlgorithm(maze.getStartPosition(), maze.getStartDirection());
            } else {
                algorithm = new RightHandAlgorithm(maze.getStartPosition(), maze.getStartDirection());
            }
            
            algorithm.solveMaze(maze);
            Path path = algorithm.getPath();

            System.out.println(path.getFactoredInstructions());
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
