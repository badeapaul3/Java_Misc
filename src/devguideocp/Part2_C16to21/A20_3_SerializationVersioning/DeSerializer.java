package devguideocp.Part2_C16to21.A20_3_SerializationVersioning;

/**
 * @author hatzp
 **/
// Deserializer for objects of class Item.
import java.io.*;

public class DeSerializer{                                               // (4)
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        try (// Set up the input streams:
             FileInputStream inputFile = new FileInputStream("item_storage.dat");
             ObjectInputStream inputStream = new ObjectInputStream(inputFile)) {

            // Read a serialized object of the Item class.
            Item item = (Item) inputStream.readObject();

            // Write data on standard output stream.
            System.out.println("After reading: " + item);
        }
    }
}