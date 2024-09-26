package devguideocp.Part2_C6to10.A10_1_ObjLifetime;

/**
 * @author hatzp
 **/

class MatrixData {

    static final int ROWS = 12, COLUMNS = 10;          // (1)
    static long[][] matrix = new long[ROWS][COLUMNS];  // (2)
    // ...
    static {                                           // (3) Static initializer
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = 2*i + j;
    }
    // ...
}
