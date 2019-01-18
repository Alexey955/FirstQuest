import classes.StatsCollector;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        StatsCollector statsCollector = new StatsCollector(args[0]);
        statsCollector.showStats();
    }
}