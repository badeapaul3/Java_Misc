package devguideocp.Part2_C16to21.A20_1_JavaIO;

/* Copy a file using a character buffer.
   Command syntax: java CopyCharacterFile <from_file> <to_file> */
import java.io.*;

class CopyCharacterFile {
    public static void main(String[] args) {

        try (// Assign the files:
             FileReader fromFile = new FileReader(args[0]);                 // (1)
             FileWriter toFile = new FileWriter(args[1]))  {                // (2)

            // Copy characters using buffer:                                 // (3a)
            char[] buffer = new char[1024];
            int length = 0;
            while((length = fromFile.read(buffer)) != -1) {
                toFile.write(buffer, 0, length);
            }

            // Transfer characters:
//    fromFile.transferTo(toFile);                                     // (3b)

        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: java CopyCharacterFile <from_file> <to_file>");
        } catch(FileNotFoundException e) {
            System.err.println("File could not be copied: " + e);
        } catch(IOException e) {
            System.err.println("I/O error.");
        }
    }
}
