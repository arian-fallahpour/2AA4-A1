package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
            String providedPath = null;
            if (cmd.hasOption("p")) {
                providedPath = cmd.getOptionValue("p");
            }

            // Create new maze and load it from file
            Maze maze = new Maze(filePath);
            maze.loadMaze();

            // Initialize player
            Player player = new Player(maze.getStartPosition(), maze.getStartDirection());

            // If path was provided, check if it valid
            if (providedPath != null) {
                Boolean isPathValid = maze.verifyPath(providedPath);

                if (isPathValid) {
                    System.out.println(providedPath + " solves the maze.");
                } else {
                    System.out.println(providedPath + " does not solve the maze.");
                }
            } 
            
            // Otherwise, find the path using the 
            else {
                player.traverseMaze(maze);
                player.displayInstructions();
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
