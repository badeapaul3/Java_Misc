package devguideocp.Part2_C11to15.A13_1_FuncInterf;

/**
 * @author hatzp
 **/


@FunctionalInterface
interface Funky {
    @Override int hashCode();                               // From Object class
    @Override boolean equals(Object obj);                   // From Object class
    @Override String toString();                            // From Object class
    boolean doTheFunk(Object obj);                          // Abstract method
}