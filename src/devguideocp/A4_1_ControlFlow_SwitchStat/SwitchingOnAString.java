package devguideocp.A4_1_ControlFlow_SwitchStat;

/**
 * @author hatzp
 **/
public class SwitchingOnAString {
    public static final String MEDIUM = "Medium";       // (1)
    public static final String HOT = "Hot";             // (2a)
    //public static       String HOT = "Hot";             // (2b) Not OK as case label
//public static final String HOT = new String("Hot"); // (2c) Not OK as case label
    public static void main(String[] args) {
        String spiceLevel = "Medium_Hot";
        String mildString = "Mild";
        switch (spiceLevel) {
            case "Mild",                                                        // (3)
                    MEDIUM + "_" + HOT -> System.out.println("Enjoy your meal!"); // (4)
            case HOT                 -> System.out.println("Have fun!");        // (5)
            case "Suicide"           -> System.out.println("Good luck!");       // (6)
            default                  -> System.out.println("You being funny?");
        }

        switch (mildString) {
            case "Mild",                                                        // (3)
                    MEDIUM + "_" + HOT -> System.out.println("Enjoy your mild meal!"); // (4)
            case HOT                 -> System.out.println("Have fun!");        // (5)
            case "Suicide"           -> System.out.println("Good luck!");       // (6)
            default                  -> System.out.println("You being funny?");
        }
    }
}
