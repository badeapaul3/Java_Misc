package devguideocp.Part2_C11to15.A15_2_Maps;

/**
 * @author hatzp
 **/
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Histogram {
    public static void main(String[] args) {
        System.out.println("Data: " + Arrays.toString(args));

        // Create a map to store the frequency for each group.
        Map<Integer, Integer> groupFreqMap = new HashMap<>();                  // (1)

        // Determine the frequencies:
        for (String argument : args) {                                         // (2)
            double weight = Double.parseDouble(argument);                        // (3)
            int weightGroup = (int) Math.round(weight/5.0)*5;                    // (4)
            groupFreqMap.merge(weightGroup, 1, Integer::sum);                    // (5)
            //other options
            //groupFreqMap.merge(weightGroup, 1,
            //   (oldVal, givenVal) -> Integer.sum(oldVal, givenVal));

            //Integer frequency = groupFreqMap.get(weightGroup);
            //if (frequency == null) frequency = 0;
            //groupFreqMap.put(weightGroup, ++frequency);

            //Integer frequency = groupFreqMap.getOrDefault(weightGroup, 0);
            //groupFreqMap.put(weightGroup, ++frequency);

            //groupFreqMap.putIfAbsent(weightGroup, 0);
            //Integer frequency = groupFreqMap.get(weightGroup);
            //groupFreqMap.put(weightGroup, ++frequency);

            //groupFreqMap.compute(weightGroup, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println("Frequencies: " + groupFreqMap);

        // Create sorted key set.
        TreeSet<Integer> sortedKeySet = new TreeSet<>(groupFreqMap.keySet());  // (6)

        System.out.println("Histogram:");
        // Implicit iteration over the key set.
        sortedKeySet.forEach(key ->                                            // (7)
                System.out.printf("%5s: %s%n", key,
                        String.join("", Collections.nCopies(groupFreqMap.get(key), "*")))
        );
    }
}
