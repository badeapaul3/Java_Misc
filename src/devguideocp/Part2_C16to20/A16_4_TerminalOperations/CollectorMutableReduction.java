package devguideocp.Part2_C16to20.A16_4_TerminalOperations;
import static java.lang.System.out;
import devguideocp.Part2_C16to20.A16_1_Streams.*;
import java.util.Comparator;
import java.util.Optional;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;

/**
 * @author hatzp
 **/


public class CollectorMutableReduction {
    public static void main(String[] args) {

        List<String> titles = CD.cdList.stream()
                .map(CD::title).collect(Collectors.toList());
// [Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]


// Query: Create a list with the number of tracks on each CD.
        System.out.println("Sequential Mutable Reduction:");
        List<Integer> tracks = CD.cdList                          // (1)
                .stream()                                             // (2a)
//      .parallelStream()                                     // (2b)
                .map(CD::noOfTracks)                                  // (3)
                .collect(() -> new ArrayList<>(),                     // (4) Supplier
                        (cont, noOfTracks) -> cont.add(noOfTracks),  // (5) Accumulator
                        (cont1, cont2) -> cont1.addAll(cont2));      // (6) Combiner
//      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // (6a)
//      .toList();
        System.out.println("Number of tracks on each CD (sequential): " + tracks);
        System.out.println();

        System.out.println("Parallel Mutable Reduction:");
        List<Integer> tracks1 = CD.cdList                         // (7)
//      .stream()                                             // (8a)
                .parallelStream()                                     // (8b)
                .map(CD::noOfTracks)                                  // (9)
                .collect(                                             // (10)
                        () -> {                                           // (11) Supplier
                            System.out.println("Supplier: Creating an ArrayList");
                            return new ArrayList<>();
                        },
                        (cont, noOfTracks) -> {                           // (12) Accumulator
                            System.out.printf("Accumulator: cont:%s, noOfTracks:%s",
                                    cont, noOfTracks);
                            cont.add(noOfTracks);
                            System.out.printf(", mutCont:%s%n", cont);
                        },
                        (cont1, cont2) -> {                               // (13) Combiner
                            System.out.printf("Combiner: con1:%s, cont2:%s", cont1, cont2);
                            cont1.addAll(cont2);
                            System.out.printf(", mutCont:%s%n", cont1);
                        });
        System.out.println("Number of tracks on each CD (parallel): " + tracks1);
        System.out.println();

        // Query: Create an ordered set with CD titles, according to natural order.
        Set<String> cdTitles = CD.cdList                          // (14)
                .stream()
                .map(CD::title)
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);// (15)
        System.out.println("CD titles: " + cdTitles);
        System.out.println();

        // Query: Go bananas.
        StringBuilder goneBananas = Stream                        // (16)
                .iterate("ba", b -> b + "na")                         // (17)
                .limit(5)
                .peek(System.out::println)
                .collect(StringBuilder::new,                          // (18)
                        StringBuilder::append,
                        StringBuilder::append);
        System.out.println("Go bananas: " + goneBananas);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // COLLECTING TO AN ARRAY


        Object[] objArray = CD.cdList.stream().map(CD::title)
                .toArray();                     // (1)
        //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]

        String[] cdTitles3 = CD.cdList.stream().map(CD::title)
                .toArray(String[]::new);         // (2)
        //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]

        int[] intArray1 = IntStream.iterate(1, i -> i + 1).limit(5).toArray();// (3)
        // [1, 2, 3, 4, 5]
        int[] intArray2 = IntStream.range(-5, 5).toArray();                   // (4)
        // [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4]

        //int[] intArray3 = IntStream.iterate(1, i -> i + 1)                    // (5)
        //                           .toArray();                        // OutOfMemoryError! (infinite stream)

        CD[] cdArray1 = CD.cdList.stream().toArray(CD[]::new);       // (6) Preferred.
        CD[] cdArray2 = CD.cdList.toArray(new CD[CD.cdList.size()]); // (7) Not efficient.


        //toList collecting - different than the Collectors class toList

        List<String> titles2 = CD.cdList.stream().map(CD::title).toList();
        // [Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
        //        titles2.add("Java Jingles");          // UnsupportedOperationException!

        //Summation
        int totNumOfTracks = CD.cdList
                .stream()                                     // Stream<CD>
                .mapToInt(CD::noOfTracks)                     // IntStream
                .sum();                                       // 42

        int sumEven = IntStream
                .rangeClosed(1, 100)
                .filter(i -> i % 2 == 0)
                .sum();                                       // 2550

        int numOfCDs = CD.cdList
                .stream()
                .mapToInt(cd -> 1)                            // CD => 1
                .sum();                                       // 5

        //AVG
        OptionalDouble optAverage = CD.cdList
                .stream()
                .mapToInt(CD::noOfTracks)
                .average();
        System.out.println(optAverage.orElse(0.0));        // 8.4


        //statistics
        IntSummaryStatistics stats1 = List.of(CD.cd0, CD.cd1)
                .stream()
                .mapToInt(CD::noOfTracks)
                .summaryStatistics();
        System.out.println("Count="   + stats1.getCount());        // Count=2
        System.out.println("Sum="     + stats1.getSum());          // Sum=14
        System.out.println("Min="     + stats1.getMin());          // Min=6
        System.out.println("Max="     + stats1.getMax());          // Max=8
        System.out.println("Average=" + stats1.getAverage());      // Average=7.0

        out.println();
        out.println(stats1);

        stats1.accept(CD.cd2.noOfTracks());     // Add the value 10.
        System.out.println(stats1);
//IntSummaryStatistics{count=3, sum=24, min=6, average=8.000000, max=10}

        IntSummaryStatistics stats2 = List.of(CD.cd3, CD.cd4)
                .stream()
                .mapToInt(CD::noOfTracks)
                .summaryStatistics();
        System.out.println(stats2);
//IntSummaryStatistics{count=2, sum=18, min=8, average=9.000000, max=10}

        stats1.combine(stats2);                 // Combine stats2 with stats1.
        System.out.println(stats1);
//IntSummaryStatistics{count=5, sum=42, min=6, average=8.400000, max=10}

        IntSummaryStatistics emptyStats = IntStream.empty().summaryStatistics();
        System.out.println(emptyStats);
//IntSummaryStatistics{count=0, sum=0, min=2147483647, average=0.000000,
//max=-2147483648}









    }
}
