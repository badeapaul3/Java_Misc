package devguideocp.Part2_C16to21.A16_2_StreamsIntermediate;

/**
 * @author hatzp
 **/

import devguideocp.Part2_C16to21.A16_1_Streams.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;
public class FlatMapTest {
    public static void main(String[] args) {


        List<CD> cdList2 = new ArrayList<>();cdList2.add(CD.cd0);cdList2.add(CD.cd1);
        List<CD> cdList1 = new ArrayList<>();cdList1.add(CD.cd0);cdList1.add(CD.cd1);cdList1.add(CD.cd1);

        //ATTEMPT 1 failing
        List<List<CD>> listOfListOfCDs = Stream.of(cdList1, cdList2).distinct().toList();
        System.out.println(listOfListOfCDs);

        //ATTEMPT 2 failing

        List<Stream<CD>> listOfStreamOfCD = Stream.of(cdList1,cdList2).map(List::stream).distinct().toList();

        //SOLUTION

        List<CD> listOfCD = Stream.of(cdList1,cdList2).flatMap(List::stream).distinct().toList();
        System.out.println(listOfCD);


        //Other examples
        int[][] twoDimArray = { {2017, 2018}, {1948, 1949} };
        int[] intArray = Arrays
                .stream(twoDimArray)                     // (1) Stream<int[]>

                .flatMapToInt(row -> Arrays.stream(row)) // (2) mapper: int[] -> IntStream,
                // flattens Stream<IntStream> to IntStream.
                .toArray();                              // [2017, 2018, 1948, 1949]
        System.out.println(Arrays.toString(intArray));


        //MapMulti intermediate operations

        // One-to-one
        BiConsumer<CD, Consumer<String>> bcA = (cd, consumer) -> {              // (1)
            if (cd.genre() == Genre.POP) {                                        // (2)
                consumer.accept(String.format("%-15s: %s", cd.title(),              // (3)
                        "*".repeat(cd.noOfTracks())));
            }
        };

        CD.cdList.stream()                                                      // (4)
                .mapMulti(bcA)                                                // (5)
                .forEach(System.out::println);


        // One-to-many
        BiConsumer<List<CD>, Consumer<String>> bcB = (lst, consumer) -> {       // (1)
            for (CD cd : lst) {
                consumer.accept(cd.title());
            }
        };
        List<String> listOfCDTitles = Stream.of(cdList1, cdList2) // (2) Stream<List<CD>>
                .mapMulti(bcB)                                        // (3)
                .distinct()
                .toList();
        System.out.println(listOfCDTitles);                       // [Java Jive, Java Jam]


        //BiConsumer implemented in the mapMulti method call
        List<String> listOfCDTitles2 = Stream.of(cdList1,cdList2) // (1) Stream<List<CD>>
            //  .mapMulti((lst, consumer) -> {                    // (2a) Compile-time error!
            //  .<String>mapMulti((lst, consumer) -> {                     // (2b) OK.
                .mapMulti((List<CD> lst, Consumer<String> consumer) -> {   // (2c) OK.
                    for (CD cd : lst) {
                        consumer.accept(cd.title());
                    }
                })
                .distinct()
                .toList();
        System.out.println(listOfCDTitles2);                  // [Java Jive, Java Jam]


    }
}
