package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.nio.file.Path;

/**
 * @author hatzp
 **/
public class PathTest3 {
    public static void main(String[] args) {

        Path anyPath = Path.of("/a/n/y");
        Path emptyPath = Path.of("");
        System.out.println(anyPath.resolve(emptyPath));       // /a/n/y
        System.out.println("@@@@@@@@");

        Path absPath1
                = Path.of("/a/b");

        Path absPath2
                = Path.of("/c");

        Path relPath1
                = Path.of("d");

        Path relPath2
                = Path.of("../e/f");


        System.out.println(absPath1.resolve(absPath2));
        System.out.println(relPath1.resolve(absPath2));
        System.out.println(absPath1.resolve(relPath2));
        System.out.println(relPath1.resolve(relPath2));




    }
}
