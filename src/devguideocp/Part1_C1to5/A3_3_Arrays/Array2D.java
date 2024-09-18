package devguideocp.Part1_C1to5.A3_3_Arrays;

/**
 * @author hatzp
 **/
public class Array2D {
//    int[][] mXnArray;      // two-dimensional array
//    int[]   mXnArray[];    // two-dimensional array
//    int     mXnArray[][];  // two-dimensional array

    public static void main(String[] args) {
        //int[][] mXnArray = new int[4][5];

        double[][] identityMatrix = {
                {1.0, 0.0, 0.0, 0.0 }, // 1. row
                {0.0, 1.0, 0.0, 0.0 }, // 2. row
                {0.0, 0.0, 1.0, 0.0 }, // 3. row
                {0.0, 0.0, 0.0, 1.0 }  // 4. row
        }; // 4 x 4 floating-point matrix


        // Declare and construct the M X N matrix.
        int[][] mXnArray = {                                           // (1)
                {16,  7, 12}, // 1. row
                { 9, 20, 18}, // 2. row
                {14, 11,  5}, // 3. row
                { 8,  5, 10}  // 4. row
        }; // 4 x 3 int matrix

        // Find the minimum value in an M X N matrix:
        int min = mXnArray[0][0];
        //for (int[] ints : mXnArray) //enhanced
        for (int i = 0; i < mXnArray.length; ++i)                      // (2)
            // Find min in mXnArray[i], in the row given by index i:
            for (int j = 0; j < mXnArray[i].length; ++j)                 // (3)
                min = Math.min(min, mXnArray[i][j]);

        System.out.println("Minimum value: " + min);


    }


}
