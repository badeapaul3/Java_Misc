package devguideocp.Part2_C6to10.A7_3_Try_Resources;

/**
 * @author hatzp
 **/


import java.io.EOFException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TryWithARM {
    public static void main(String[] args) {
        try (var fis = new FileReader(args[0]);        // (1) FileNotFoundExeception
             var br = new BufferedReader(fis)) {
            String textLine = br.readLine();             // (2) IOException
            if (textLine != null) {
                System.out.println(textLine);
            } else {
                throw new EOFException("Empty file.");     // (3) EOFException
            }
        } catch (FileNotFoundException | EOFException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}