package classes;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    @Test
    public void testFirstQuest() throws IOException {
        String filePath = "src/test/java/resources/TestFileOne.txt";

        List<Double> sortedList =  Files.lines(Paths.get(filePath))
                .map(Double::valueOf)
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(java.util.Optional.of(5.0).get(), java.util.Optional.of(StatsCollector.findPercentile(sortedList)).get());

        Assert.assertEquals(java.util.Optional.of(1.0).get(), java.util.Optional.of(StatsCollector.findMedian(sortedList)).get());

        DoubleSummaryStatistics summary = sortedList.stream().mapToDouble(x -> x).summaryStatistics();
        Assert.assertEquals(java.util.Optional.of(1.93).get(), java.util.Optional.of(StatsCollector.roundToHunderd(summary.getAverage())).get());
        Assert.assertEquals(java.util.Optional.of(6).get(), java.util.Optional.of((int) summary.getMax()).get());
        Assert.assertEquals(java.util.Optional.of(1).get(), java.util.Optional.of((int) summary.getMin()).get());

        filePath = "src/test/java/resources/TestFileTwo.txt";

        sortedList =  Files.lines(Paths.get(filePath))
                .map(Double::valueOf)
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(java.util.Optional.of(9.0).get(), java.util.Optional.of(StatsCollector.findPercentile(sortedList)).get());

        Assert.assertEquals(java.util.Optional.of(5.5).get(), java.util.Optional.of(StatsCollector.findMedian(sortedList)).get());

        summary = sortedList.stream().mapToDouble(x -> x).summaryStatistics();
        Assert.assertEquals(java.util.Optional.of(5.5).get(), java.util.Optional.of(StatsCollector.roundToHunderd(summary.getAverage())).get());
        Assert.assertEquals(java.util.Optional.of(10).get(), java.util.Optional.of((int) summary.getMax()).get());
        Assert.assertEquals(java.util.Optional.of(1).get(), java.util.Optional.of((int) summary.getMin()).get());
    }
}
