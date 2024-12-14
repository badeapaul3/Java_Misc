package devguideocp.Part2_C16to20.A16_1_Streams;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import static devguideocp.Part2_C16to20.A16_1_Streams.CD.cdArray;

/**
 * @author hatzp
 **/
public class StreamTest2 {
    public static void main(String[] args) {

        List<CD> listOfCDS = new ArrayList<>(List.of(CD.cd0, CD.cd1));       // (1)
        Stream<CD> cdStream = listOfCDS.stream();                            // (2)
        listOfCDS.add(CD.cd2);                                               // (3)
        System.out.println(cdStream.count());                                // (4) 3
// System.out.println(cdStream.count());             // (5) IllegalStateException

        Map<Integer, String> dataMap = new HashMap<>();                     // (1)
        dataMap.put(1, "en"); dataMap.put(2, "to");
        dataMap.put(3, "tre"); dataMap.put(4, "fire");
        long numOfEntries = dataMap
                .entrySet()                                                     // (2)

                .stream()                                                       // (3)
                .count();                                                       // (4) 4


        Stream<CD> cdStream2 = Arrays.stream(cdArray, 1, 4);          // (1)
        long noOfElements = cdStream2.count();                        // (2) 3

        IntStream.range(0, CD.cdArray.length)                                   // (1)
                .forEach(i -> System.out.println(cdArray[CD.cdArray.length - 1 - i]));

        int divisor = 5;
        int start = 2000, end = 3500;
        long divisibles = IntStream
                .rangeClosed(start, end)                                            // (1)
                .filter(number -> number % divisor == 0)                            // (2)
                .count();                                                           // (3)
        System.out.println(divisibles);                                         // 201


        int first = 10, len = 8;
        int[] intArray = IntStream.range(first, first + len).toArray();         // (1)
        System.out.println(intArray.length + ": " + Arrays.toString(intArray));
        //8: [10, 11, 12, 13, 14, 15, 16, 17]

        {
            IntStream.rangeClosed(1, 10)                                 // Outer range.
                    .forEach(i -> IntStream.rangeClosed(1, 10)          // Inner range.
                            .forEach(j -> System.out.printf("%2d * %2d = %2d%n",
                                    i, j, i * j)));
        }


        Random rng = new Random();                        // (1)

        IntStream iStream = rng.ints();                   // (2) Unlimited, any int value
        int[] intArray3 = iStream.limit(3).toArray();      // Limits size to 3
        //[-1170441471, 1070948914, 264046613]
        intArray3 = rng.ints(3).toArray();                 // (3) Size 3, any int value
        //[1011448344, -974832344, 816809715]
        intArray3 = rng.ints(1, 7)                         // (4) Unlimited, [1, 6]
                .limit(3)                           // Limits size to 3
                .toArray();                         // [5, 2, 4]

        intArray3 = rng.ints(3, 1, 7)                      // (5) Size 3, [1, 6]
                .toArray();                         // [1, 4, 6]


        DoubleStream dStream = rng.doubles(3);            // (6) Size 3, [0.0, 1.0)
        double[] dArray = dStream.toArray();
        //[0.9333794789872794, 0.7037326827186609, 0.2839257522887708]

        String strSource = "banananana";
        IntStream iStream2 = strSource.chars();                   // (1)
        iStream2.forEach(i -> System.out.print(i + " "));         // Prints ints.
// 98 97 110 97 110 97 110 97 110 97

        strSource.chars()
                .mapToObj(i -> (char)i)                         // (2) Stream<Character>
                .forEach(System.out::print);                    // Prints chars.
// banananana

        System.out.println();

        String inputLines = "Wise men learn from their mistakes.\n"                 // (1)
                + "But wiser men learn from the mistakes of others.\n"
                + "And fools just carry on.";
        Stream<String> lStream = inputLines.lines();                                // (2)
        lStream.filter(l -> l.contains("mistakes")).forEach(System.out::println);   // (3)


        try (FileReader fReader = new FileReader("CD_Data.txt");         // (1)
             BufferedReader bReader = new BufferedReader(fReader);       // (2)
             Stream<String> lStream3 = bReader.lines() ) {                // (3)
            System.out.println("Number of lines: " + lStream3.count());      // (4) 13
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get("CD_Data.txt");                             // (1)
        try (Stream<String> lStream4 = Files.lines(path)) {                // (2)
            System.out.println("Number of lines: " + lStream4.count());      // (3) 13
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
