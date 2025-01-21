package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private static final Logger logger = LogManager.getLogger();
    private Player player;
    private Maze maze;

    public Game(Player player, Maze maze) {
        this.player = player;
        this.maze = maze;
    }

    public void startGame() {
        this.player.traverseMaze(this.maze);
    }

    public void displayGameStart() {
        System.out.println("<< Game started >>");
        System.out.print(System.lineSeparator());
    }
    
    public void displayGameEnd() {
        System.out.println("<< Game ended >>");
        System.out.print(System.lineSeparator());
    }

}
