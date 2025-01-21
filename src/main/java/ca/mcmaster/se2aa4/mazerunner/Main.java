package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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

        options.addOption("i", null, true, "Path to maze file.");

        try {
            CommandLine cmd = parser.parse(options, args);
            
            String filePath = "./examples/straight.maz.txt";
            // if (cmd.hasOption("i")) {
            //     filePath = cmd.getOptionValue("i");
            // }

            // Create new maze and load it from file
            Maze maze = new Maze(filePath);
            maze.loadMaze();

            // Initialize player
            Vector playerStartPosition = maze.getStartPosition();
            Vector playerStartDirection = new Vector(1, 0);
            Player player = new Player(playerStartPosition, playerStartDirection);

            // Create and start game
            Game game = new Game(player, maze);
            game.startGame();

            player.displayInstructions();

        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
