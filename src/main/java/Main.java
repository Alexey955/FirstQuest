import classes.StatsCollector;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String filePath = "src/main/resources/FileInput.txt";

        StatsCollector statsCollector = new StatsCollector(filePath);
        statsCollector.showStats();
    }
}