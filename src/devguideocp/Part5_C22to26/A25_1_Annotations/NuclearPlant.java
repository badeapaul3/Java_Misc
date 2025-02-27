package devguideocp.Part5_C22to26.A25_1_Annotations;

/**
 * @author hatzp
 **/






//normal annotation
@TaskInfo(                                                  // Normal annotation
        taskDesc = "Class for monitoring nuclear reactor activity",       // Required
        assignedTo = {"Tom", "Dick", "Harriet"},                          // Required
        priority = TaskInfo.TaskPriority.HIGH                             // Optional
)
public class NuclearPlant {
}

//@TaskInfo(                                                           // Normal
//annotation
//   taskDesc = "Class for monitoring nuclear reactor activity",       // Required
//   assignedTo = {"Tom", "Dick", "Harriet"}                           // Required
//   )
//TaskInfo.TaskPriority.NORMAL of the optional annotation element priority is implied

//@TaskInfo(
//    priority = TaskInfo.TaskPriority.LOW,
//    taskDesc = "Start nuclear reactor",
//    assignedTo = "Harriet"                // Single-element array-valued element
//    )
//a single-element array-valued element-value pair


@Tag class Gizmo {}                     // Marker annotation

@Tag() class Gizmo2 {}                   // Normal annotation


// Annotation type declaration where all elements have default values.
@interface Option {
    Color color()  default Color.WHITE;   // Optional annotation element
    Size size()    default Size.M;        // Optional annotation element
    enum Color {RED, WHITE, BLUE}
    enum Size  {S, M, L, XL}
}

@Option                                                    // Marker annotation
class Item {}

@Option(color = Option.Color.WHITE, size = Option.Size.M)  // Normal annotation
class Item2 {}


// Single-element annotation type
@interface Author {
    String value();                            // Single annotation type element
}

@Author("Tom")                               // Single-element annotation
class Connection {}


@Author(value = "Tom")                       // Normal annotation
class Connection2 {}

//Annotation type declaration with a value() element and other elements with default values.
@interface ExtraOption {
    int value();                               // Required annotation element
    Color color()  default Color.WHITE;        // Optional annotation element
    Size size()    default Size.M;             // Optional annotation element
    enum Color {RED, WHITE, BLUE}
    enum Size  {S, M, L, XL}
}

@ExtraOption(10)                                   // Single-element annotation
class ItemV2 {}

@ExtraOption(value=10, color=ExtraOption.Color.WHITE,      // Normal annotation
        size=ExtraOption.Size.M)
class ItemV3 {}


// Array-valued single-element annotation type declaration:
@interface Problems {
    String[] value();                                // Array-type value() element
}
@Problems({"Code smell", "Exception not caught"})  // Array-valued single-element
class ItemV4 {}                                    // annotation

@Problems(value = {"Code smell", "Exception not caught"})  // Normal annotation
class ItemV5 {}

@Problems("Code smell")   // Single-element array-valued single-element annotation
class ItemV6 {}

@Problems({"Code smell"}) // Single-element array-valued single-element annotation
class ItemV7 {}

@Problems(value = "Code smell")      // Normal annotation
class ItemV8 {}

@Problems(value = {"Code smell"})    // Normal annotation
class ItemV9 {}


