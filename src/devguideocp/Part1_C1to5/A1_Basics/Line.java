package devguideocp.Part1_C1to5.A1_Basics;

/**
 * @author hatzp
 **/
public class Line {

    // Instance variables:                                                    (1)
    private Point2D endPoint1;
    private Point2D endPoint2;

    // Constructor:
    public Line(Point2D p1, Point2D p2) {
        endPoint1 = p1;
        endPoint2 = p2;
    }

    // Methods:
    public Point2D getEndPoint1() { return endPoint1; }
    public Point2D getEndPoint2() { return endPoint2; }
    public void setEndPoint1(Point2D p1) { endPoint1 = p1; }
    public void setEndPoint2(Point2D p2) { endPoint2 = p2; }
    public double length() {                                               // (2)
        return Point2D.distance(endPoint1, endPoint2);
    }
    public String toString()  {
        return "Line[" + endPoint1 + "," + endPoint2 + "]";
    }

    public static void main(String[] args) {
        Line line1 = new Line(new Point2D(5,6), new Point2D(7,8));
        System.out.println(line1.toString());               // Line[(5,6),(7,8)]
        line1.setEndPoint1(new Point2D(11, 12));
        line1.setEndPoint2(new Point2D(13, 14));
        System.out.println(line1.toString());               // Line[(11,12),(13,14)]
        System.out.println("Length: " + line1.length());    // Length: 2.8284271247461903
    }
}