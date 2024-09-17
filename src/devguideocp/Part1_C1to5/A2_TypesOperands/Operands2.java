package devguideocp.Part1_C1to5.A2_TypesOperands;

/**
 * @author hatzp
 **/
public class Operands2 {
    public static void main(String[] args) {

        // Equality for String objects means identical character sequences.
        String movie1 = new String("The Revenge of the Exception Handler");
        String movie2 = new String("High Noon at the Java Corral");
        String movie3 = new String("The Revenge of the Exception Handler");
        boolean test0 = movie1.equals(movie2);             // false.
        boolean test1 = movie1.equals(movie3);             // true.

// Equality for wrapper classes means same type and same primitive value.
        Boolean flag1 = true;                              // Boxing.
        Boolean flag2 = false;                             // Boxing.
        boolean test2 = flag1.equals("true");              // false. Not same type.
        boolean test3 = flag1.equals(!flag2);              // true. Same type and value.

        Integer iRef = 100;                                // Boxing.
        Short sRef = 100;                                  // Boxing <--- short <--- int
        boolean test4 = iRef.equals(100);                  // true. Same type and value.
        boolean test5 = iRef.equals(sRef);                 // false. Not same type.
        boolean test6 = iRef.equals(3.14);                 // false. Not same type.

    }
}
