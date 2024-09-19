package devguideocp.Part2_C6to10.A7_2_Exceptions_Throw;

/**
 * @author hatzp
 **/

// File: Average10.java
public class Average10 {
    public static void main(String[] args) {
        try {                                                      // (1)
            int sum = Integer.parseInt(args[0]);                     // (2)
            int numOfValues = Integer.parseInt(args[1]);             // (3)
            printAverage(sum, numOfValues);                          // (4)
        } catch (ArrayIndexOutOfBoundsException |                  // (5) multi-catch
                 NumberFormatException e) {
            System.out.println(e);
            System.out.println("Usage: java Average10 <sum of values> <no. of values>");
        } catch (IntegerDivisionByZero e) {                     // (6) uni-catch
            e.printStackTrace();
            System.out.println("Exception handled in main().");
        } finally {                                                // (7)
            System.out.println("Finally done in main().");
        }
        System.out.println("Exit main().");                        // (8)
    }

    public static void printAverage(int totalSum, int totalCount)
            throws IntegerDivisionByZero {
        int average = computeAverage(totalSum, totalCount);
        System.out.println("Average = " +
                totalSum + " / " + totalCount + " = " + average);
        System.out.println("Exit printAverage().");
    }

    public static int computeAverage(int sum, int count)
            throws IntegerDivisionByZero {
        System.out.println("Computing average.");
        if (count == 0)
            throw new IntegerDivisionByZero();
        return sum/count;
    }
}
