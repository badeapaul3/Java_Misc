package devguideocp.A1_Basics;

/**
 * @author hatzp
 **/
public class Point3D extends Point2D {           // (1) Uses extends clause

    // Static variable:                                                   (2)
    private static String info = "A 3D point represented by (x,y,z)-coordinates.";

    // Instance variable:                                                 (3)
    private int z;

    // Constructor:                                                       (4)
    public Point3D(int xCoord, int yCoord, int zCoord) {
        super(xCoord, yCoord);                                           // (5)
        z = zCoord;
    }

    // Instance methods:                                                  (6)
    public int  getZ()           { return z; }
    public void setZ(int zCoord) { z = zCoord; }
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")"; // Format: (x,y,z)
    }

    // Static methods:                                                    (7)
    public static double distance(Point3D p1, Point3D p2) {
        int xDiff = p1.getX() - p2.getX();
        int yDiff = p1.getY() - p2.getY();
        int zDiff = p1.getZ() - p2.getZ();
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff + zDiff*zDiff);
    }
    public static void showInfo() { System.out.println(info); }

    public static void main(String[] args) {
        Point3D p3A = new Point3D(10, 20, 30);
        System.out.println(p3A.toString());               // (10,20,30)       (Point3D)
        System.out.println("x: " + p3A.getX());           // x: 10            (Point2D)
        System.out.println("y: " + p3A.getY());           // y: 20            (Point2D)
        System.out.println("z: " + p3A.getZ());           // z: 30            (Point3D)

        p3A.setX(-10); p3A.setY(-20); p3A.setZ(-30);
        System.out.println(p3A.toString());               // (-10,-20,-30)    (Point3D)

        Point3D p3B = new Point3D(30, 20, 10);
        System.out.println(p3B.toString());               // (30,20,10)       (Point3D)
        System.out.println(Point3D.distance(p3A, p3B));   // 69.2820323027551 (Point3D)
        Point3D.showInfo(); // A 3D point represented by (x,y,z)-coordinates. (Point3D)
    }
}
