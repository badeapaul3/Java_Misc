package devguideocp.Part2_C16to20.A16_4_TerminalOperations;

/**
 * @author hatzp
 **/

import devguideocp.Part2_C16to20.A16_1_Streams.*;

import java.time.Year;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class TestTerminal {
    public static void main(String[] args) {

        //forEach & forEachOrdered create side effects
        Consumer<String> printStr = str -> System.out.print(str + "|");

        CD.cdList.stream().map(CD::title).forEach(printStr);               // (1a)
//Java Jive|Java Jam|Lambda Dancing|Keep on Erasing|Hot Generics|


        CD.cdList.stream().parallel().map(CD::title).forEach(printStr);    // (1b)
//Lambda Dancing|Hot Generics|Keep on Erasing|Java Jam|Java Jive|



        CD.cdList.stream().map(CD::title).forEachOrdered(printStr);              // (2a)
//Java Jive|Java Jam|Lambda Dancing|Keep on Erasing|Hot Generics|

        CD.cdList.stream().parallel().map(CD::title).forEachOrdered(printStr);   // (2b)
//Java Jive|Java Jam|Lambda Dancing|Keep on Erasing|Hot Generics|


        IntConsumer printInt = n -> System.out.print(n + "|");

        IntStream.of(2018, 2019, 2020, 2021, 2022).forEach(printInt);            // (3a)
//2018|2019|2020|2021|2022|

        IntStream.of(2018, 2019, 2020, 2021, 2022).parallel().forEach(printInt); // (3b)
//2020|2019|2018|2021|2022|


        //Find operations - matching
        boolean anyJazzCD = CD.cdList.stream().anyMatch(CD::isJazz);   // (1) true
        boolean allJazzCds = CD.cdList.stream().allMatch(CD::isJazz);  // (2) false
        boolean noJazzCds = CD.cdList.stream().noneMatch(CD::isJazz);  // (3) false

        Predicate<CD> eq2015 = cd -> cd.year().compareTo(Year.of(2015)) == 0;
        Predicate<CD> gt2015 = cd -> cd.year().compareTo(Year.of(2015)) > 0;

        boolean noneEQ2015 = CD.cdList.stream().noneMatch(eq2015);     // (4) true
        boolean allGT2015 = CD.cdList.stream().allMatch(gt2015);       // (5) true
        boolean noneNotGT2015 = CD.cdList.stream().noneMatch(gt2015.negate()); // (6) true

        IntStream yrStream = IntStream.of(2018, 2019, 2020);
        IntPredicate isLeapYear = yr -> Year.of(yr).isLeap();
        boolean anyLeapYear = yrStream.anyMatch(isLeapYear);
        System.out.println("Any leap year: " + anyLeapYear);   // true



        //Find operations
        Optional<CD> firstCD1 = CD.cdList.stream().findFirst();         // (1)
        System.out.println(firstCD1.map(CD::title).orElse("No first CD."));    // (2) Java Jive

        Optional<CD> anyCD2 = CD.cdList.stream().parallel().findAny();  // (3)
        System.out.println(anyCD2.map(CD::title).orElse("No CD."));            // Lambda Dancing


        boolean anyJazzCD2 = CD.cdList.stream().anyMatch(CD::isJazz);              // (5)
        System.out.println("Any Jazz CD: " + anyJazzCD2);   // Any Jazz CD: true

        Optional<CD> optJazzCD = CD.cdList.stream().filter(CD::isJazz).findAny(); // (6)
        optJazzCD.ifPresent(System.out::println);          // <Jaav, "Java Jam", 6, 2017, JAZZ>

        IntStream numStream = IntStream.of(50, 55, 65, 70, 75, 77);
        OptionalInt intOpt = numStream.filter(n -> n % 7 == 0).findAny();
        intOpt.ifPresent(System.out::println);      // 70


        //Stream.generate(() -> 1).filter(n -> n == 0).findAny();       // Never terminates.



        //COUNTING ELEMENTS - functional reduction

        long numOfCDS = CD.cdList.stream().count();                        // 5
        long numOfJazzCDs = CD.cdList.stream().filter(CD::isJazz).count(); // 3

        IntStream numStream2 = IntStream.rangeClosed(1, 100);
        long divBy7 = numStream2.filter(n -> n % 7 == 0).count();           // 14

        //Min and Max Elements using Comparator
        Optional<CD> minCD = CD.cdList.stream().min(Comparator.naturalOrder());
        minCD.ifPresent(System.out::println);      // <Funkies, "Lambda Dancing", 10, 2018, POP>
        System.out.println(minCD.map(CD::artist).orElse("No min CD."));    // Funkies

        Optional<CD> maxCD = CD.cdList.stream().max(Comparator.naturalOrder());
        maxCD.ifPresent(System.out::println);      // <Jaav, "Java Jive", 8, 2017, POP>
        System.out.println(maxCD.map(CD::artist).orElse("No max CD."));    // Jaav


        IntStream iStream = IntStream.rangeClosed(1, 100);
        OptionalInt maxNum = iStream.filter(n -> n % 7 == 0).max(); // 98
        int myMax=0;
        if (maxNum.isPresent()) myMax = maxNum.getAsInt();
        System.out.println(myMax);


        //FUNCTIONAL REDUCTION reduce() method

        //usual loop-based solution
        int sum = 0;                               // (1) Initialize the partial result.
        for (CD cd : CD.cdList) {                  // (2) Iterate over the list.
            int numOfTracks = cd.noOfTracks();       // (3) Get the current value.
            sum = sum + numOfTracks;                 // (4) Calculate new partial result.
        }

        OptionalInt optSumTracks0 = CD.cdList                       // (13)
                .stream()
                .mapToInt(CD::noOfTracks)
                .reduce(Integer::sum);                                  // (14)
        System.out.println("Total number of tracks: " + optSumTracks0.orElse(0));  // 42
        //could also just use:
        //reduce(0, (sum, noOfTracks) -> Integer.sum(sum, noOfTracks))
        //reduce(0, Integer::sum)               // Method reference
        //sum()                                 // Special functional reduction, p. 1001.




    }
}
