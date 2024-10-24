package devguideocp.Part2_C11to15.A13_2_Lambdas;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author hatzp
 **/
public class Test1 {
    public static void main(String[] args) {
      /*  () -> {};                         // Empty parameter list

// Single formal parameter:
        (String str) -> {};               // Single declared-type parameter
        (str)        -> {};               // Single inferred-type parameter
        str          -> {};               // Single inferred-type parameter
        (var str)    -> {};               // Single var-type inferred parameter

// Multiple formal parameters:
        (Integer x, Integer y) -> {};     // Multiple declared-type parameters
        (x, y)                 -> {};     // Multiple inferred-type parameters
        (var x, var y)         -> {};     // Multiple var-type inferred parameters

// Modifiers and annotations with formal parameters:
        (final int i, int j) -> {};       // Modifier with declared-type parameters
        (final var i, var j) -> {};       // Modifier with var-type inferred parameters
        (@NonNull int i, int j) -> {};    // Annotation with declared-type parameter
        (var i, @Nullable var j)-> {};    // Annotation with var-type inferred parameter

// Parentheses are mandatory with multiple formal parameters:
        String str           -> {};       // Illegal: Missing parentheses
        var str              -> {};       // Illegal: Missing parentheses
        Integer x, Integer y -> {};       // Illegal: Missing parentheses
        x, y                 -> {};       // Illegal: Missing parentheses
        var x, var y         -> {};       // Illegal: Missing parentheses

// All formal parameters must be either declared-type, inferred-type, or
// var-type inferred parameters.
        (String str, j)     -> {};      // Cannot mix declared-type and inferred-type
        (String str, var j) -> {};      // Cannot mix declared-type and var-type inferred
        (var str, j)        -> {};      // Cannot mix var-type inferred and inferred-type

// Modifiers and annotations cannot be used with inferred-type parameters.
        (final str, j)      -> {};      // No modifiers with inferred-type parameters
        (str, @NonNull j)   -> {};      // No annotations with inferred-type parameters*/


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


//        () -> 2021                                  // Expression body, non-void return
//        () -> null                                  // Expression body, non-void return
//        (i, j) -> i + j                             // Expression body, non-void return
//                (i, j) -> i <= j ? i : j                    // Expression body, non-void return
//        str -> str.length() > 3                     // Expression body, non-void return
//        str -> str != null                          // Expression body, non-void return
//                && !str.equals("") && str.length() > 3
//                &&  str.equals(new StringBuilder(str).reverse().toString())

//        val -> System.out.println(val)    // Method invocation statement, void return
//        sb -> sb.trimToSize()             // Method invocation statement, void return
//        sb -> sb.append("!")              // Method invocation statement, non-void return
//        () -> new StringBuilder("?")      // Object creation statement, non-void return
//        value -> value++                  // Increment statement, non-void return
//        value -> value *= 2               // Assignment statement, non-void return
//
//        (int i) -> while (i < 10) ++i     // Illegal: not an expression but statement
//        (x, y) -> return x + y            // Illegal: return not allowed in expression

//        () -> {}                                    // Block body, void return
//        () -> { return 2021; }                      // Block body, non-void return
//        () -> { return 2021 }      // Illegal: statement terminator (;) in block missing
//        () -> { new StringBuilder("Go nuts."); }           // Block body, void return
//        () -> { return new StringBuilder("Go nuts!"); }    // Block body, non-void return
//        (int i) -> { while (i < 10) ++i; }                 // Block body, void return
//        (i, j) -> { if (i <= j) return i; else return j; } // Block body, non-void return
//        (done) -> {                     // Multiple statements in block body, void return
//            if (done) {
//
//                System.out.println("You deserve a break!");
//                return;
//            }
//            System.out.println("Stay right here!");
//        }



        //2 equivalent implementations
        Predicate<Integer> p1 = i -> i % 2 == 0;  // (1) Target type: Predicate<Integer>

        Predicate<Integer> p12 = new Predicate<>() {  // Anonymous class
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        };

        IntPredicate p2 = i -> i % 2 == 0;        // (2) Target type: IntPredicate

        System.out.println(p1 == p2);            // false


        boolean result1 = p1.test(2021);          // false
        boolean result2 = p2.test(2020);          // true


    }
}
