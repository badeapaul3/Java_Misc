package devguideocp.Part2_C11to15.A15_2_Maps;

/**
 * @author hatzp
 **/


import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import static java.lang.System.out;

public class HistogramStats {
    public static void main(String[] args) {

        // Create a navigable map to store the frequency for each group.
        NavigableMap<Integer, Integer> groupFreqMap = new TreeMap<>();         // (1)

        // Determine the frequencies:
        for (String argument : args) {                                         // (2)
            double weight = Double.parseDouble(argument);
            int weightGroup = (int) Math.round(weight/5.0)*5;
            groupFreqMap.merge(weightGroup, 1, Integer::sum);
        }

        // Print statistics about the frequency map:
        out.print("Group frequency map: ");
        printHistogram(groupFreqMap);                                          // (3)

        out.println("First entry: " + groupFreqMap.firstEntry());              // (4)
        out.println("Last entry: " + groupFreqMap.lastEntry());                // (5)
        out.println("Greatest entry <= 77: "
                + groupFreqMap.floorEntry(77));                            // (6)
        out.println("Smallest key > 90: "
                + groupFreqMap.higherKey(90));                             // (7)

        out.print("Tail map (Groups >= 75): ");
        printHistogram(groupFreqMap.tailMap(75, true));                        // (8)

        out.print("Head map (Groups <  75): ");
        printHistogram(groupFreqMap.headMap(75, false));                       // (9)

        out.print("Frequency map (first and last entry excluded): ");
        printHistogram(groupFreqMap.subMap(                                    // (10)
                groupFreqMap.firstEntry().getKey(), false,
                groupFreqMap.lastEntry().getKey(), false));

        // Poll the navigable map:                                                (11)
        out.println("Histogram (by polling):");
        int sumValues = 0;
        while (!groupFreqMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = groupFreqMap.pollFirstEntry();   // (12)
            Integer frequency = entry.getValue();
            sumValues += frequency;
            out.printf("%5s: %s%n", entry.getKey(), frequency);
        }
        out.println("Number of weights registered: " + sumValues);             // (13)
        out.println("Group frequency map after polling: " + groupFreqMap);     // (14)
    }

    // Prints a histogram for entries in a navigable map.
    public static <K> void printHistogram(NavigableMap<K, Integer> freqMap) {// (15)
        out.println(freqMap);                                                  // (16)
        out.println("No. of entries: " + freqMap.size());                      // (17)
        freqMap.forEach((k, v) ->                                              // (18)
                out.printf("%5s: %s%n", k,
                        String.join("", Collections.nCopies(v, "*"))));
    }
}
//out for args 74 75 93 75 93 82 61 92 10 185
//Group frequency map: {10=1, 60=1, 75=3, 80=1, 90=1, 95=2, 185=1}
//No. of entries: 7
//   10: *
//   60: *
//   75: ***
//   80: *
//   90: *
//   95: **
//  185: *
//First entry: 10=1
//Last entry: 185=1
//Greatest entry <= 77: 75=3
//Smallest key > 90: 95
//Tail map (Groups >= 75): {75=3, 80=1, 90=1, 95=2, 185=1}
//No. of entries: 5
//   75: ***
//   80: *
//   90: *
//   95: **
//  185: *
//Head map (Groups <  75): {10=1, 60=1}
//No. of entries: 2
//   10: *
//   60: *
//Frequency map (first and last entry excluded): {60=1, 75=3, 80=1, 90=1, 95=2}
//No. of entries: 5
//   60: *
//   75: ***
//   80: *
//   90: *
//   95: **
//Histogram (by polling):
//   10: 1
//
//   60: 1
//   75: 3
//   80: 1
//   90: 1
//   95: 2
//  185: 1
//Number of weights registered: 10
//Group frequency map after polling: {}