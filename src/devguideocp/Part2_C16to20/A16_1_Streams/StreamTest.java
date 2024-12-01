package devguideocp.Part2_C16to20.A16_1_Streams;

import java.time.*;
import java.util.*;

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






    }

}
