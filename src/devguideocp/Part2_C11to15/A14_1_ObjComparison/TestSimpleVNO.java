package devguideocp.Part2_C11to15.A14_1_ObjComparison;

/**
 * @author hatzp
 **/
import static java.lang.System.out;

public class TestSimpleVNO {
    public static void main(String[] args) {
        // Print name of version number class:
        out.println(SimpleVNO.class);

        // Three individual version numbers.
        SimpleVNO svno1 = new SimpleVNO(9,1,1);                        // (1)
        SimpleVNO svno2 = new SimpleVNO(9,1,1);                        // (2)
        SimpleVNO svno3 = new SimpleVNO(6,6,6);                        // (3)

        out.printf ("  svno1: %s, svno2: %s, svno3: %s%n", svno1, svno2, svno3);
        out.println("Test object reference equality:");                // (4)
        out.println("  svno1 == svno2:      " + (svno1 == svno2));     // (5)
        out.println("  svno1 == svno3:      " + (svno1 == svno3));     // (6)
        out.println("Test object value equality:");
        out.println("  svno1.equals(svno2): " + svno1.equals(svno2));  // (7)
        out.println("  svno1.equals(svno3): " + svno1.equals(svno3));  // (8)

        out.println("My test for ref and obj re f equality");

        UsableVNO svno4 = new UsableVNO();
        UsableVNO svno5 = new UsableVNO();
        Object obj2 = svno5;

        out.println(svno4.equals(svno5));
        out.println(svno4.equals(obj2));

        out.println("My 2nd test for ref and obj re f equality");

        Object obj1 = svno2;
        out.println(svno1.equals(svno2));
        out.println(svno1.equals(obj1));
    }
}