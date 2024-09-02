package devguideocp.A2_TypesOperands;

/**
 * @author hatzp
 **/
public class Operands {
    public static void main(String[] args) {

        // (1) Prefix order: increment/decrement operand before use.
        int i = 10;
        int k = ++i + --i;  // ((++i) + (--i)). k gets the value 21 and i becomes 10.
        --i;                // Only side effect utilized. i is 9. (expression statement)

        Integer iRef = 11;  // Boxing on assignment
        --iRef;             // Only side effect utilized. iRef refers to an Integer
        // object with the value 10. (expression statement)
        k = ++iRef + --iRef;// ((++iRef) + (--iRef)). k gets the value 21 and
        // iRef refers to an Integer object with the value 10.\

        // (2) Postfix order: increment/decrement operand after use.
        long j = 10;
        long n = j++ + j--; // ((j++) + (j--)). n gets the value 21L and j becomes 10L.
        j++;                // Only side effect utilized. j is 11L. (expression statement)

//        k = ((++i) + (--i))          Operands are evaluated from left to right.
//                k = ( 11   + (--i))          Side effect: i += 1, i gets the value 11.
//        k = ( 11   +  10)            Side effect: i -= 1, i gets the value 10.
//        k = 21

    }
}
