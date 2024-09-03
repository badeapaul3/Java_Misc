package devguideocp.A3_2_Declarations;

/**
 * @author hatzp
 **/
public class StaticTest {
    public static void main(String[] args) {
        Light.counter++;                   // (9) Using class name
        Light dimLight = null;
        dimLight.counter++;                // (10) Using object reference

        System.out.print("Light.counter == dimLight.counter: ");
        System.out.println(Light.counter == dimLight.counter);//(11) Aliases for static field

        System.out.println("Calling static method using class name:");
        Light.printStatic();               // (12) Using class name
        System.out.println("Calling static method using object reference:");
        dimLight.printStatic();            // (13) Using object reference
    }
}
