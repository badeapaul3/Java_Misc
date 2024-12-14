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



















    }
}
