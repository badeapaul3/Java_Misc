package devguideocp.A5_2_OOP_Inheritance2;

/**
 * @author hatzp
 **/
// File: Client2.java
// Exceptions
class InvalidHoursException extends Exception {}
class NegativeHoursException extends InvalidHoursException {}
class ZeroHoursException extends InvalidHoursException {}

class Light {

    protected String lightType = "Generic Light";   // (1) Instance field

    protected double energyCost(int noOfHours)      // (2) Instance method
            throws InvalidHoursException {
        System.out.print(">> Light.energyCost(int): ");
        if (noOfHours < 0)
            throw new NegativeHoursException();
        double cost = 00.20 * noOfHours;
        System.out.println("Energy cost for " + lightType + ": " + cost);
        return cost;
    }

    public Light makeInstance() {                   // (3) Instance method
        System.out.print(">> Light.makeInstance(): ");
        return new Light();
    }

    public void showSign() {                        // (4) Instance method
        System.out.print(">> Light.showSign(): ");
        System.out.println("Let there be light!");
    }

    public static void printLightType() {           // (5) Static method
        System.out.print(">> Static Light.printLightType(): ");
        System.out.println("Generic Light");
    }
}
//______________________________________________________________________________
class TubeLight extends Light {

    public static String lightType = "Tube Light";  // (6) Hiding field at (1).

    @Override
    public double energyCost(final int noOfHours)   // (7) Overriding instance
            throws ZeroHoursException {                 //     method at (2).
        System.out.print(">> TubeLight.energyCost(int): ");
        if (noOfHours == 0)
            throw new ZeroHoursException();
        double cost = 00.10 * noOfHours;
        System.out.println("Energy cost for " + lightType + ": " + cost);
        return cost;
    }

    public double energyCost() {          // (8) Overloading method at (7).
        System.out.print(">> TubeLight.energyCost(): ");
        double flatrate = 20.00;
        System.out.println("Energy cost for " + lightType + ": " + flatrate);
        return flatrate;
    }

    @Override
    public TubeLight makeInstance() {     // (9) Overriding instance method at (3).
        System.out.print(">> TubeLight.makeInstance(): ");
        return new TubeLight();
    }

    public static void printLightType() { // (10) Hiding static method at (5).
        System.out.print(">> Static TubeLight.printLightType(): ");
        System.out.println(lightType);
    }
}
//______________________________________________________________________________

public class Client2 {
    public static void main(String[] args)          // (11)
            throws InvalidHoursException {

        TubeLight tubeLight = new TubeLight();        // (12)
        Light     light1    = tubeLight;              // (13) Aliases.
        Light     light2    = new Light();            // (14)

        System.out.println("Invoke overridden instance method:");
        tubeLight.energyCost(50);                     // (15) Invokes method at (7).
        light1.energyCost(50);                        // (16) Invokes method at (7). // at runtime it is TubeLight
        light2.energyCost(50);                        // (17) Invokes method at (2).

        System.out.println(
                "\nInvoke overridden instance method with covariant return:");
        System.out.println(
                light1.makeInstance().getClass());        // (extra) invokes method at 9 as it is TubeLight at runtime
        System.out.println(
                light2.makeInstance().getClass());        // (18) Invokes method at (3).
        System.out.println(
                tubeLight.makeInstance().getClass());     // (19) Invokes method at (9).


                //When a field of an object is accessed using a reference, it is the declared type of the reference,
                // not the type of the current object denoted by the reference, that determines which field will actually be accessed.
                //in field hiding only name matters, not the type or static context, unlike methods
        System.out.println("\nAccess hidden field:");
        System.out.println(tubeLight.lightType);      // (20) Accesses field at (6).
        System.out.println(light1.lightType);         // (21) Accesses field at (1). THE DECLARED TYPE OF THE REFERENCE - (Light) in this case
        System.out.println(light2.lightType);         // (22) Accesses field at (1).

                //a static method in a subclass can hide a static method from the superclass
                //Calls to static methods are bound at compile time as opposed to runtime for calls to overridden instance methods,
                // and therefore do not exhibit polymorphic behavior implied by calls to overridden instance methods

        System.out.println("\nInvoke hidden static method:");
        tubeLight.printLightType();                   // (23) Invokes method at (10).
        light1.printLightType();                      // (24) Invokes method at (5).    ref Light declared but object TubeLight
        light2.printLightType();                      // (25) Invokes method at (5).

        System.out.println("\nInvoke overloaded method:");
        tubeLight.energyCost();                       // (26) Invokes method at (8).
    }
}
//In summary, a subclass can do any of the following:
//
//Access inherited members using their simple names
//
//Override a non-final instance method with the same signature as in the superclass
//
//Overload a static or instance method with the same name as in the superclass
//
//Hide a static non-final method with the same signature as in the superclass
//
//Hide a static or instance field with the same name as in the superclass
//
//Declare new members that are not in the superclass
//
//Declare constructors that can invoke constructors in the superclass implicitly,
// or use the super() construct with the appropriate arguments to invoke them explicitly