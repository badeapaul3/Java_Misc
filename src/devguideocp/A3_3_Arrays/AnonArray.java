package devguideocp.A3_3_Arrays;

/**
 * @author hatzp
 **/
public class AnonArray {

    public static void main(String[] args) {
        System.out.println("Minimum value: " +
                findMinimum(new int[] {3, 5, 2, 8, 6}));                   // (1)
    }

    public static int findMinimum(int[] dataSeq) {                   // (2)
        // Assume the array has at least one element.
        int min = dataSeq[0];
        for (int i = 1; i < dataSeq.length; ++i)
            if (dataSeq[i] < min)
                min = dataSeq[i];
        return min;
    }
}
