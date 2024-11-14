package devguideocp.Part2_C11to15.A15_1_Collections;

/**
 * @author hatzp
 **/

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.IntFunction;

public class CollectionToArray {
    public static void main(String[] args) {

        Collection<String> strSet = new HashSet<>();
        strSet.add("2021"); strSet.add("2022"); strSet.add("2023");
        int n = strSet.size();

        Object[] objects = strSet.toArray();                // (1)
//  String[] string = strSet.toArray();                 // (2) Compile-time error!

        Object[] objArray = strSet.toArray(new Object[0]);                     // (3)
        System.out.println("Array size: " + objArray.length);
        System.out.println("Array type: " + objArray.getClass().getName());
        System.out.println("Actual element type: " +
                objArray[0].getClass().getName());

        String[] strArray1 = new String[0];
        String[] strArray2 = strSet.toArray(strArray1);                        // (4)
        System.out.println("strArray1 == strArray2: " + (strArray1 == strArray2));

        String[] strArray3 = new String[n];
        String[] strArray4 = strSet.toArray(strArray3);                        // (5)
        System.out.println("strArray3 == strArray4: " + (strArray3 == strArray4));

//  Integer[] intArray = strSet.toArray(new Integer[n]);     // (6) Runtime error!

        IntFunction<String[]> createStrArray = nn -> new String[nn];           // (7)
        String[] strArray5 = strSet.toArray(createStrArray);                   // (8a)
        String[] strArray6 = strSet.toArray(String[]::new);                    // (8b)
        String[] strArray7 = strSet.toArray(createStrArray.apply(0));          // (8c)
        System.out.println("strArray5: " + Arrays.toString(strArray5));
        System.out.println("strArray6: " + Arrays.toString(strArray6));
        System.out.println("strArray7: " + Arrays.toString(strArray7));



        Collection<Number> numSet = new HashSet<>();
        numSet.add(23);
        numSet.add(15);
        numSet.add(2);
        numSet.add(4);
        numSet.add(8);
        System.out.println("@@@@@@@@@@@@@@@@@@");
        numSet.stream().sorted().forEach(System.out::print);
        System.out.println(numSet.size());

        Number[] numArray = numSet.toArray(new Integer[0]);

        System.out.println(Arrays.toString(numArray));




    }
}