package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import static java.lang.System.out;

/**
 * @author hatzp
 **/
public class CreatingDirectoryEntries11 {
    public static void main(String[] args) {
        //static Path createFile(Path path, FileAttribute<?>... attrs)
        //                       throws IOException

        //static Path createTempFile(String prefix, String suffix,
        //                           FileAttribute<?>... attrs) throws IOException
        //static Path createTempFile(Path dir, String prefix, String suffix,
        //                           FileAttribute<?>... attrs) throws IOException


        //static Path createSymbolicLink(Path symbLink, Path target,
        //                               FileAttribute<?>... attrs) throws IOException

        //static Path readSymbolicLink(Path symbLink) throws IOException
        Path path  = Path.of("info.txt");

//        try {
//            Path regularFile  = Path.of("project", "docs", "readme.txt");
//            Path createdFile1 = Files.createFile(regularFile, fileAttr);        // (1)
//            printDirEntryInfo(createdFile1);
//        } catch (NoSuchFileException | FileAlreadyExistsException fe) {
//            fe.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }

        try {
            // System property that defines the default temporary-file directory.      (1)
            String tmpdir = System.getProperty("java.io.tmpdir");
            System.out.println("Default temporary directory: " + tmpdir);

            // Create under the default temporary-file directory.                      (2)
            Path tmpFile1 = Files.createTempFile("events", ".log");
            printDirEntryInfo(tmpFile1);

            // Create under a specific directory:                                      (3)
            Path tmpFileDir = Path.of("project");
            BasicFileAttributes fileAttr = Files.readAttributes(path,                  // (1)
                    BasicFileAttributes.class);
            Path tmpFile2 = Files.createTempFile(tmpFileDir, "proj_", ".dat", (FileAttribute<?>) fileAttr);
            Path tmpFile3 = Files.createTempFile(tmpFileDir, "proj_", null,(FileAttribute<?>)fileAttr);
            Path tmpFile4 = Files.createTempFile(tmpFileDir, null,    ".dat",(FileAttribute<?>) fileAttr);
            Path tmpFile5 = Files.createTempFile(tmpFileDir, null,    null,  (FileAttribute<?>) fileAttr);
            printDirEntryInfo(tmpFile2);
            printDirEntryInfo(tmpFile3);
            printDirEntryInfo(tmpFile4);
            printDirEntryInfo(tmpFile5);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            Path symbLinkPath  = Path.of(".", "readme_link");                     // (1)
            Path targetPath    = Path.of(".", "project", "backup", "readme.txt"); // (2)

            Path symbLink = Files.createSymbolicLink(symbLinkPath, targetPath);   // (3a)
//Path symbLink = Files.createSymbolicLink(symbLinkPath,
//                                         targetPath.toAbsolutePath());// (3b)
            Path target = Files.readSymbolicLink(symbLink);                       // (4)

            printDirEntryInfo(symbLink);
            printDirEntryInfo(target);
        } catch (FileAlreadyExistsException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //static Path createDirectory(Path dir, FileAttribute<?>... attrs)
        //                            throws IOExceptio
        //Creates a new directory denoted by the Path object. It does not create nonexistent parent directories, and throws a NoSuchFileException if any parent directory does not exist. It also throws a FileAlreadyExistsException if the directory entry with that name already exists.


        //static Path createDirectories(Path dir, FileAttribute<?>... attrs)
        //            throws IOException
        //Creates a directory by creating all nonexistent parent directories first. It does not throw an exception if any of the directories already exist. If the method fails, some directories may have been created.

        //static Path createTempDirectory(String prefix, FileAttribute<?>... attrs)
        //                                throws IOException
        //static Path createTempDirectory(Path dir, String prefix,
        //                                FileAttribute<?>... attrs)
        //                                throws IOException


        Set<PosixFilePermission> dPerms = PosixFilePermissions.fromString("rwxrwxrwx");
        FileAttribute<Set<PosixFilePermission>> dirFileAttr =
                PosixFilePermissions.asFileAttribute(dPerms);

        try {
            Path regularDir  = Path.of("project", "bin");
            Path createdDir = Files.createDirectory(regularDir);                    // (1)
            printDirEntryInfo(createdDir);

            if (Files.deleteIfExists(regularDir)) {                                 // (2)
                System.out.printf("Directory deleted: %s%n", regularDir);
            }
            Path newDir = Files.createDirectory(regularDir, dirFileAttr);           // (3)
            printDirEntryInfo(newDir);
            Files.setPosixFilePermissions(newDir, dPerms);                          // (4)
            printDirEntryInfo(newDir);
        } catch (NoSuchFileException | FileAlreadyExistsException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            Path regularDir2  = Path.of("project", "branches", "maintenance", "versions");
            Path createdDir2 = Files.createDirectories(regularDir2, dirFileAttr);  // (5)
            printDirEntryInfo(createdDir2);
        } catch (FileAlreadyExistsException fe) {                                // (6)
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



        try  {
            // Create under the default temporary-file directory.                     (7)
            Path tmpDirPath1 = Files.createTempDirectory("log_dir", dirFileAttr);
            printDirEntryInfo(tmpDirPath1);

            // Create under a specific location:                                      (8)
            Path tmpDirLoc = Path.of("project");
            Path tmpDirPath2 = Files.createTempDirectory(tmpDirLoc, "log_dir", dirFileAttr);
            Path tmpDirPath3 = Files.createTempDirectory(tmpDirLoc, null, dirFileAttr);
            printDirEntryInfo(tmpDirPath2);
            printDirEntryInfo(tmpDirPath3);

            Files.setPosixFilePermissions(tmpDirPath3, dPerms);                    // (9)
            printDirEntryInfo(tmpDirPath3);
        } catch (NoSuchFileException nsfe) {
            nsfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }




    }

    public static void printDirEntryInfo(Path path) throws IOException {
        String fmt = Files.isSymbolicLink(path)? "Symbolic link: %s%n":
                Files.isRegularFile(path)? "File: %s%n":
                        Files.isDirectory(path)? "Directory: %s%n":
                                "Directory entry: %s%n";
        out.printf(fmt, path);
        Set<PosixFilePermission> perms = Files.getPosixFilePermissions(path);
        String permStr = PosixFilePermissions.toString(perms);
        out.println(permStr);
    }

}
