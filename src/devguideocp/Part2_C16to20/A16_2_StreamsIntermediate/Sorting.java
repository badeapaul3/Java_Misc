package devguideocp.Part2_C16to20.A16_2_StreamsIntermediate;

/**
 * @author hatzp
 **/

import devguideocp.Part2_C16to20.A16_1_Streams.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

import java.util.Comparator;

public class Sorting {
    public static void main(String[] args) {

        System.out.println("(1) Positional order in the array:");

        CD[] cdArray = CD.cdArray;
        System.out.println(Arrays.toString(cdArray));              // (1)

        System.out.println("(2) Positional order in the stream:");
        List<CD> cdsByPositionalOrder =                            // (2)
                Arrays.stream(cdArray)
                        .toList();
        System.out.println(cdsByPositionalOrder);

        System.out.println("(3) Natural order:");
        List<CD> cdsByNaturalOrder =                               // (3)
                Arrays.stream(cdArray)
                        .sorted()
                        .toList();
        System.out.println(cdsByNaturalOrder);

        System.out.println("(4) Reversed natural order:");
        List<CD> cdsByRNO =                                        // (4)
                Arrays.stream(cdArray)
//          .sorted((c1, c2) -> -c1.compareTo(c2))
                        .sorted(Comparator.reverseOrder())
                        .toList();
        System.out.println(cdsByRNO);

        System.out.println("(5) Only Jazz CDs, ordered by title:");
        List<String> jazzCDsByTitle =                              // (5)
                Arrays.stream(cdArray)
                        .filter(CD::isJazz)
//          .sorted((c1, c2) -> c1.title().compareTo(c2.title()))
                        .sorted(Comparator.comparing(CD::title))
                        .map(CD::title)
                        .toList();
        System.out.println(jazzCDsByTitle);

        System.out.println("(6) No. of tracks >= 8, ordered by number of tracks:");
        List<CD> cds =                                             // (6)
                Arrays.stream(cdArray)
                        .filter(d -> d.noOfTracks() >= 8)
//          .sorted((c1, c2) -> c1.noOfTracks() - c2.noOfTracks())
                        .sorted(Comparator.comparing(CD::noOfTracks))
                        .toList();
        System.out.println(cds);

        //UNORDERED
        //Query: Create a list with the first 2 Jazz CD titles.
        List<String> first2JazzCDTitles = CD.cdList
                .stream()
                .unordered()                     // Don't care about ordering.
                .filter(CD::isJazz)
                .limit(2)
                .map(CD::title)
                .toList();                       // [Java Jam, Keep on Erasing]

        //execution modes
        Stream<CD> seqStream1
                = CD.cdList.stream().filter(CD::isPop);                         // Sequential
        Stream<CD> seqStream2
                = CD.cdList.stream().sequential().filter(CD::isPop);            // Sequential
        Stream<CD> seqStream3
                = CD.cdList.stream().parallel().filter(CD::isPop).sequential(); // Sequential
        Stream<CD> paraStream1
                = CD.cdList.stream().parallel().filter(CD::isPop);              // Parallel
        Stream<CD> paraStream2
                = CD.cdList.stream().filter(CD::isPop).parallel();              // Parallel

        System.out.println(seqStream3.isParallel());                      // false


    }
}