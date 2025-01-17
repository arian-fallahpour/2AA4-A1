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
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", null, true, "Path to maze file.");
        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            
            String filePath = "./examples/small.maz.txt";
            if (cmd.hasOption("i")) {
                filePath = cmd.getOptionValue("i");
            }

            System.out.println("**** Reading the maze from file " + filePath);
            logger.info("**** Computing path");

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
            reader.close();
        } catch(Exception e) {
            logger.error("PATH NOT COMPUTED");
            System.err.println("/!\\ An error has occured /!\\");
        }
        System.out.println("** End of MazeRunner");
    }
}
