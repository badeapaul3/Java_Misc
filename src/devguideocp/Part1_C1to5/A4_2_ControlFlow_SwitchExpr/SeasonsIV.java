package devguideocp.Part1_C1to5.A4_2_ControlFlow_SwitchExpr;

/**
 * @author hatzp
 **/
public class SeasonsIV {
    enum Season { WINTER, SPRING, SUMMER, FALL }                // (1)

    public static void main(String[] args) {
        int monthNumber = 11;
        Season season = switch(monthNumber) {                     // (2)
            case 12, 1, 2 -> {                                      // (3)
                System.out.println("Snow in the winter.");
                yield Season.WINTER;                                  // (4)
            }
            case 3, 4, 5 -> {                                       // (5)
                System.out.println("Green grass in the spring.");
                yield Season.SPRING;                                  // (6)
            }
            case 6, 7, 8 -> {                                       // (7)
                System.out.println("Sunshine in the summer.");
                yield Season.SUMMER;                                  // (8)
            }
            case 9, 10, 11 -> {                                     // (9)
                System.out.println("Yellow leaves in the fall.");
                yield Season.FALL;                                    // (10)
            }
            //default will make the switch expression exhaustive
            default ->                                              // (11)
                    throw new IllegalArgumentException(monthNumber + " not a valid month.");
        };                                                        // (12)
        System.out.println(season);
    }
}
