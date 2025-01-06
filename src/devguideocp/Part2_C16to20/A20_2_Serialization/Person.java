package devguideocp.Part2_C16to20.A20_2_Serialization;

import java.io.Serializable;

// A superclass
//public class Person implements Serializable {                  // (1a)
    public class Person  {                                       // (1b)
    private String name;

    public Person() {                                            // (2)
        System.out.println("No-argument constructor executed.");
    }
    public Person(String name) { this.name = name; }

    public String getName() { return name; }
}
