package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.*;
import java.nio.file.*;

/**
 * @author hatzp
 **/
public class UsingStreamsAndPath5 {
    public static void main(String[] args) throws IOException {

        String inputFileName  = "src\\devguideocp\\Part2_C16to21\\A21_1_JavaIO2\\PathTest.java";
        Path outputFilePath = Path.of("src\\devguideocp\\Part2_C16to21\\A29_Testing\\CopiedFile.java");
        try (var fis = new FileInputStream(inputFileName);
             var bis = new BufferedInputStream(fis)) {
            long bytesCopied = Files.copy(bis, outputFilePath,
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Bytes copied: " + bytesCopied);      // Bytes copied: 103
        }

        //Path inputFilePath  = Path.of("project", "backup", "Util.java");
        //String outputFileName = "project/archive/src/pkg/Util.java";
        //try (var fos = new FileOutputStream(outputFileName);
        //     var bos = new BufferedOutputStream(fos)) {
        //  long bytesCopied = Files.copy(inputFilePath, bos);
        //  System.out.println("Bytes copied: " + bytesCopied);      // Bytes copied: 103
        //}

        Path inputFilePath = Path.of("");

        Files.copy(inputFilePath, System.out);     // Prints file content to standard out.

//In general, any InputStream or OutputStream can be used in the respective copy() methods.

    }
}
