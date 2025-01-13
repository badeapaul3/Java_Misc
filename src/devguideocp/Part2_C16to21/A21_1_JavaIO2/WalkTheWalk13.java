package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class WalkTheWalk13 {

    public static void main(String[] args) throws IOException {

        // Creating symbolic link.                                        // (1)
        try {
            Path targetPath = Path.of(".", "a", "b");
            Path symbLinkPath  = Path.of(".", "a", "b", "c", "dir_link");
            if (Files.notExists(symbLinkPath, LinkOption.NOFOLLOW_LINKS)) {
                Files.createSymbolicLink(symbLinkPath, targetPath.toAbsolutePath());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }

        // Do the walk.                                                    // (2)
        Path start = Path.of(".", "a");
        int MAX_DEPTH = 4;

        for (int depth = 0; depth <= MAX_DEPTH; ++depth)  {                // (3)
            try(Stream<Path> stream = Files.walk(start, depth,               // (4)
                    FileVisitOption.FOLLOW_LINKS)) {
                System.out.println("Depth limit: " + depth);
                stream.forEach(System.out::println);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void copyEntireDirectory(Path sourceDir,
                                           Path destinationDir,
                                           CopyOption... options)  {
        try (Stream<Path> stream = Files.walk(sourceDir)) {                    // (1)
            stream.forEach(entry -> {
                Path relativeEntryPath = sourceDir.relativize(entry);              // (2)
                Path destination  = destinationDir.resolve(relativeEntryPath);     // (3)
                try {
                    Files.copy(entry, destination, options);                         // (4)
                } catch (DirectoryNotEmptyException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    CopyOption[] options = new CopyOption[] {
            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES,
            LinkOption.NOFOLLOW_LINKS};
    Path sourceDirectory      = Path.of(".", "a", "b");       //      ./a/b
    Path destinationDirectory = Path.of(".", "x", "y");       // (5a) ./x/y
// Path destinationDirectory = Path.of(".", "x")
//              .resolve(sourceDirectory.getFileName());  // (5b) ./x/b







}
