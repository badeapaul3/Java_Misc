package devguideocp.Part2_C6to10.A7_2_Exceptions_Throw;

/**
 * @author hatzp
 **/
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsInChain {
    public static void main(String[] args) {
        try {
            chainIt();
        } catch (Exception e) {                                // (1)
            System.out.println("Exception chain: " + e);
            Throwable t = e.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
            System.out.println("\n");
            e.printStackTrace();
            System.out.println("I printed the stack trace");
        }
    }

    public static void chainIt() throws Exception {          // (2)
        try {
            throw new FileNotFoundException("File not found");
        } catch (FileNotFoundException e) {
            try {
                IOException ioe = new IOException("File error");
                ioe.initCause(e);                                  // (3)
                throw ioe;
            } catch (IOException ioe) {
                Exception ee = new Exception("I/O error", ioe);    // (4)
                throw ee;
            }
        }
    }
}