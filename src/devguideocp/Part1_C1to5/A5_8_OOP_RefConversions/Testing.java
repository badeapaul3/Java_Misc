package devguideocp.Part1_C1to5.A5_8_OOP_RefConversions;

/**
 * @author hatzp
 **/
public class Testing{
    public static void main(String[] args) {

        IStack stack2 = new SafeStack(20);
        if (stack2 instanceof SafeStack safestack) {
            System.out.println(safestack.isFull());   // Pattern variable in scope.
        } else {

            //System.out.println(safestack.isEmpty());  // Compile-time error!
        }

        IStack stack = new SafeStack(20);
        if (!(stack instanceof SafeStack safestack)) {
            System.out.println("No safestack here");

           return;                                     // (1) Does not complete normally.
        } else {
            System.out.println(safestack.isFull());     // Pattern variable in scope.
        }
        System.out.println(safestack.isEmpty());      // Pattern variable still in scope.





    }
}
