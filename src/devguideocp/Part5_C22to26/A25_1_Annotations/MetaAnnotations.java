package devguideocp.Part5_C22to26.A25_1_Annotations;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author hatzp
 **/
public class MetaAnnotations {


//The purpose of a marker annotation type is to indicate the presence of a feature
//    @Retention(value = RetentionPolicy.RUNTIME)   // Retention: In source code,
//    // in class file, at runtime.
//    public @interface MusicMeta {}
//
//
//    @Retention(value = RetentionPolicy.SOURCE) // Retention: Only in the source code.
//    public @interface Override {}


    @Target(ElementType.CONSTRUCTOR)
    @interface Tag {}
    class Item {
        @Tag public Item() {}       // Declaration context. Annotates constructor Item.
    }


    @Target({ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @interface Tag2 {}
    double circleArea(@Tag2 double r) { // Declaration context. Annotates parameter r.
        return 5.0;
    }




    @Target(ElementType.TYPE_USE)
    @interface Tag3 {}
    java.lang. @Tag3 Integer iRef1 = 100;        // (1) Type context. Annotates Integer.
    @Tag3 Integer iRef2 = 100;                   // (2) Type context. Annotates Integer.
   // @Tag3 java.lang.Integer iRef3 = 100;        // (3) Declaration context.Compile-time error!
    @Tag3 int compute() { return (@Tag3 int) 3.14; }// (4) Type context is int type.
  //  @Tag3 void compute(int i) {}                   // (5) No return type specified.
    //     Compile-time error!


    @Target(ElementType.FIELD)
    @interface Tag4 {}
   // java.lang. @Tag4 Integer iRef1 = 100; // (1a) Type context. Compile-time error!
    @Tag4 Integer iRef3 = 100;              // (2a) Declaration context. Annotates iRef2.
    @Tag4 java.lang.Integer iRef4 = 100;   // (3a) Declaration context. Annotates iRef3.


    @Target({ElementType.TYPE_USE, ElementType.FIELD})
    @interface Tag5 {}
    java.lang. @Tag5 Integer iRef15 = 100; // (1b) Type context. Annotates Integer.
    @Tag5 Integer iRef25 = 100;            // (2b) Declaration and type context.
    @Tag5 java.lang.Integer iRef35 = 100;   // (3b) Declaration context. Annotates iRef3.



    @interface Tag6 {}               // No target specified.

//    @Tag6 class Box<@Tag6 E> {        // Class declaration: OK.
//        // Type parameter: Compile-time error!
//        <@Tag6 T> void doIt(T t) {}    // Type parameter: Compile-time error!
//        void doTask() throws @Tag Exception {}     // Type context: Compile-time error!
//        int iTod(double d) { return (@Tag6 int) d; }// Type context: Compile-time error!
        @Tag6 boolean flag;                         // Field declaration. OK.



@Target({})                                 // (1) Empty target.
@interface Exclusive {}

@interface ExtraExclusive {
    Exclusive value() default @Exclusive;     // (2) Annotation as element type.
}

//@Exclusive class Titanium {}                // (3) Compile-time error!
@ExtraExclusive class Krypton {}            // (4) OK.



    @Retention(RUNTIME)
    @Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
    public @interface MusicMeta {}

    @MusicMeta public class Composition {         // (1) On class
        @MusicMeta private String description;      // (2) On field
        @MusicMeta public void play() {             // (3) On method
//  @MusicMeta int volume;                    // (4) Compile-time error!
        }
    }



    @Retention(RUNTIME)
    @Inherited
    public @interface Playable {}

    @MusicMeta
    @Playable
    public class Composition2 {}

    public class Song extends Composition2 {}




    @Retention(RUNTIME)
    @Target(ElementType.TYPE)
    @Documented                             // (1)
    public @interface Pending {}


    @Retention(RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Verified {}          // (2)

    @Verified
    public class Gizmo {}                   // (3)



    @Documented
    @Retention(RUNTIME)
    @Target(ANNOTATION_TYPE)
    public @interface Repeatable {
        Class<? extends Annotation> value();  // Indicates the containing annot type
    }


    enum Size {S, M, L, XL}
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Choices.class)    // @Repeatable specifies the container
            // annotation type Choices.
    @interface Choice {
        String color();
        Size size() default Size.L;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Choices {
        Choice[] value();             // Return value is an array of Choice.
    }

//    @Choice(color="Green", size=Size.S)                    // Compile-time error!
//    @Choice(color="Yellow", size=Size.XL)                  // Compile-time error!
//    @Choice(color="Red", size=Size.M)                      // Compile-time error!
//    @Choice(color="White")                                 // Compile-time error!
//    class Item {}

    @Choices(value={@Choice(size=Size.S, color="Green"),
            @Choice(size=Size.XL, color="Yellow"),
            @Choice(size=Size.M, color="Red"),
            @Choice(size=Size.L, color="White")})
    class Item2 {}

//A Containing Annotation Type (CAT) for a Repeatable Annotation Type (RAT) must satisfy the following conditions:
//
//RAT must specify CAT.class as the value of the single element of its meta-annotation @Repeatable.
//
//CAT must declare a value() annotation type element whose type is RAT[].
//
//Any additional annotation type elements declared in CAT must have a default value.
































}

