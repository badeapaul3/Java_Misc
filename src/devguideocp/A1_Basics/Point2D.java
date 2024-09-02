package devguideocp.A1_Basics;

/**
 * @author hatzp
 **/
public class Point2D {             // Class name
    // Class Member Declarations

    // Fields:                                                         (1)
    private int x;     // The x-coordinate
    private int y;     // The y-coordinate

    // Static variable:                                                 (1)
    private static String info = "A 2D point represented by (x,y)-coordinates.";

    // Constructor:                                                    (2)
    public Point2D(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    // Methods:                                                        (3)
    public int  getX()           { return x; }
    public int  getY()           { return y; }
    public void setX(int xCoord) { x = xCoord; }
    public void setY(int yCoord) { y = yCoord; }
    public String toString() { return "(" + x + "," + y + ")"; } // Format: (x,y)

    // Static methods:                                                  (5)
    public static double distance(Point2D p1, Point2D p2) {
        int xDiff = p1.x - p2.x;
        int yDiff = p1.y - p2.y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
    public static void showInfo() { System.out.println(info); }

    public static void main(String[] args) {
        Point2D point = new Point2D(-1, -4);   // Creates a point with coordinates (-1,-4)
        point.setX(-2);                        // (1) The x field is set to the value -2
        int yCoord = point.getY();
        System.out.println(yCoord);// (2) Returns the value -4 of the y field
        System.out.println(point.toString());  // (3) Prints: (-2,-4)
        //point.distanceFromOrigin();            // (4) Compile-time error: No such method.
    }
}
