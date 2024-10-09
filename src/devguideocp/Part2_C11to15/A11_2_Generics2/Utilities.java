package devguideocp.Part2_C11to15.A11_2_Generics2;

/**
 * @author hatzp
 **/
public class Utilities {

    // The key type and the array element type can be any type.
    static boolean containsV1(Object key, Object[] array) { // (1) Non-generic
        //     version
        for (Object element : array)
            if (key.equals(element)) return true;
        return false;
    }

    // The key type and the array element type are the same.
    static <E> boolean containsV2(E key, E[] array) {       // (2) Generic version
        for (E element : array)
            if (key.equals(element)) return true;
        return false;
    }

    // The key type is a subtype of the array element type.
    static <K extends E, E> boolean containsV3(K key, E[] array) {  // (3)
        for (E element : array)
            if (key.equals(element)) return true;
        return false;
    }

    public static void main(String[] args) {

        Integer[] intArray = {10, 20, 30};

        boolean f1 = Utilities.<Integer>containsV2(20, intArray);           // (1) true
// E is Integer.
// Method signature:      containsV2(Integer, Integer[])
// Method call signature: containsV2(Integer, Integer[])

        boolean f2 = Utilities.<Number>containsV2(30.5, intArray);          // (2) false
// E is Number.
// Method signature:      containsV2(Number, Number[])
// Method call signature: containsV2(Double, Integer[])

        boolean f3 = Utilities.<Comparable<Integer>> containsV2(20, intArray); // (3) true
// E is Comparable<Integer>.
// Method signature:      containsV2(Comparable<Integer>, Comparable<Integer>[])
// Method call signature: containsV2(Integer,             Integer[])

        //boolean f4 = Utilities.<Integer>containsV2(30.5, intArray);         // (4) Error!
// E is Integer.
// Method signature:      containsV2(Integer, Integer[])
// Method call signature: containsV2(Double,  Integer[])

// Requires explicit reference or raw type.
        //boolean f5 = <Integer>containsV2(20, intArray);              // (5) Syntax error!


        boolean f6 = Utilities.containsV2(20, intArray);                    // (6) true
// E is inferred to be Integer.
// Method signature:      containsV2(Integer, Integer[])
// Method call signature: containsV2(Integer, Integer[])

        boolean f7 = Utilities.containsV2(30.5, intArray);                  // (7) false;
// E is inferred to be Number.
// Method signature:      containsV2(Number, Number[])
// Method call signature: containsV2(Double, Integer[])

        boolean f8 = Utilities.containsV2("Hi", intArray);                  // (8) false;
// E is inferred to be Serializable.
// Method signature:      containsV2(Serializable, Serializable[])
// Method call signature: containsV2(String, Integer[])


        //@@@ V3
        boolean f10 = Utilities.containsV3(30.5, intArray);                 // (10) false
// K is inferred to be Double. E is inferred to be Number.
// The constraint (K extends E) is satisfied.
// Method signature:      containsV3(Double, Number[])
// Method call signature: containsV2(Double, Integer[])

        boolean f11 = Utilities.containsV3("Hi", intArray);                 // (11) false
// K is inferred to be String. E is inferred to be Serializable.
// The constraint (K extends E) is satisfied.
// Method signature:      containsV3(String, Serializable[])
// Method call signature: containsV2(String, Integer[])


        boolean f12 = Utilities.<Number, Number>containsV3(30.0, intArray); // (12) false
// K is Number. E is Number.
// The constraint (K extends E) is satisfied.
// Method signature:      containsV3(Number, Number[])
// Method call signature: containsV3(Double, Integer[])

        //boolean f13 = Utilities.<Number, Integer>containsV3(30.5, intArray);                 // (13) Error!
// K is Number. E is Integer.
// The constraint (K extends E) is not satisfied.

        //boolean f14 = Utilities.<Integer, Number>containsV3(30.5, intArray);                 // (14) Error!
// K is Integer. E is Number.
// The constraint (K extends E) is satisfied.
// Method signature:      containsV3(Integer, Number[])
// Method call signature: containsV3(Double, Integer[])

        //boolean f15 = Utilities.<Number>containsV3(30.5, intArray);         // (15) Error!
// Incorrect no. of type parameters.
    }
}
