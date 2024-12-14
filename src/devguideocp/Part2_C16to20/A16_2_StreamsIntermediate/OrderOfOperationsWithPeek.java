package devguideocp.Part2_C16to20.A16_2_StreamsIntermediate;

/**
 * @author hatzp
 **/

import devguideocp.Part2_C16to20.A16_1_Streams.*;
import java.util.List;
import java.time.Year;
import java.util.stream.*;

public final class OrderOfOperationsWithPeek {
    public static void main(String[] args) {

        System.out.println("map() before skip():");
        List<String> cdTitles1 = CD.cdList
                .stream()
                .map(CD::title)
                .peek(t -> System.out.println("After map: " + t))
                .skip(3)
                .peek(t -> System.out.println("After skip: " + t))
                .toList();
        System.out.println(cdTitles1);
        System.out.println();

        System.out.println("skip() before map():");            // Preferable.
        List<String> cdTitles2 = CD.cdList
                .stream()
                .skip(3)
                .peek(cd -> System.out.println("After skip: " + cd))
                .map(CD::title)
                .peek(t -> System.out.println("After map: " + t))
                .toList();
        System.out.println(cdTitles2);

        //MAPPINGS - transforming streams
        Stream<String> titles = CD.cdList
                .stream()                   // Input stream: Stream<CD>.
                .map(CD::title);            // Lambda expression: cd -> cd.title()


        CD.cdList.stream()                                   // Stream<CD>
                .map(CD::year)                              // Stream<Year>
                .distinct()                                 // Stream<Year>
                .mapToInt(Year::getValue)                   // IntStream
                .forEach(System.out::println);              // 2017 2018

        int from = 0, to = 5;
        IntStream.range(from, to)                   // [0, 5)
                .map(i -> to + from - 1 - i)       // Reverse the stream values

                .forEach(System.out::print);       // 43210
        System.out.println();
        long sixes = IntStream
                .generate(() -> (int) (6.0 * Math.random()) + 1) // [1, 6]
                .limit(2000)                                     // Number of throws.
                .map(i -> i == 6 ? 1 : 0)             // Dice value mapped to 1 or 0.
                .sum();

        System.out.println(sixes);


    }
}
