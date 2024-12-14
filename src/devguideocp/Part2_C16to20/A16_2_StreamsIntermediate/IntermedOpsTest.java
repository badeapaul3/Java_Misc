package devguideocp.Part2_C16to20.A16_2_StreamsIntermediate;

import devguideocp.Part2_C16to20.A16_1_Streams.*;

import java.util.*;
import java.util.stream.*;

/**
 * @author hatzp
 **/
public class IntermedOpsTest {
    public static void main(String[] args) {

        List<String> popularTitles = new ArrayList<>();
        popularTitles.add(CD.cd2.title());
        popularTitles.add(CD.cd4.title());

        List<CD> popularCDs2 = new ArrayList<>(CD.cdList);
        System.out.println(popularCDs2);
        popularCDs2.removeIf(cd -> !(popularTitles.contains(cd.title())));
        System.out.println("Query 1b: " + popularCDs2);
        //Query 1b: [<Jaav, "Java Jive", 8, 2017, POP>, <Jaav, "Java Jam", 6, 2017, JAZZ>]

        List<CD> resultList = Stream
                .concat(CD.cdList.stream().limit(2), CD.cdList.stream().skip(2))
                .toList();
        System.out.println(CD.cdList.equals(resultList));            // true

        List<CD> substream = CD.cdList
                .stream()
                .skip(1)
                .limit(3)
                .toList();
        System.out.println("Query 5: " + substream);
        // Query 5: [<Jaav, "Java Jam", 6, 2017, JAZZ>,
        //           <Funkies, "Lambda Dancing", 10, 2018, POP>,
        //           <Genericos, "Keep on Erasing", 8, 2018, JAZZ>]


    }
}
