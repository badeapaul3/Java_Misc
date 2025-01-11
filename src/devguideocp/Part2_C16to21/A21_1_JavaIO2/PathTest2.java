package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.nio.file.Path;

/**
 * @author hatzp
 **/
public class PathTest2 {
    public static void main(String[] args) {

        Path absPath1 = Path.of("/a");
        System.out.println(absPath1);

        Path absPath2 = Path.of("/a/b/c");
        System.out.println(absPath2);

        Path relPath1 = Path.of("d");
        System.out.println(relPath1);

        Path relPath2 = Path.of("../f");
        System.out.println(relPath2);

        Path relPath3 = Path.of("./../g");
        System.out.println(relPath3);

        System.out.println(absPath1.toAbsolutePath());
        System.out.println(absPath2.toAbsolutePath());
        System.out.println(relPath1.toAbsolutePath());
        System.out.println(relPath2.toAbsolutePath());
        System.out.println(relPath3.toAbsolutePath());



        Path path1 = Path.of("./a/./b/c/.");

        Path path2 = Path.of("a/../a/../b");

        Path path3 = Path.of("../../d");

        Path path4 = Path.of("./../../.");

        Path path5 = Path.of(".");
        System.out.println("@@@@@@");
        System.out.println(path1.normalize());
        System.out.println(path2.normalize());
        System.out.println(path3.normalize());
        System.out.println(path4.normalize());
        System.out.println(path5.normalize());
        System.out.println(relPath3.toAbsolutePath().normalize());









    }
}
