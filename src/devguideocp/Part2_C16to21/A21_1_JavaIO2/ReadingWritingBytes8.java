package devguideocp.Part2_C16to21.A21_1_JavaIO2;


//static InputStream newInputStream(Path path, OpenOption... options)
//                                 throws IOException
//Opens a file denoted by the specified path, and returns an input stream to read from the file. No options implies the READ option.

//static OutputStream newOutputStream(Path path, OpenOption... options)
//                    throws IOException
//Opens or creates a file denoted by the specified path, and returns an output stream that can be used to write bytes to the file.
// No options implies the following options: CREATE, TRUNCATE_EXISTING, and WRITE.
import java.io.*;
import java.nio.file.*;

public class ReadingWritingBytes8 {
    public static void main(String[] args) {
        // Source and destination files:
        Path srcPath  = Path.of("project", "source.dat");
        Path destPath = Path.of("project", "destination.dat");

        try (InputStream is = Files.newInputStream(srcPath);                    // (1)
             OutputStream os = Files.newOutputStream(destPath))  {
            byte[] buffer = new byte[1024];
            int length = 0;

            while((length = is.read(buffer, 0, buffer.length)) != -1) {
                os.write(buffer, 0, length);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            // Reads the file contents into an array of bytes:
            byte[] allBytes = Files.readAllBytes(srcPath);                        // (2)

            // Writes an array of bytes to a file:
            Files.write(destPath, allBytes);                                      // (3)
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
