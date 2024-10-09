package devguideocp.Part2_C11to15.A12_1_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

/**
 * @author hatzp
 **/
public class Test {


    public static void main(String[] args) {
        ArrayList<String> palindromes = new ArrayList<>();
        List<String> palindromes2 = new ArrayList<String>();
        out.println(palindromes);


        ArrayList<Integer> intList = new ArrayList<>();        // (1) ArrayList of Integer
        intList.add(10); intList.add(100); intList.add(1000);
        ArrayList<String> newList1 = new ArrayList(intList);   // (2) Unchecked conversion
        //     warning
        //System.out.println( newList1.get(0));                   // (3) ClassCastException!
        //ArrayList<String> newList2 = new ArrayList<>(intList); // (4) Compile-time error!

        List<String> palindromes3 = new LinkedList<>(); // Changing implementation.
        List<String> palindromes4 = new ArrayList<>(20); // Initial capacity is 20.


        palindromes.add("level"); palindromes.add("Ada"); palindromes.add("kayak");
        out.println(palindromes);

        List<String> wordList = new ArrayList<>(palindromes);
        out.println(wordList); // [level, Ada, kayak]
        wordList.add("Naan");
        out.println(wordList); // [level, Ada, kayak, Naan]


        List<StringBuilder> synonyms   = new ArrayList<>(); // List of StringBuilder
        List<Integer> attendance       = new ArrayList<>(); // List of Integer
        List<List<String>> listOfLists = new ArrayList<>(); // (3) List of List of String
        //List<int> frequencies          = new ArrayList<>(); // (4) Compile-time error!


        Object[] objArray = new String[10];                 // (5) OK!
        objArray[2] = "Green";                              // (6) OK!
        //objArray[1] = Integer.valueOf(2016);                // ArrayStoreException!
        objArray[1] = Integer.toString(2016);                // ArrayStoreException!

//        ArrayList<Object> objList1 = new ArrayList<String>();// (7) Compile-time error!
//        List<Object> objList2 = new ArrayList<String>();     // (8) Compile-time error!
//
        ArrayList<?> objList1 = new ArrayList<String>(palindromes);// (7*)
        List<? super String> objList2 = new ArrayList<String>(palindromes);     // (8*)

        //objList1.add("test"); //compile time error as the type is capture of ?
        String x = (String) objList1.get(1);
        out.println(x);

        objList2.add("test");
        String y = (String) objList2.get(2);
        out.println(y);



        List<String> list = List.of("Tom", "Dick", "Harriet");
//  list.add("Harry");                          // UnsupportedOperationException
//  list.remove(2);                             // UnsupportedOperationException
//  list.set(0, "Tommy");                       // UnsupportedOperationException
        out.println(list);                       // [Tom, Dick, Harriet]
        out.println(list instanceof ArrayList);  // false


        List<Integer> intList1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);   // Fixed-arity
        List<Integer> intList2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11); // Varargs
        out.println(intList1);        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        out.println(intList2);        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]


        String[] strArray = {"Tom", "Dick", "Harriet"};
        List<String> strList = List.of(strArray);                  // (1) List of String (variable ariety used)
        List<String[]> strArrayList = List.<String[]>of(strArray); // (2) List of String[]
        out.println(strList);       // [Tom, Dick, Harriet]
        out.println(strArrayList);  // [[Ljava.lang.String;@3b22cdd0]


        List<String> fab4 = new ArrayList<>();
        fab4.add("John"); fab4.add("Paul"); fab4.add("George"); fab4.add("Ringo");
        out.println(fab4);                    // [John, Paul, George, Ringo]
        List<String> fabAlways = List.copyOf(fab4);  // (1)
        fab4.remove("John"); fab4.remove("George");  // Modify original list
        out.println(fab4);                    // [Paul, Ringo]
        out.println(fabAlways);               // [John, Paul, George, Ringo]

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        List<Integer> yrList3 = Arrays.asList(2020, 2021, 2022);
        yrList3.set(2, 2023);                     // (1) OK
        out.println(yrList3);                     // [2020, 2021, 2023]

        List<Integer> yrlist4 = List.of(2020, 2021, 2022);
        yrlist4.set(2, 2023);                     // (2) UnsupportedOperationException

        yrList3.add(2050);                        // UnsupportedOperationException
        yrlist4.remove(0);                        // UnsupportedOperationException

        List<Integer> yrList5 = Arrays.asList(2020, 2021, null);  // OK.
        List<Integer> yrlist6 = List.of(2020, 2021, null);        // NullPointerException
        boolean flag1 = Arrays.asList(2021, 2022).contains(null); // OK.
        boolean flag2 = List.of(2021, 2022).contains(null);       // NullPointerException



    }
}
