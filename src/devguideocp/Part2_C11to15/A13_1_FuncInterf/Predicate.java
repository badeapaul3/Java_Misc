package devguideocp.Part2_C11to15.A13_1_FuncInterf;

/**
 * @author hatzp
 **/

@FunctionalInterface
interface Predicate<T> {
    boolean test(T element);                                // Functional method.

    public static <T> boolean testPredicate(T object, Predicate<T> predicate) {
        return predicate.test(object);
    }
    // ...
}
