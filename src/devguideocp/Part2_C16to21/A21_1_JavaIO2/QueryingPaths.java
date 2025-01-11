package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QueryingPaths {

    public static void main(String[] args) {
        FileSystem dfs = FileSystems.getDefault();     // The default file system
        String nameSeparator = dfs.getSeparator();     // The name separator
        System.out.println("Separator " +nameSeparator);

        //Path absPath = Path.of(nameSeparator, "a", "b", "c");                // (1)
        Path absPath = Paths.get("C://a//b//c");                // (1)

        System.out.printf("toString(): %s%n",   absPath);                    // (2)
        System.out.printf("isAbsolute(): %s%n", absPath.isAbsolute());       // (3)
        System.out.printf("getFileSystem(): %s%n",
                absPath.getFileSystem().getClass().getName());    // (4)

        System.out.println("\n***Accessing Name Elements:");                 // (5)
        System.out.printf("getFileName(): %s%n",  absPath.getFileName());
        System.out.printf("getParent(): %s%n",    absPath.getParent());
        System.out.printf("getRoot(): %s%n",      absPath.getRoot());
        System.out.printf("getNameCount(): %d%n", absPath.getNameCount());

        List<Path> pl = new ArrayList<>();
        absPath.forEach(p -> pl.add(p));
        System.out.printf("List of name elements: %s%n",  pl);

        System.out.printf("getName(0): %s%n",     absPath.getName(0));
        System.out.println(absPath);
        System.out.printf("subpath(0,2): %s%n",   absPath.subpath(0,3));
        System.out.println("is abs path? " + absPath.subpath(0,3).isAbsolute());

        System.out.println("\n***Path Prefix and Suffix:");                  // (6)
        System.out.printf("startsWith(\"%s\"): %s%n",
                nameSeparator + "a",
                absPath.startsWith("C://"));
        System.out.printf("endsWith(\"b/c\"): %s%n",
                absPath.endsWith("b/c"));
    }
}
