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
            Vector playerStartPosition = maze.getStartPosition();
            Vector playerStartDirection = new Vector(1, 0);
            Player player = new Player(playerStartPosition, playerStartDirection);

            // Create game
            Game game = new Game(player, maze);

            // If path was provided, check if it valid
            if (providedPath != null) {

            } 
            
            // Otherwise, find the path
            else {

                game.startGame();
            }

            player.displayInstructions();

        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
