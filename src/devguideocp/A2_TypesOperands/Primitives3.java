package devguideocp.A2_TypesOperands;

/**
 * @author hatzp
 **/
public class Primitives3 {
    public static void main(String[] args) {
        Byte   b = 10;       // Constant in range: narrowing and boxing on assignment.
        Short  s = 20;       // Constant in range: narrowing and boxing on assignment.

        char   c = 'z';      // 122 (\u007a)
        int    i = s * b;    // Values in s and b promoted to int: unboxing, widening.
        long   n = 20L + s;  // Value in s promoted to long: unboxing, widening.
        float  r = s + c;    // Value in s is unboxed. This short value and the char
        // value in c are promoted to int, followed by implicit
        // widening conversion of int to float on assignment.
        double d = r + i;    // Value in i promoted to float, followed by implicit
        // widening conversion of float to double on assignment.

    }
}
