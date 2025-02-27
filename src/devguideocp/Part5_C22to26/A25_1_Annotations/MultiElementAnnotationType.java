package devguideocp.Part5_C22to26.A25_1_Annotations;

public @interface MultiElementAnnotationType {

    public enum Priority { LOW, NORMAL, HIGH };

    public int certificationLevel()     default 1;                        // int
    String date()                       default "2021-01-11";   // String
    Class<? extends PrettyPrinter> pp()
            default AdvancedPrettyPrinter.class;          // type Class
    Priority priorityLevel()               default Priority.NORMAL;       // enum Priority
    Tag annotate()                         default @Tag;                  // Annotation type
    int[] value()                          default {10, 20, 30};          // Array, int[]
}
// Auxiliary classes:
class PrettyPrinter {}
class AdvancedPrettyPrinter extends PrettyPrinter {}


//@interface ProblematicAnnotationType {
//  StringBuilder message();              // Illegal return type.
//  int[][] voting();                     // Only one-dimensional array allowed.
//  String value;                         // Missing parentheses.
//  private Thread.State state();         // Only public can be specified.
//}

//public @interface MusicMeta {             // (1) Contained annotation type
//  String value();
//}
//public @interface ArtistMeta {            // (2) Containing annotation type
//  MusicMeta value();                      // Annotation type from (1).
//}

//@interface Refactor {
//  int id()          default (int) (Math.random() * 10);// Not a const expression.
//  String value()    default null;                      // Cannot be null.
//  String deadline() default new String("2021-01-11");  // Not a const expression.
//  String[] team()   default new String[] {"VJ", "PT"}; // Not a const expression.
//}