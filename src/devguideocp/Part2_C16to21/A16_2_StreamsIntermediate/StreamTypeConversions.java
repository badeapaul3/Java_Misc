package devguideocp.Part2_C16to21.A16_2_StreamsIntermediate;

/**
 * @author hatzp
 **/
import devguideocp.Part2_C16to21.A16_1_Streams.*;
import java.util.*;
import java.util.stream.*;

public class StreamTypeConversions {
    public static void main(String[] args) {

        int totalNumOfTracks = CD.cdList
                .stream()                                         // (1) Stream<CD>
                .mapToInt(CD::noOfTracks)                         // (2) IntStream
                .sum();                                           // 42


        List<CD> cdList1 = new ArrayList<>(List.of(CD.cd0, CD.cd1));
        List<CD> cdList2 = new ArrayList<>(List.of(CD.cd2, CD.cd3, CD.cd4, CD.cd4));

        Set<CD> cdSet1 = new LinkedHashSet<>(cdList1);
        Set<CD> cdSet2 = new LinkedHashSet<>(cdList2);

        System.out.println(cdSet1);

        //flatten multilevel obj stream to a numeric stream
        int totalNumOfTracks2 =
                Stream.of(cdSet1, cdSet2)                       // Stream<List<CD>>
                        .flatMapToInt(                              // (1)
                                lst -> lst.stream()                     // Stream<CD>
                                        .mapToInt(CD::noOfTracks))    // IntStream
                        // Stream<IntStream>,
                        //   flattened to IntStream.
                        .sum();                                     // 42
        System.out.println(totalNumOfTracks2);

        //Numeric stream to object stream
        IntStream.rangeClosed(1, 3)                          // (1) IntStream
                .mapToObj(n -> List.of(n, n*n))             // (2) Stream<List<Integer>>
                .forEach(p -> System.out.print(p + " "));   // [1, 1] [2, 4] [3, 9]

        IntStream.rangeClosed(1, 3)                          // (3) IntStream
                .boxed()                                    // (4) Stream<Integer>
                .map(n -> List.of(n, n*n))                  // (5) Stream<List<Integer>>
                .forEach(p -> System.out.print(p + " "));   // [1, 1] [2, 4] [3, 9]

        //The examples above show that the IntStream.mapToObj() method is equivalent to the IntStream.boxed() method followed by the Stream.map() method.


        List<String> subListTitles = IntStream
                .rangeClosed(2, 3)                        // IntStream
                .mapToObj(i -> CD.cdList.get(i).title())  // Stream<String>
                .toList();                                // [Lambda Dancing, Keep on Erasing]

        //Mapping between Numeric Streams

        IntStream.rangeClosed(1, 3)                           // IntStream
                .map(i -> i * i)                             // IntStream
                .forEach(n -> System.out.printf("%d ", n));  // 1 4 9

        IntStream.rangeClosed(1, 3)                           // IntStream
                .flatMap(i -> IntStream.rangeClosed(1, 4))   // IntStream
                .forEach(n -> System.out.printf("%d ", n));  // 1 2 3 4 1 2 3 4 1 2 3 4

        //Map to another numeric type
        IntStream.rangeClosed(1, 3)                           // IntStream
                .mapToDouble(i -> Math.sqrt(i))              // DoubleStream
                .forEach(d -> System.out.printf("%.2f ", d));// 1.00 1.41 1.73


        IntStream.rangeClosed(1, 3)                           // IntStream
                .asDoubleStream()                            // DoubleStream
                .map(d -> Math.sqrt(d))                      // DoubleStream
                .forEach(d -> System.out.printf("%.2f ", d));// 1.00 1.41 1.73


        IntStream.rangeClosed(1, 3)                           // IntStream
                .boxed()                                     // Stream<Integer>
                .map(n -> Math.sqrt(n))                      // Stream<Double>
                .forEach(d -> System.out.printf("%.2f ", d));// 1.00 1.41 1.73


    }
}
