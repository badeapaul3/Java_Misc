package devguideocp.Part5_C22to26.A25_1_Annotations;

import java.lang.annotation.Target;                // (1)
import java.lang.annotation.ElementType;           // (2)
import java.lang.annotation.Retention;             // (3)
import java.lang.annotation.RetentionPolicy;       // (4)

@Target({ElementType.TYPE, ElementType.METHOD})    // (5) Meta-annotation
@Retention(RetentionPolicy.RUNTIME)                // (6) Meta-annotation
public @interface TaskInfo {                       // (7)
    String taskDesc();                               // (8) Annotation type element
    String[] assignedTo();                           // (9) Annotation type element
    TaskPriority priority() default TaskPriority.NORMAL;  // (10) Annot type element

    public enum TaskPriority { LOW, NORMAL, HIGH };       // (11) Nested enum type

    public static final String LOG_FILE = "./logs/Tasks.log"; // (12) const decl.
}