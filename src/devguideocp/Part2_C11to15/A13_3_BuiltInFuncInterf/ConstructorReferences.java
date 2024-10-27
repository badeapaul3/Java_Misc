package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.util.Locale;
import java.util.function.*;

/**
 * @author hatzp
 **/
public class ConstructorReferences {
    public static void main(String[] args) {

        //(args) -> new ClassType(args)
        //ClassType::new

        // () -> StringBuilder
        Supplier<StringBuilder> sbLE = () -> new StringBuilder();
        Supplier<StringBuilder> sbCR = StringBuilder::new;               // (1)
        StringBuilder sbRef = sbCR.get();
// Calls new StringBuilder() to create an empty StringBuilder instance.

// String -> StringBuilder
        Function<String, StringBuilder> sb3 = s -> new StringBuilder(s);
        Function<String, StringBuilder> sb4 = StringBuilder::new;        // (2)
        System.out.println(sb4.apply("Build me!"));                      // Build me!
// Calls new StringBuilder("Build me!") to create a StringBuilder instance
// based on the string "Build me!".


        // (String, String) -> Locale
        BiFunction<String, String, Locale> locConsLE
                = (language, country) -> new Locale(language, country);
        BiFunction<String, String, Locale> locConsCR = Locale::new;
        System.out.println(locConsCR.apply("en","US"));                  // en_US
// Calls new Locale("en", "US") to create a Locale instance with the specified
// parameter values.


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //ARRAY Constructor references
//        arg -> new ElementType[arg][]...[]
//        ElementType[][]...[]::new

// int -> int[]
        IntFunction<int[]> intArrConsLE = n -> new int[n];
        IntFunction<int[]> intArrConsCR = int[]::new;                              // (1)
        int[] intArr = intArrConsCR.apply(4);                                      // (2)
// Creates an int array of length 4.


// (int, int) -> int[][]
        BiFunction<Integer, Integer, int[][]> twoDimArrConsLE1 = (n, m) -> new int[n][m];
// BiFunction<Integer, Integer, int[][]> twoDimArrConsCR1
//      = int[][]:: new;                               // (3) Compile-time error!


        // int -> int[][]
        IntFunction<int[][]> twoDimArrConsLE = n -> new int[n][];
        IntFunction<int[][]> twoDimArrConsCR = int[][]::new;            // (4)
        int[][] twoDimIntArr1 = twoDimArrConsCR.apply(3);               // (5)
// [null, null, null]
        for (int i = 0; i < twoDimIntArr1.length; ++i)
            twoDimIntArr1[i] = intArrConsCR.apply(i+1);                   // (6) Calls (1).
// [[0], [0, 0], [0, 0, 0]]



// int -> StringBuilder[]
        IntFunction<StringBuilder[]> sbaConsLE = n -> new StringBuilder[n];
        IntFunction<StringBuilder[]> sbaConsCR = StringBuilder[]::new;
        StringBuilder[] sbArr2 = sbaConsCR.apply(5);                      // (7)
// [null, null, null, null, null]


        // n -> String[]
        String[] strArrLE = createArray(5, n -> new String[n]); // (9)
        String[] strArrACE = createArray(5, String[]::new);     // (10)

    }

    public static <A> A[] createArray(int length, IntFunction<A[]> creator) {
//A[] arr = new A[length];       // (8) Cannot create generic array!
        return creator.apply(length);  // Lambda expression or

        // array constructor reference executed.
    }
}
