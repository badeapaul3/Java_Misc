package devguideocp.Part2_C11to15.A13_1_FuncInterf;

/**
 * @author hatzp
 **/


@FunctionalInterface
interface NewStrPredicate {
    boolean test(String str);                                 // (1) Abstract method
    default void msg(String str) { System.out.println(str); } // (2) Default method
    static void info() { System.out.println("Testing!"); }    // (3) Static method
}
