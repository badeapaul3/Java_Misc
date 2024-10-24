package devguideocp.Part2_C11to15.A13_1_FuncInterf;

/**
 * @author hatzp
 **/

@FunctionalInterface                             // Annotation.
interface StrPredicate {
    boolean test(String str);                      // Sole public abstract method.
}
