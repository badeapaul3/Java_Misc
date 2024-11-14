package devguideocp.Part2_C11to15.A15_1_Collections;

import java.util.*;

/**
 * @author hatzp
 **/
public class SetTests {
    public static void main(String[] args) {

        Set<String> set = Set.of("Tom", "Dick", "Harriet");
//  set.add("Harry");                          // UnsupportedOperationException
//  set.remove(2);                             // UnsupportedOperationException
        System.out.println(set);                       // [Harriet, Tom, Dick]
        System.out.println(set instanceof HashSet);    // false

//        Set<String> coinSet = Set.of("dime", "nickel", null); // NullPointerException


        Set<Integer> intSet1 = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);     // Fixed-arity
        Set<Integer> intSet2 = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11); // Varargs
        System.out.println(intSet1);        // [9, 8, 7, 6, 5, 4, 3, 2, 1, 10]
        System.out.println(intSet2);        // [7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8]


        String[] strArray = {"Tom", "Dick", "Harriet"};
        Set<String> strSet = Set.of(strArray);                   // (1) Set of String
        Set<String[]> strArraySet = Set.<String[]>of(strArray);  // (2) Set of String[]
        System.out.println(strSet);                  // [Harriet, Dick, Tom]
        System.out.println(strArraySet);             // [[Ljava.lang.String;@3b22cdd0]

        Set<String> fab4 = new HashSet<>();
        fab4.add("John"); fab4.add("Paul"); fab4.add("George"); fab4.add("Ringo");
        System.out.println(fab4);                    // [George, John, Ringo, Paul]
        Set<String> fabAlways = Set.copyOf(fab4);    // (1)
        fab4.remove("John"); fab4.remove("George");  // Modify original set
        System.out.println(fab4);                    // [Ringo, Paul]
        System.out.println(fabAlways);               // [John, Paul, Ringo, George]











    }
}
