package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author hatzp
 **/
public class PredicateTests {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("Otto"); words.add("ADA"); words.add("Alyla");
        words.add("Bob"); words.add("HannaH"); words.add("Java");

        Predicate<String> isPalindrome
                = str -> new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
// Before: [Otto, ADA, Alyah, Bob, HannaH, Java]
        words.removeIf(isPalindrome);          // Remove all palindromes.
// After:  [Alyah, Java]

        List<String> words2 = new ArrayList<>();
        words2.add("Otto"); words2.add("ADA"); words2.add("Alyla");
        words2.add("Bob"); words2.add("HannaH"); words2.add("Java");
        // Before: [Otto, ADA, Alyah, Bob, HannaH, Java]
        words2.removeIf(new Predicate<String>() {
            public boolean test(String str) {
                return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
            }
        });
// After:  [Alyah, Java]

        Predicate<String> isEvenLen = str -> str.length() % 2 == 0;
// Before: [Otto, ADA, Alyah, Bob, HannaH, Java]
        words.removeIf(isEvenLen);             // Remove all even length words.
// After:  [ADA, Alyah, Bob]

        Predicate<String> startsWithA = str -> str.startsWith("A");
// Before: [Otto, ADA, Alyah, Bob, HannaH, Java]
        words.removeIf(startsWithA);           // Remove all words that start with "A".
// After:  [Otto, Bob, HannaH, Java]




//        ((x.or(y)).and(z))
//                = ((true.or(y)).and(z))
//                = (true.and(z))
//                = (true.and(false))
//                = false
// A string that is not a palindrome.
        Predicate<String> isNotPalindrome = isPalindrome.negate();       // (1)

// A string with even length or starts with an 'A', and is not a palindrome.
        Predicate<String> composedPredicate
                = isEvenLen.or(startsWithA).and(isNotPalindrome);            // (2)
        System.out.println("Using composed predicate on \"Adda\": "
                + composedPredicate.test("Adda"));                       // (3) false.



//        (a || (b && (!c)))
//                = (a || (b && (!true)))
//                = (a || (b && false))
//                = (a || (false))
//                = (true || false)
//                = true
// A string with even length, or it starts with an 'A' and is not a palindrome.
        Predicate<String> conditionalOperators
                = str -> str.length() % 2 == 0 || str.startsWith("A")        // (4)
                && !(new StringBuilder(str).reverse().toString().equalsIgnoreCase(str));
        System.out.println("Using conditional operators on \"Adda\": "
                + conditionalOperators.test("Adda"));                    // (5) true.


        Predicate<String> isEqualToTarget = Predicate.isEqual("Ada");
        System.out.println(isEqualToTarget.test("Adda"));           // false.
        System.out.println(Predicate.isEqual("Ada").test("Ada"));   // true.
        System.out.println(Predicate.isEqual("null").test("null")); // true.



        Predicate<Integer> isEven = i -> i % 2 == 0;         // Operand unboxed.
        System.out.println("2021 is an even number: "
                + isEven.test(2021));              // Argument boxed. false.

        IntPredicate isEvenInt = i -> i % 2 == 0;            // No unboxing.
        System.out.println("2021 is an even number: "
                + isEvenInt.test(2021));           // No boxing. false.

        //mytest
        LocalDate localDate = LocalDate.now();
        int x = localDate.getYear();
        int testval = 2023;
        IntPredicate higherthanvalue = i -> i > x;
        System.out.println(testval + " is higher than current year? "+ higherthanvalue.test(testval));

        IntPredicate isOddInt = isEvenInt.negate();          // Negating a predicate.
        System.out.println("2020 is an odd number: "
                + isOddInt.test(2020));            // false.

        IntPredicate isInRange = i -> -100 <= i && i <= 100; // Range: [-100, 100]
        System.out.println("21 is in range and odd: "
                + isInRange.and(isOddInt).test(21));// true.

        //@@@@@@@@@@ BiPredicates

    }
}
