package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author hatzp
 **/
public class MethodReferences {
    public static void main(String[] args) {

// String -> void
        Consumer<String> outLE = obj -> System.out.println(obj); // (1a)
        //targetReference::methodName
        Consumer<String> outMR = System.out::println;            // (1b)
        outMR.accept("Save trees!");                             // (2)
// Calls System.out.println("Save trees!") that prints: Save trees!




        //static MR
//        (args) -> RefType.staticMethod(args)
//        RefType::staticMethod

        Supplier<LocalDate> dateNowLE = () -> LocalDate.now();  // (1a) Lambda expression
        Supplier<LocalDate> dateNowMR = LocalDate::now;         // (1b) Method reference

        LocalDate today = dateNowMR.get();    // (2) Method reference at (1b) executed.
        System.out.println(today.format(DateTimeFormatter.ISO_DATE)); // 2021-03-01



        // String -> Integer
        Function<String, Integer> strToIntLE = s -> Integer.parseInt(s); // (3a)
        Function<String, Integer> strToIntMR = Integer::parseInt;        // (3b)
        System.out.println(strToIntMR.apply("100"));                     // (4)
// Calls Integer.parseInt("100") that returns the int value 100 which is boxed
// into an Integer.



        // (double, double) -> double
        DoubleBinaryOperator minDoubleLE = (x, y) -> Math.min(x, y);
        DoubleBinaryOperator minDoubleMR = Math::min;          // (5)
        System.out.println(minDoubleMR.applyAsDouble(20.0, 30.0));
// Calls Math.min(20.0, 30.0) that returns the double value 20.0.

// (int, int) -> (int)
        IntBinaryOperator minIntLE = (x, y) -> Math.min(y, y);
        IntBinaryOperator minIntMR = Math::min;                // (6)
        System.out.println(minIntMR.applyAsInt(20, 30));
// Calls Math.min(20, 30) that returns the int value 20.


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//        (args) -> expr.instanceMethod(args)
//        expr::instanceMethod

        //bounded instance MR

        StringBuilder sb = new StringBuilder("!em esreveR");         // (1)
        System.out.println(sb);
// () -> StringBuilder
        Supplier<StringBuilder> sbReverserLE = () -> sb.reverse();   // (2a)
        Supplier<StringBuilder> sbReverserMR = sb::reverse;          // (2b)
        System.out.println(sbReverserMR.get());                      // (3)
// Calls sb.reverse() that returns the StringBuilder with character sequence
// "Reverse me!".
        System.out.println(sb);

        Supplier<StringBuilder> sbReverserMR2 = new StringBuilder("!oot em esreveR")::reverse;
        System.out.println(sbReverserMR2.get());


        List<String> words = new ArrayList<>();
        words.add("Otto"); words.add("ADA"); words.add("Alyla");
        words.add("Bob"); words.add("HannaH"); words.add("Java");

        words.forEach(obj -> System.out.print(obj+ " "));
        System.out.println();
        words.forEach(System.out::print);

        String str = "Java Jive";                                             // (4)
// (String, String) -> String
        BinaryOperator<String> replaceOpLE = (s1, s2) -> str.replace(s1, s2); // (5a)
        BinaryOperator<String> replaceOpMR = str::replace;                    // (5b)
        System.out.println(replaceOpMR.apply("Jive", "Jam"));                 // (6)
// Calls str.replace("Jive", "Jam") that returns the string "Java Jam".


        //for nonstatic context
//        Predicate<String> p1 = s -> this.equals(s);       // String -> boolean
//        Predicate<String> p2 = this::equals;              // String -> boolean
//        Supplier<String> s1 = () -> super.toString();     // () -> String
//        Supplier<String> s2 = super::toString;            // () -> String

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        //unbounded instance MR
//        (arg0, rest) -> arg0.instanceMethod(rest)
//        RefType::instanceMethod    -    RefType is the type of arg0 target reference

// String -> int
        ToIntFunction<String> lenLE = s -> s.length();
        ToIntFunction<String> lenMR = String::length;                  // (1)
        System.out.println(lenMR.applyAsInt("Java"));                  // 4
// Calls "Java".length() that returns the int value 4.

// (String, String) -> String
        BinaryOperator<String> concatOpLE = (s1, s2) -> s1.concat(s2);
        BinaryOperator<String> concatOpMR = String::concat;           // (2)
        System.out.println(concatOpMR.apply("Java", " Jive"));        // Java Jive
// Calls "Java".concat(" Jive") that returns the string "Java Jive".


// (List<String>, String) -> boolean
        BiPredicate<List<String>, String> containsLE
                = (list, element) -> list.contains(element);

        BiPredicate<List<String>, String> containsMR1 = List::contains;          // (3)
        BiPredicate<List<String>, String> containsMR2 = List<String>::contains;  // (4)
        System.out.println(containsMR2.test(words, "BOB"));  // words is a List<String>.
// Calls words.contains("BOB") that returns a boolean value.












    }
}
