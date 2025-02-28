package devguideocp.Part2_C16to21.A20_1_JavaIO;

/**
 * @author hatzp
 **/
/* Copy a file using a byte buffer.
   Command syntax: java CopyFile <from_file> <to_file> */
import java.io.*;

class CopyFile {
    public static void main(String[] args) {

        try (// Assign the files:
             FileInputStream fromFile = new FileInputStream(args[0]);       // (1)
             FileOutputStream toFile = new FileOutputStream(args[1]))  {    // (2)

            // Copy bytes using buffer:                                      // (3a)
            byte[] buffer = new byte[1024];
            int length = 0;
            while((length = fromFile.read(buffer)) != -1) {
                toFile.write(buffer, 0, length);
            }

            // Transfer bytes:
//    fromFile.transferTo(toFile);                                     // (3b)

        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: java CopyFile <from_file> <to_file>");
        } catch(FileNotFoundException e) {
            System.err.println("File could not be copied: " + e);
        } catch(IOException e) {
            System.err.println("I/O error.");
        }
    }
}