package devguideocp.Part1_C1to5.A5_9_OOP_Polymorphism;

/**
 * @author hatzp
 **/

// File: PolymorphRefs.java
interface IDrawable {                                                     // (1)
    void draw();
}
//_______________________________________________________________________________
abstract class Shape implements IDrawable {
    abstract public boolean area();
}
//_______________________________________________________________________________
class Circle extends Shape {
    @Override public void draw() { System.out.println("Drawing a Circle."); }
    @Override public boolean area() {
        System.out.println("Computing area of a Circle.");
        return false;
    }
}
//_______________________________________________________________________________
class Rectangle extends Shape {
    @Override public void draw() { System.out.println("Drawing a Rectangle."); }
    @Override public boolean area() {
        System.out.println("Computing area of a Rectangle.");
        return false;
    }
}
//_______________________________________________________________________________
class Square extends Rectangle {
    @Override public void draw() { System.out.println("Drawing a Square."); }
    @Override public boolean area() {
        System.out.println("Computing area of a Square.");
        return false;
    }
}
//_______________________________________________________________________________
class Graph implements IDrawable {
    @Override public void draw() { System.out.println("Drawing a Graph."); }
}
//_______________________________________________________________________________
public class PolymorphRefs {
    public static void main(String[] args) {

        IDrawable d1 = new Rectangle();
        System.out.println(d1 instanceof IDrawable); // true. Rectangle is an IDrawable.
        System.out.println(d1 instanceof Shape);     // true. Rectangle is a Shape.
        System.out.println(d1 instanceof Rectangle); // true. Rectangle is a Rectangle.
        System.out.println(d1 instanceof Circle);    // false. Rectangle is not a Circle.
        System.out.println(d1 instanceof Graph);     // false. Rectangle is not a Graph.
        // System.out.println(d1 instanceof String); // Unrelated. Compile-time error.

        System.out.println("");

        IDrawable d2 = new Square();  // Subtype object denoted by supertype reference.
        //d2.area();        // Method not defined for type IDrawable. Compile-time error!
        ((Square) d2).area();         // Prints "Computing area of a Square."
        ((Shape) d2).area();          // Prints "Computing area of a Square."


        System.out.println("@@@");
        Shape d4 = (Shape) d2;
        System.out.println(d4.area());
        Rectangle d5 = (Rectangle) d2;
        System.out.println(d5.area());
        System.out.println("@@@");



        IDrawable d3 = new Graph();       // No compile-time error.
      //  ((Shape) d3).area();              // Throws a ClassCastException!


        if (d2 instanceof Shape shape) {           // true
            shape.area();                            // Prints "Computing area of a Square."
        } else {
            System.out.println(d2.getClass().getName() + " is not a Shape." );
        }

        if (d3 instanceof Shape shape) {           // false
            shape.area();
        } else {
            System.out.println(d3.getClass().getName() +
                    " is not a Shape." ); // Prints "Graph is not a Shape."
        }

        System.out.println("");

        IDrawable[] drawables
                = {new Square(), new Circle(), new Rectangle(), new Graph()};     // (2)

        System.out.println("Draw drawables:");
        for (IDrawable drawable : drawables) {                                // (3)
            drawable.draw();
        }

        System.out.println("Only draw shapes:");
        for (IDrawable drawable : drawables) {                                // (4)
            if (drawable instanceof Shape) {                                    // (5)
                drawable.draw();
            }
        }

        System.out.println("Only compute area of shapes:");
        for (IDrawable drawable : drawables) {                                // (6)
            if (drawable instanceof Shape shape) {                              // (7)
                shape.area();                                                     // (8)
            }
        }








    }
}
