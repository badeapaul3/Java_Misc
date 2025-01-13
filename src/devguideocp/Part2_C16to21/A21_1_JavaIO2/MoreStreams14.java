package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

/**
 * @author hatzp
 **/
public class MoreStreams14 {
    public static void main(String[] args) {

//        static Stream<Path> find(Path start, int depth,
//                  BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) throws IOException

        System.out.println("Find regular files whose name ends with \".txt\""
                + " and whose size is > 0:");
        Path startEntry = Path.of(".");
        int depth = 5;
        try (var pStream = Files.find(startEntry, depth,
                (path, attrs) -> attrs.isRegularFile()       // (1)
                        && attrs.size() > 0
                        && path.toString().endsWith(".txt"), FileVisitOption.FOLLOW_LINKS)) {
            List<Path> pList = pStream.toList();
            System.out.println(pList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }
}
