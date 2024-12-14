package devguideocp.Part2_C16to20.A16_1_Streams;

import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * @author hatzp
 **/
public class StreamTest {
    public static void main(String[] args) {
        // Loop-based solution:
        List<String> values = List.of("2001", "1999", "2021");
        for (String s : values) {
            Year y = Year.parse(s);
            if (y.isAfter(Year.of(2000))) {
                System.out.print(s + " ");                      // 2001 2021
            }
        }

// Stream-based solution:
        List<String> values2 = List.of("2001", "1999", "2021");
        values2.stream()                                    // (1)
                .map(s -> Year.parse(s))                     // (2)
                .filter(y -> y.isAfter(Year.of(2000)))       // (3)
                .forEach(y -> System.out.print(y + " "));    // (4) 2001 2021


        System.out.println("@@@@");
        String[] myStringArray = new String[]{"test1", "test2"};
        List<String> myList = List.of("test1","test2");
        List<String> myList2 = List.of(myStringArray);

        for(String s : myList) System.out.println(s);
        myList2.stream()
                .forEach(System.out::println);



        //START OF VARIOUS TESTS AND EXAMPLES

        Stream<CD> cdStream = Stream.empty();                   // Empty stream of CD.
        System.out.println("Count: " + cdStream.count());       // Count: 0

        IntStream iStream = IntStream.empty();                  // Empty stream of int.
        System.out.println("Count: " + iStream.count());        // Count: 0

        // From specified objects.
        Stream<CD> cdStream1 = Stream.of(CD.cd0);                  // (1) Single-arg call.
        Stream<CD> cdStream2 = Stream.of(CD.cd0, CD.cd1, CD.cd2);  // (2) Varargs call.
        cdStream2.filter(CD::isPop)                                // (3)
                .forEach(cd -> System.out.println(cd.title()));   // (4)



        // From specified numeric values.
        Stream<Integer> integerStream1 = Stream.of(2017, 2018, 2019);        // (1)
        Stream<? extends Number> numStream = Stream.of(100, 3.14D, 5050L);   // (2)
        numStream.forEach(number -> System.out.print(number+", "));
        IntStream intStream1 = IntStream.of(2017, 2018, 2019);               // (3)
        DoubleStream doubleStream = DoubleStream.of(100, 3.14D, 5050L);      // (4)

        // From an array of CDs.
        Stream<CD> cdStream3 = Stream.of(CD.cdArray);                 // (1)
        Stream<CD> cdStream4 = Arrays.stream(CD.cdArray);             // (2)

        // From an array of Integer.
        Integer[] integerArray = {2017, 2018, 2019};                  // (3)
        Stream<Integer> integerStream2 = Stream.of(integerArray);     // (4)
        Stream<Integer> integerStream3 = Arrays.stream(integerArray); // (5)

        // From an array of int.
        int[] intArray = {2017, 2018, 2019};                          // (6)
        Stream<int[]> intArrayStream = Stream.of(intArray);           // (7) Size is 1.
        IntStream intStream2 = IntStream.of(intArray);                // (8) Size is 3.
        IntStream intStream3 = Arrays.stream(intArray);               // (9) Size is 3.

        System.out.println();
        IntSupplier supplier = () -> (int) (6.0 * Math.random()) + 1;  // (1)
        IntStream diceStream = IntStream.generate(supplier);           // (2)
        diceStream.limit(8)                                            // (3)
                .forEach(i -> System.out.print(i + " "));            // (4) 2 4 5 2 6

        System.out.println();
        IntUnaryOperator uop = n -> n + 2;                // (1)
        IntStream oddNums = IntStream.iterate(1, uop);    // (2)
        oddNums.limit(5)
                .forEach(i -> System.out.print(i + " "));  // 1 3 5 7 9

        System.out.println();
        Stream.iterate("ba", b -> b + "na")
                .limit(5)
                .forEach(System.out::println);

        System.out.println();
        Set<String> strSet1                                                         // (1)
                = Set.of("All", " objects", " are", " equal");
        Set<String> strSet2                                                         // (2)
                = Set.of(" but", " some", " are", " more", " equal", " than", " others.");
        Stream<String> unorderedStream1 = strSet1.stream();                         // (3)
        Stream<String> unorderedStream2 = strSet2.stream();                         // (4)
        Stream.concat(unorderedStream1, unorderedStream2)                           // (5)
                .forEachOrdered(System.out::print);                                      // (6)
        // objectsAll equal are some are others. than equal more but

        Stream<String> orderedStream1 = Stream.of("All", " objects",                // (1)
                " are", " equal");
        Stream<String> orderedStream2 = Stream.of(" but", " some", " are", " more", // (2)
                " equal", " than", " others.");
        Stream.concat(orderedStream1, orderedStream2)                               // (3)
                .forEachOrdered(System.out::print);                                   // (4)
        // All objects are equal but some are more equal than others.


        Stream<String> pStream1 = strSet1.stream().parallel();                // (1)
        System.out.println("pStream1 is parallel: " + pStream1.isParallel()); // (2) true
        Stream<String> rStream = Stream.concat(pStream1, strSet2.stream());   // (3)
        System.out.println("rStream is parallel: " + pStream1.isParallel());  // (4) true
        rStream.forEachOrdered(System.out::print);                            // (5)
// objectsAll equal are some are others. than equal more but
    }

}
