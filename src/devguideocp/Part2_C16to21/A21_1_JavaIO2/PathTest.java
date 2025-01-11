package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.File;
import java.net.URI;
import java.nio.file.*;

/**
 * @author hatzp
 **/
public class PathTest {
    public static void main(String[] args) {

        FileSystem dfs = FileSystems.getDefault();     // Obtain the default file system.
        String nameSeparator = dfs.getSeparator();     // The name separator for a path.

        Path absPath1 = Path.of("/a/b/c");                         // (1) /a/b/c
        Path absPath2 = Path.of(nameSeparator + "a" +              // (2) /a/b/c
                nameSeparator + "b" +
                nameSeparator + "c");
        Path absPath3 = Path.of(nameSeparator, "a", "b", "c");     // (3) /a/b/c
        System.out.println(absPath1.equals(absPath2) &&
                absPath2.equals(absPath3));             // true

        Path absPath4 = Path.of("C:\\a\\b\\c");                    // (4) C:\a\b\c
        Path absPath5 = Path.of("C:", "a", "b", "c");              // (5) C:\a\b\c



        Path relPath1 = Path.of("c", "d");                         //  c/d

        String pathOfCurrDir = System.getProperty("user.dir");  // (1)
        Path currDir = Path.of(pathOfCurrDir);                  // (2)
        Path relPath = Path.of(pathOfCurrDir, "d");             // (3) <curr-dir-path>/d


        //Paths utility class
        Path absPath7 = Paths.get(nameSeparator, "a", "b", "c");
        Path relPath3 = Paths.get("c", "d");

        Path absPath6 = dfs.getPath(nameSeparator, "a", "b", "c");
        Path relPath2 = dfs.getPath("c", "d");



        //interoperability with File class

        File file = new File(File.separator + "a" +
                File.separator + "b" +
                File.separator + "c");        // /a/b/c

// File --> Path, using the java.io.File.toPath() instance method
        Path fileToPath = file.toPath();                   // /a/b/c

// Path --> File, using the java.nio.file.Path.toFile() default method.
        File pathToFile = fileToPath.toFile();             // /a/b/c


        //interoperability with java.net.URI class
        //file:///a/b/c/d                      // Scheme: file, to access a local file.
        //http://www.whatever.com              // Scheme: http, to access a remote website.

        // Create a URI object, using the URL.create(String str) static factory method.
        URI uri1 = URI.create("file:///a/b/c/d");   // Local file.

        // URI --> Path, using the Path.of(URI uri) static factory method.
        Path uriToPath1 = Path.of(uri1);       // /a/b/c/d

        // URI --> Path, using the Paths.get(URI uri) static factory method.
        Path uriToPath2 = Paths.get(uri1);     // /a/b/c/d

        // Path --> URI, using the Path.toUri() instance method.
        URI pathToUri = uriToPath1.toUri();    // file:///a/b/c/d

    }
}
