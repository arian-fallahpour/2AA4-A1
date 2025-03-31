package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class Arguments {
    private Options options = new Options();
    private CommandLineParser parser = new DefaultParser();
    private CommandLine cmd;

    private String filePath = "./examples/straight.maz.txt";
    private String providedInstructions = null;
    private String solvingMethod = "righthand";

    public Arguments(String[] args) {
        this.addOptions();
        this.parseOptions(args);
        this.setArguments();
    }

    private void addOptions() {
        this.options.addOption("i", true, "Sets the maze to the filename provided.");
        this.options.addOption("p", true, "Allows you to verify if a path is valid.");
        this.options.addOption("method", true, "Allows you to choose the maze solving algorithm to use.");
    }

    private void parseOptions(String[] args) {
        try {
            this.cmd = this.parser.parse(this.options, args);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void setArguments() {
        this.setFilePath();
        this.setProvidedInstructions();
        this.setSolvingMethod();
    }

    private void setFilePath() {
        if (this.cmd.hasOption("i")) {
            this.filePath = this.cmd.getOptionValue("i");
        }
    }

    private void setProvidedInstructions() {
        if (this.cmd.hasOption("p")) {
            this.providedInstructions = this.cmd.getOptionValue("p");
        }
    }

    private void setSolvingMethod() {
        if (this.cmd.hasOption("method")) {
            this.solvingMethod = this.cmd.getOptionValue("method");
        }
    }

    public String getFilePath() { return this.filePath; }
    public String getProvidedInstructions() { return this.providedInstructions; }
    public String getSolvingMethod() { return this.solvingMethod; }
}
