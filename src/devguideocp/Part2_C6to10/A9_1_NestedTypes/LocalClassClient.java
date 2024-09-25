package devguideocp.Part2_C6to10.A9_1_NestedTypes;

/**
 * @author hatzp
 **/

interface IDrawable {                     // (1)
    void draw();
}
//_____________________________________________________________________________
class Shape implements IDrawable {        // (2)
    @Override
    public void draw() { System.out.println("Drawing a Shape."); }
}
//_____________________________________________________________________________
class Painter {                           // (3) Top-level Class
    public Shape createCircle(final double radius) { // (4) Non-static Method
        class Circle extends Shape {          // (5) Non-static local class
            @Override
            public void draw() {
                System.out.println("Drawing a Circle of radius: " + radius); // (6)
            }
        }

        return new Circle();                  // (7) Passed enclosing object reference
    }

    public Shape createCircle2(final double radius) { // (4) Non-static Method
        class Circle extends Shape {          // (5) Non-static local class
            @Override
            public void draw() {
                System.out.println("Drawing a Circle of radius: " + radius); // (6)
            }
        }

        return new Circle();                  // (7) Passed enclosing object reference
    }

    public static IDrawable createGraph() { // (8) Static Method
        class Graph implements IDrawable {    // (9) Static local class
            @Override
            public void draw() { System.out.println("Drawing a Graph."); }
        }
        return new Graph();                   // (10) Object of static local class
    }
}
//_____________________________________________________________________________
public class LocalClassClient {
    public static void main(String[] args) {
        IDrawable[] drawables = {             // (11)
                new Painter().createCircle(5),    // (12) Object of non-static local class
                new Painter().createCircle2(5),    // (12) Object of non-static local class
                Painter.createGraph(),            // (13) Object of static local class
                new Painter().createGraph()       // (14) Object of static local class
        };
        for (IDrawable aDrawable : drawables) // (15)
            aDrawable.draw();

        System.out.println("Local Class Names:");
        System.out.println(drawables[0].getClass().getName());   // (16)
        System.out.println(drawables[1].getClass().getName());   // (16) cause multiple local class
        // declarations with the same name can be defined in the methods of the enclosing class
        // a numbering scheme ($i) is used to generate distinct class file names.
        System.out.println(drawables[2].getClass().getName());   // (17)
    }
}
