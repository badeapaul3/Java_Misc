package devguideocp.Part1_C1to5.A3_2_Declarations;

/**
 * @author hatzp
 **/
public class Light {
    // Static field:
    static int counter;                  // (1) No initializer expression

    // Static method:
    public static void printStatic() {
        Light myLight = null;
        System.out.printf("%s, %s, %s%n", counter, Light.counter, myLight.counter); // (2)
        long counter = 10;                 // (3) Local variable shadows static field
        System.out.println("Local counter: " + counter);       // (4) Local variable accessed
        System.out.println("Static counter: " + Light.counter);// (5) Static field accessed

//  System.out.println(this.counter);         // (6) Cannot use this in static context
//  printNonStatic();                  // (7) Cannot call non-static method
    }

    // Non-static method:
    public void printNonStatic() {
        System.out.printf("%s, %s, %s%n", counter, this.counter, Light.counter);     // (8)
    }
}
