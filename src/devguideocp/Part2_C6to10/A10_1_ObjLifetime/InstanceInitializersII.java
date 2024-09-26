package devguideocp.Part2_C6to10.A10_1_ObjLifetime;

/**
 * @author hatzp
 **/


public class InstanceInitializersII {

    { //Instance initializer with forward references.   (1)
        i = j = 10;                                    // (2) Permitted.
        int result = this.i * this.j;                  // (3) i is 10, j is 10.
        System.out.println(this.i);                    // (4) 10
        System.out.println(this.j);                    // (5) 10
        System.out.println(this.k);                    // (6) 50
    }
    // Instance field declarations.
    int i;                 // (7) Field declaration without initializer expression.
    int j = 100;           // (8) Field declaration with initializer expression.
    final int k = 50;      // (9) Final instance field with constant expression.

    public static void main(String[] args) {
        InstanceInitializersII test = new InstanceInitializersII();

    }
}
