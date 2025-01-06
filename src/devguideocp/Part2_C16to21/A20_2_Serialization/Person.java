package devguideocp.Part2_C16to21.A20_2_Serialization;

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
