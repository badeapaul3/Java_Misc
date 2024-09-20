package devguideocp.Part2_C6to10.A7_3_Try_Resources;

/**
 * @author hatzp
 **/
public class GizmoTest {
    public static void main(String[] args) {
        try (var myGizmo = new Gizmo()) {             // (4)
            myGizmo.compute();
        } catch (Exception ex) {                      // (5)
            System.out.println("Printing stack trace in catch " +
                    "clause of main():");
            ex.printStackTrace();
        } finally {
            System.out.println("Finally: Done in main()");
        }
    }
}