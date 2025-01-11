package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hatzp
 **/
public class PathTestAndCopies4 {
    public static void main(String[] args) throws IOException {

        Path p = Path.of("/a/b");
        Path other = Path.of("/a/b/c/d");
        Path q = p.relativize(other);                               // c/d
        System.out.println(p.relativize(p.resolve(q)).equals(q));   // true
        System.out.println(p.resolve(q).equals(other));             // true

        Path absPath1
                = Path.of("/a/b");

        Path relPath1
                = Path.of("d");

        Path absPath2
                = Path.of("/c");

        Path relPath2
                = Path.of("e/f");


        System.out.println(absPath1.relativize(absPath2));
        //System.out.println(absPath1.relativize(relPath2)); IllegalArgumentException
        //System.out.println(relPath1.relativize(absPath2)); IllegalArgumentException
        System.out.println(relPath1.relativize(relPath2));



        //Link Option
        //The toRealPath() method performs several operations to construct the real path:
        //
        //If this path is a relative path, it is first converted to an absolute path.
        //
        //Any redundant name elements are removed to create a new path. In other words, it normalizes the result path.
        //
        //If LinkOption.NOFOLLOW_LINKS is specified, any symbolic links are not followed.

//        try {
//            Path somePath = Path.of("some/path");
//            Path realPath = somePath.toRealPath(LinkOption.NOFOLLOW_LINKS);
//            System.out.println(realPath);
//        } catch (NoSuchFileException nsfe) {
//            nsfe.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }

        String pathOfCurrDir = System.getProperty("user.dir");  // (1)
        Path currDir = Path.of(pathOfCurrDir);                  // (2)
        System.out.println(currDir);

//
//Current directory: /book/chap01 The symbolic link ./alias_appendixA has the target /book/appendixA.
        Path path4 = Path.of("./alias_appendixA");
//
//path4.toRealPath() returns /book/appendixA.
//path4.toRealPath(LinkOption.
//NOFOLLOW_LINKS) returns
///book/chap01/alias_appendixA.

        //comparing,searching,sorting

        Path p1 = Paths.get("\\a\\b\\c\\d");
        Path p2 = Paths.get("\\a\\b");
        Path p3 = Paths.get("\\a\\b\\c");
        Path p4 = Paths.get("a","b");

// Sorting paths according to natural order:
        List<Path> sortedPaths = Stream.of(p1, p2, p3, p4)
                .sorted()
                .toList();
        System.out.println(sortedPaths);
// [/a/b, /a/b/c, /a/b/c/d, a/b]

// Comparing for lexicographical equality:
        System.out.println(p2);                          // Absolute path: /a/b
        System.out.println(p3.subpath(0, 2));            // Relative path: a/b
        System.out.println(p2.equals(p3.subpath(0, 2))); // false

//var arity options
        // Method header:
        //static boolean exists(Path path, LinkOption... options)  // Variable arity param.

        // Method calls:
        Path path = Path.of("alias");
        boolean result1 = Files.exists(path);            // Follow symbolic links.
        boolean result2 = Files.exists(path,
                LinkOption.NOFOLLOW_LINKS);  // Do not follow symbolic links.

//atomic operations
        //static boolean exists(Path path, LinkOption... options)
        //static boolean notExists(Path path, LinkOption... options)

//These methods normalize the path, and do not follow symbolic links if the enum constant LinkOption.NOFOLLOW_LINKS is specified for the options variable arity parameter.
//
//These methods are not complements of each other. Both return false if they are not able to determine whether a directory entry exists or not.
// This can occur due to lack of access permissions. Note that the result returned by these methods is immediately outdated.
//
//
// static boolean isSameFile(Path path1, Path path2) throws IOException

        Path path1 = Path.of("project", "src", "pkg", "Main.java");
        System.out.println(Files.exists(path1));                             // true
        System.out.println(Files.notExists(path1));                          // false

        Path path2 = Path.of("project", "..", "project", ".", "src", "pkg", "Main.java");
        System.out.println(Files.exists(path2));                             // true
        System.out.println(Files.notExists(path2));                          // false

        Path path3 = Path.of("project", "readme.txt");
        System.out.println(Files.exists(path3));                             // false
        System.out.println(Files.notExists(path3));                          // true


        Path target   = Path.of("project", "src", "manifest.txt");
        Path symbLink = Path.of("project", "manifest_link");

        boolean result4 = Files.exists(target);                              // (1)
        boolean result5 = Files.exists(symbLink);                            // (2)
        boolean result6 = Files.exists(symbLink, LinkOption.NOFOLLOW_LINKS); // (3)

        System.out.println("target: " + result4);                            // (1a) true
        System.out.println("symbLink->target: " + result5);                  // (2a) true
        System.out.println("symbLink_NOFOLLOW_LINKS: " + result6);           // (3a) true



        System.out.println(Files.isSameFile(path1, path2));            // (1) true
        System.out.println(Files.isSameFile(symbLink, target));        // (2) true
        System.out.println(Files.isSameFile(path1, target));           // (3) false
        System.out.println(Files.isSameFile(Path.of("Main.java"),
                Path.of("Main.java")));    // (4) true
        System.out.println(Files.isSameFile(path1,
                Path.of("Main.java")));  // (5) NoSuchFileException


//static void delete(Path path) throws IOException
//static boolean deleteIfExists(Path path) throws IOException

//Delete a directory entry denoted by the path.
//
//If the path does not exist, the first method throws a NoSuchFileException, but the second method does not.
//
//Deleting a symbolic link only deletes the link, and not the target of the link.
//
//To delete a directory, it must be empty or a java.nio.file.DirectoryNotEmpty-Exception is thrown.

        Path projDir  = Path.of("project");
        Files.delete(symbLink);                 // Exists. Link deleted, not target.
        Files.delete(Path.of("Main.java"));     // Does not exist: NoSuchFileException

        System.out.println(Files.deleteIfExists(target));               // Exists.
        //  Deleted: true
        System.out.println(Files.deleteIfExists(Path.of("Main.java"))); // Does not
        //   exist: false

        Files.delete(projDir);                             // DirectoryNotEmptyException
        System.out.println(Files.deleteIfExists(projDir)); // DirectoryNotEmptyException




        //The overloaded copy() methods of the Files class implement copying contents of files. Two of the copy() methods can be configured by specifying copy options.
        //static Path copy(Path source, Path destination, CopyOption... options)
        //                throws IOException

//Copies a source directory entry to the destination directory entry. It returns the path to the destination directory entry. The default behavior is outlined below, but can be configured by copy options:
//
//If destination already exists or is a symbolic link, copying fails.
//
//• If source and destination are the same, the method completes without any copying.
//
//If source is a symbolic link, the target of the link is copied.
//
//If source is a directory, just an empty destination directory is created.

//options
        //StandardCopyOption.REPLACE_EXISTING: If the destination exists, this option indicates to replace the destination if it is a file or an empty directory. If the destination exists and is a symbolic link, it indicates to replace the symbolic link and not its target.
        //
        //StandardCopyOption.COPY_ATTRIBUTES: This option indicates to copy the file attributes of the source to the destination. However, copying of attributes is platform dependent.
        //
        //LinkOption.NOFOLLOW_LINKS: This option indicates not to follow symbolic links. If the source is a symbolic link, then the symbolic link is copied and not its target.


//static long copy(InputStream in, Path destination, CopyOption... options)
//                throws IOException

        //StandardCopyOption.REPLACE_EXISTING: If the destination path exists and is a file or an empty directory,
        // this option indicates to replace the destination. If the destination exists and is a symbolic link, this option indicates to replace the symbolic link and not its target.


        Path source = Path.of("project", "src", "pkg", "Main.java");               // (1)
        Path parentDestinationPath = Path.of("project", "archive", "src", "pkg");  // (2)
        Path destination = parentDestinationPath.resolve(source.getFileName());    // (3)

        Files.copy(source, destination);      // (4) OK. Destination file does not exist.
        Files.copy(source, destination,       // (5) OK. Destination file replaced.
                StandardCopyOption.REPLACE_EXISTING);
        Files.copy(source, destination);      // (6) FileAlreadyExistsException



        //./project/src
        //to
        ///project/backup


        Path srcDir  = Path.of("project", "src");
        Path destDir = Path.of("project", "backup");
        Files.copy(srcDir, destDir, StandardCopyOption.REPLACE_EXISTING);
        //up explanation
        //If an entry named backup does not exist in the project directory, an empty directory named backup is created.
        //
        //If an entry named backup exists in the project directory and it is an empty directory, a new empty directory named backup is created.
        //
        //If an entry named backup exists in the project directory and it is a file, the file is deleted and an empty directory named backup is created.
        //
        //If an entry named backup exists in the project directory and it is a non-empty directory, the copying operation fails with a DirectoryNotEmptyException.


        //./project/src/pkg/Main.java
        //to
        //./project/classes

        Path srcFile = Path.of("project", "src", "pkg", "Main.java");
        Path destDir2 = Path.of("project", "classes");
        Files.copy(srcFile, destDir2, StandardCopyOption.REPLACE_EXISTING);

        //If an entry named classes does not exist in the project directory, a file named classes is created and the contents of the source file are copied to the file classes.
        //
        //If an entry named classes exists in the project directory and it is a file, the file is deleted, a new file named classes is created, and the contents of the source file are copied to the file classes.
        //
        //If an entry named classes exists in the project directory and it is an empty directory, the directory is deleted, a file named classes is created, and the contents of the source file are copied to the file classes.
        //
        //If an entry named classes exists in the project directory and it is a non-empty directory, the copying operation fails with a DirectoryNotEmptyException.














    }
}
