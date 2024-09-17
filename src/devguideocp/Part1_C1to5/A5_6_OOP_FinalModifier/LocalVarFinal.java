package devguideocp.Part1_C1to5.A5_6_OOP_FinalModifier;

/**
 * @author hatzp
 **/
public class LocalVarFinal {
    public static void main(String[] args) {
        int n = 5;
        final int k;            // Declaration: blank final local variable
        if (n >= 4) {           // (1) Value of conditional expression not evaluated
            k = 6;                // (2) Conditional assignment: k is definitely unassigned
        }
        //k = 12;                 // (3) Assignment: k is not definitely unassigned!
        //System.out.println(k);  // (4) Access: k is definitely assigned


        //solution:
        int x = 5;
        final int o;            // Declaration: blank final local variable
        if (x >= 4) {           // (1) Value of conditional expression not evaluated
            o = 6;                // (2) Conditional assignment: k is definitely unassigned
        } else {
            o = 12;               // (3) Conditional assignment: k is definitely unassigned
        }
        System.out.println(o);  // (4) Access: k is definitely assigned
    }
}
