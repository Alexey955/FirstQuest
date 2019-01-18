package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StatsCollector {

    private String filePath;

    public StatsCollector(String filePath) throws IOException {
        this.filePath = filePath;
    }

    public void showStats() throws IOException {
        List<Double> sortedList =  Files.lines(Paths.get(filePath))
                .map(Double::valueOf)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("90 percentile " + findPercentile(sortedList));

        System.out.println("median " + findMedian(sortedList));

        DoubleSummaryStatistics summary = sortedList.stream().mapToDouble(x -> x).summaryStatistics();
        System.out.println("average " + roundToHunderd(summary.getAverage()));
        System.out.println("max " + (int)summary.getMax());
        System.out.println("min " + (int)summary.getMin());
    }

    public static double findMedian(List<Double> sortedList){
        int middle = sortedList.size() / 2;

        return (sortedList.size() % 2) == 0 ? (sortedList.get(middle) + sortedList.get(middle - 1)) / 2 : sortedList.get(middle);
    }

    public static double findPercentile(List<Double> sortedList){
        int size = sortedList.size();
        double index = size * 0.9;

        return index == (int)index ? sortedList.get((int) (index - 1)) : sortedList.get((int) index);
    }

    public static double roundToHunderd(double d) {
        double result = d * 100;
        result = (int) result;

        return result / 100;
    }
}


