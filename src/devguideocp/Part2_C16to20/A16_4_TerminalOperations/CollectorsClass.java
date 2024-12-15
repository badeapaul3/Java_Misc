package devguideocp.Part2_C16to20.A16_4_TerminalOperations;

import static java.lang.System.out;
import devguideocp.Part2_C16to20.A16_1_Streams.*;

import java.time.Year;
import java.util.Comparator;
import java.util.Optional;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.*;
import java.util.stream.*;
//import static java.util.stream.Collectors.*; common practice
import java.util.stream.Collectors;
/**
 * @author hatzp
 **/
public class CollectorsClass {
    public static void main(String[] args) {

        ArrayList<String> cdTitles1 = CD.cdList.stream() // Stream<CD>
                .map(CD::title)                              // Stream<String>
                .collect(Collectors.toCollection(ArrayList::new));
        //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
        cdTitles1.add("some str");
        out.println(cdTitles1);

        List<String> cdTitles3 = CD.cdList.stream()      // Stream<CD>
                .map(CD::title)                              // Stream<String>
                .collect(Collectors.toList());
        //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
        cdTitles3.add("Java Jingles");                      // OK
        out.println(cdTitles3);


        Set<String> cdTitles2 = CD.cdList.stream()       // Stream<CD>
                .map(CD::title)                              // Stream<String>
                .collect(Collectors.toSet());
        //[Hot Generics, Java Jive, Lambda Dancing, Keep on Erasing, Java Jam]



        //toMap collector
        Map<CD, Year> mapCDToYear = CD.cdList.stream()
                .collect(Collectors.toMap(Function.identity(), CD::year)); // Map<CD, Year>

        List<CD> dupList = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd0, CD.cd1);
//        Map<String, Year> mapTitleToYear1 = dupList.stream()
//                .collect(Collectors.toMap(CD::title, CD::year));       // (1)
//// IllegalStateException: Duplicate key 2017
        Map<String, Year> mapTitleToYear2 = dupList.stream()
                .collect(Collectors.toMap(CD::title, CD::year, (y1, y2) -> y1));       // (1)

        Map<Year, String> mapTitleToYear3 = CD.cdList.stream()
                .collect(Collectors.toMap(CD::year, CD::title,
                        (tt, t) -> tt + ":" + t));
//{2017=Java Jive:Java Jam, 2018=Lambda Dancing:Keep on Erasing:Hot Generics}
        out.println(mapTitleToYear3);

        TreeMap<Year, String> mapYearToLongestTitle = CD.cdList.stream()
                .collect(Collectors.toMap(CD::year, CD::title,
                        BinaryOperator.maxBy(Comparator.naturalOrder()),
                        TreeMap::new));
//{2017=Java Jive, 2018=Lambda Dancing} keys in natural order as per the comparator


        //Collect to a ConcurrentMap (sub-interface of Map)

        ConcurrentMap<Year, String> concMapYearToTitles = CD.cdList
                .parallelStream()
                .collect(Collectors.toConcurrentMap(CD::year, CD::title,
                        (tt, t) -> tt + ":" + t));
//{2017=Java Jam:Java Jive, 2018=Lambda Dancing:Hot Generics:Keep on Erasing}


        //@@@@@@@@@@
        //JOINING - functional reduction as an immutable string is the result

        String concatTitles1 = CD.cdList.stream()         // Stream<CD>
                .map(CD::title)                               // Stream<String>
                .collect(Collectors.joining());               // (1)
//Java JiveJava JamLambda DancingKeep on ErasingHot Generics
        out.println(concatTitles1);


        String concatTitles2 = CD.cdList.stream()
                .map(CD::title)
                .collect(Collectors.joining(", "));           // (2) Delimiter
//Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics


        String concatTitles3 = CD.cdList.stream()
                .map(CD::title)
                .collect(Collectors.joining(", ", "[", "]"));  // (3) Delimiter, Prefix, Suffix
//[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
        out.println(concatTitles3);

        out.println();
        out.println("Grouping By Collector - @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //groupingBy Collector
        Map<Integer, List<CD>> map22 = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.toList()));  // (2)
        out.println(map22);

        Map<Integer, List<CD>> map33 = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks,                         // (3)
                        TreeMap::new,
                        Collectors.toList()));


        Map<Integer, Set<CD>> map44 = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.toSet()));   // (4)


        //any collector can be passed as a downstream collector to the groupingBy method
        Map<Integer, Long> map55 = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.counting()));
        //{6=1, 8=2, 10=2}
        out.println(map55);

        out.println();

        //multilevel grouping

        Map<Integer, Map<Genre, List<CD>>> twoLevelGrp = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks,        // (1)
                        Collectors.groupingBy(CD::genre)));           // (2)

        out.println(twoLevelGrp);


        Map<Integer, Map<Genre, Long>> twoLevelGrp2 = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks,
                        Collectors.groupingBy(CD::genre,
                                Collectors.counting())));   // (3)


        //Grouping to a ConcurrentMap

        ConcurrentMap<Integer, Long> map66 = CD.cdList
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(CD::noOfTracks,
                        Collectors.counting()));
            //{6=1, 8=2, 10=2}

        //PARTITIONING
        Map<Boolean, List<CD>> map1 = CD.cdList.stream()
                .collect(Collectors.partitioningBy(CD::isPop)); // (1)
        out.println(map1);

        Map<Boolean, List<CD>> map2 = CD.cdList.stream()
                .collect(Collectors.partitioningBy(CD::isPop, Collectors.toList())); // (2)

        List<CD> popCDs = map1.get(true);
        List<CD> nonPopCDs = map1.get(false);

        Map<Boolean, Long> map3 = CD.cdList.stream()
                .collect(Collectors.partitioningBy(CD::isPop, Collectors.counting()));
        //{false=3, true=2}


        //Multilevel partitioning

        Map<Boolean, Map<Year, List<CD>>> map4 = CD.cdList.stream()
                .collect(Collectors.partitioningBy(CD::isPop,                     // (1)
                        Collectors.groupingBy(CD::year)));                   // (2)

        out.println(map4);

        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
// Filtering downstream from grouping.
        Map<Integer, List<CD>> grpByTracksFilterByPopCD = CD.cdList.stream()
                .collect(Collectors.groupingBy(CD::noOfTracks,                        // (1)
                        Collectors.filtering(CD::isPop, Collectors.toList())));  // (2)

        out.println(grpByTracksFilterByPopCD);

        // Filtering before grouping.
        Map<Integer, List<CD>> filterByPopCDGrpByTracks = CD.cdList.stream()
                .filter(CD::isPop)                                                     // (1)
                .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.toList()));

        out.println(filterByPopCDGrpByTracks);

        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        //EQUIVALENT
        // Filtering downstream from partitioning.
        Map<Boolean, List<CD>> partbyPopCDsFilterByYear = CD.cdList.stream()     // (1)
                .collect(Collectors.partitioningBy(CD::isPop,
                        Collectors.filtering(cd -> cd.year().equals(Year.of(2018)),
                                Collectors.toList()))); // (2)
        out.println(partbyPopCDsFilterByYear);
        // Filtering before partitioning.
        Map<Boolean, List<CD>> filterByYearPartbyPopCDs = CD.cdList.stream()     // (2)
                .filter(cd -> cd.year().equals(Year.of(2018)))
                .collect(Collectors.partitioningBy(CD::isPop, Collectors.toList()));
        out.println(filterByYearPartbyPopCDs);

        out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        //Mapping Adapter for downstream Collectors
        Map<Year, Set<String>> titlesByYearInSet = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.mapping(                           // (1)
                                CD::title,                                // Mapper
                                Collectors.toSet())));                    // Downstream collector
        System.out.println(titlesByYearInSet);
        // {2017=[Java Jive, Java Jam],
        //  2018=[Hot Generics, Lambda Dancing, Keep on Erasing]}

        Map<Year, String> joinTitlesByYear = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.mapping(                           // (2)
                                CD::title,
                                Collectors.joining(":"))));
        System.out.println(joinTitlesByYear);
        // {2017=Java Jive:Java Jam,
        //  2018=Lambda Dancing:Keep on Erasing:Hot Generics}

        Map<Year, Long> TotalNumOfTracksByYear = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.mapping(                            // (3)
                                CD::noOfTracks,
                                Collectors.counting())));
        System.out.println(TotalNumOfTracksByYear);           // {2017=2, 2018=3}

        //Flat Mapping Adapter for downstream collectors

        // Given lists of CDs:
        List<CD> cdListA = List.of(CD.cd0, CD.cd1);
        List<CD> cdListB = List.of(CD.cd0, CD.cd1, CD.cd1);

        // Find unique CD titles in the given lists:
        Set<String> set =
                Stream.of(cdListA, cdListB)                         // (1) Stream<List<CD>>
                        .collect(Collectors.flatMapping(List::stream, // (2) Flatten to Stream<CD>
                                Collectors.mapping(CD::title,            // (3) Stream<String>
                                        Collectors.toSet())));               // (4) Set<String>

        out.println(set);


        //finishing adapter for downstream collectors

        Map<Year, Integer> maxTracksByYear = CD.cdList.stream()
                .collect(
                        Collectors.groupingBy(
                        CD::year,
                        Collectors.collectingAndThen(                                  // (1)
                                Collectors.maxBy(Comparator.comparing(CD::noOfTracks)),    // (2)
                                optCD -> optCD.map(CD::noOfTracks).orElse(0)))             // (3)
                );
        System.out.println(maxTracksByYear);                      // {2017=8, 2018=10}


        Map<Genre, String> avgTracksByGenre = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::genre,
                        Collectors.collectingAndThen(                                  // (4)
                                Collectors.averagingDouble(CD::noOfTracks),                // (5)
                                d -> String.format("%.1f", d)))                            // (6)
                );
        System.out.println(avgTracksByGenre);                   // {JAZZ=8.0, POP=9.0}


//Downstream Collectors for Functional Reduction

        //counting
        Long numOfJazzCds1 = CD.cdList.stream().filter(CD::isJazz)
                .collect(Collectors.counting());                  // (1) Standalone collector
        System.out.println(numOfJazzCds1);                    // 3

        Map<Genre, Long> grpByGenre = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::genre,
                        Collectors.counting()));             // (2) Downstream collector
        System.out.println(grpByGenre);                       // {POP=2, JAZZ=3}
        System.out.println(grpByGenre.get(Genre.JAZZ));       // 3


        //the usual Stream count option
        long numOfJazzCds2 = CD.cdList.stream().filter(CD::isJazz)
                .count();                                         // (3) Stream.count()
        System.out.println(numOfJazzCds2);                    // 3

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //min-max
        Comparator<CD> natCmp = Comparator.naturalOrder(); // (1)

        Optional<CD> maxCD = CD.cdList.stream()
                .collect(Collectors.maxBy(natCmp));            // (2) Standalone collector
        System.out.println("Max CD: "
                + maxCD.map(CD::title).orElse("No CD."));      // Max CD: Java Jive

// Group CDs by musical genre, and max CD in each group.
        Map<Genre, Optional<CD>> grpByGenre2 = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::genre,
                        Collectors.maxBy(natCmp)));       // (3) Downstream collector
        System.out.println(grpByGenre2);
//{JAZZ=Optional[<Jaav, "Java Jam", 6, 2017, JAZZ>],
// POP=Optional[<Jaav, "Java Jive", 8, 2017, POP>]}

        System.out.println("Title of max Jazz CD: "
                + grpByGenre2.get(Genre.JAZZ)
                .map(CD::title)
                .orElse("No CD."));       // Title of max Jazz CD: Java Jam


        //summing
        Integer sumTracks = CD.cdList.stream()
                .collect(Collectors.summingInt(CD::noOfTracks));   // (1) Standalone collector
        System.out.println(sumTracks);                         // 42


        Map<Genre, Integer> grpByGenre3 = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::genre,
                        Collectors.summingInt(CD::noOfTracks)));    // (2) Downstream collector
        System.out.println(grpByGenre3);                      // {POP=18, JAZZ=24}
        System.out.println(grpByGenre3.get(Genre.JAZZ));      // 24

        //same as
        int sumTracks2 = CD.cdList.stream()                  // (3) Stream<CD>
                .mapToInt(CD::noOfTracks)                        // IntStream
                .sum();
        System.out.println(sumTracks2);                      // 42


        //average

        Double avgNoOfTracks1 = CD.cdList.stream()
                .collect(Collectors
                        .averagingInt(CD::noOfTracks));             // (1) Standalone collector
        System.out.println(avgNoOfTracks1);                 // 8.4

        Map<Genre, Double> grpByGenre4 = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::genre,
                        Collectors.averagingInt(CD::noOfTracks)      // (2) Downstream collector
                ));
        System.out.println(grpByGenre4);                     // {POP=9.0, JAZZ=8.0}
        System.out.println(grpByGenre4.get(Genre.JAZZ));     // 8.0

        //same as
        OptionalDouble avgNoOfTracks2 = CD.cdList.stream()  // Stream<CD>
                .mapToInt(CD::noOfTracks)                       // IntStream
                .average();                                     // (3)
        System.out.println(avgNoOfTracks2.orElse(0.0));     // 8.4


        //Summarizing
        IntSummaryStatistics stats1 = CD.cdList.stream()
                .collect(
                        Collectors.summarizingInt(CD::noOfTracks)      // (1) Standalone collector
                );
        System.out.println(stats1);
        // IntSummaryStatistics{count=5, sum=42, min=6, average=8.400000, max=10}

        Map<Genre, IntSummaryStatistics> grpByGenre5 = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::genre,
                        Collectors.summarizingInt(CD::noOfTracks)));    // (2) Downstream collector
        System.out.println(grpByGenre5);
//{POP=IntSummaryStatistics{count=2, sum=18, min=8, average=9.000000, max=10},
// JAZZ=IntSummaryStatistics{count=3, sum=24, min=6, average=8.000000, max=10}}

        System.out.println(grpByGenre5.get(Genre.JAZZ));   // Summary stats for Jazz CDs.
// IntSummaryStatistics{count=3, sum=24, min=6, average=8.000000, max=10}

        //same as
        IntSummaryStatistics stats2 = CD.cdList.stream()
                .mapToInt(CD::noOfTracks)
                .summaryStatistics();                         // (3)
        System.out.println(stats2);
// IntSummaryStatistics{count=5, sum=42, min=6, average=8.400000, max=10}

        //REDUCING

        // Comparator to compare CDs by title.
        Comparator<CD> cmpByTitle = Comparator.comparing(CD::title);        // (1)
// Comparator to compare strings by their length.
        Comparator<String> byLength = Comparator.comparing(String::length); // (2)

        Optional<String> longestTitle1 = CD.cdList.stream()
                .map(CD::title)
                .collect(Collectors.reducing(
                        BinaryOperator.maxBy(byLength)));            // (3) Standalone collector
        System.out.println(longestTitle1.orElse("No title"));// Keep on Erasing
        //these 2 are equivalent
        Optional<String> longestTitle2 = CD.cdList.stream()  // Stream<CD>
                .map(CD::title)                                  // Stream<String>
                .reduce(BinaryOperator.maxBy(byLength));         // (4) Stream.reduce(bop)


        //@@@@@@@@@@@@@@@@@@
        Map<Year, Optional<CD>> cdWithMaxTitleByYear = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.reducing(                        // (5) Downstream collector
                                BinaryOperator.maxBy(cmpByTitle))
                ));
        System.out.println(cdWithMaxTitleByYear);
// {2017=Optional[<Jaav, "Java Jive", 8, 2017, POP>],
//  2018=Optional[<Funkies, "Lambda Dancing", 10, 2018, POP>]}

        System.out.println(cdWithMaxTitleByYear.get(Year.of(2018))
                .map(CD::title).orElse("No title")); // Lambda Dancing


        Map<Year, String> longestTitleByYear = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.reducing("", CD::title,          // (6) Downstream collector
                                BinaryOperator.maxBy(byLength))
                ));
        System.out.println(longestTitleByYear);  // {2017=Java Jive, 2018=Keep on Erasing}
        System.out.println(longestTitleByYear.get(Year.of(2018)));      // Keep on Erasing

        Map<Year, Optional<String>> longestTitleByYear2 = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.mapping(CD::title,               // (7) Downstream collector
                                Collectors.maxBy(byLength))
                ));
        System.out.println(longestTitleByYear2);
// {2017=Optional[Java Jive], 2018=Optional[Keep on Erasing]}
        System.out.println(longestTitleByYear2.get(Year.of(2018))
                .orElse("No title."));        // Keep on Erasing


        Map<Year, Integer> noOfTracksByYear = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.reducing(                        // (8) Downstream collector
                                0, CD::noOfTracks, Integer::sum)));
        System.out.println(noOfTracksByYear);                   // {2017=14, 2018=28}
        System.out.println(noOfTracksByYear.get(Year.of(2018)));// 28

        Map<Year, Integer> noOfTracksByYear2 = CD.cdList.stream()
                .collect(Collectors.groupingBy(
                        CD::year,
                        Collectors.summingInt(CD::noOfTracks)));    // (9) Special case collector









    }
}
