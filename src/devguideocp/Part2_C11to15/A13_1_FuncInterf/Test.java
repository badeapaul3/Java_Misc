package devguideocp.Part2_C11to15.A13_1_FuncInterf;

import static devguideocp.Part2_C11to15.A13_1_FuncInterf.Predicate.testPredicate; /**
 * @author hatzp
 **/





public class Test {
    static class PredicateTest implements Predicate<String> {
        public boolean test(String str) {
            return str.startsWith("A");               // (1)
        }
    }


    static Predicate<String> testLength = new Predicate<>() {
        public boolean test(String str) {
            return str.length() < 4;                  // (2)
        }
    };

    public static void main(String[] args) {
        // Client code:
        System.out.println(testPredicate("Anna", new PredicateTest()));   // true
        System.out.println(testPredicate("Anna", testLength));            // false
    }
}
