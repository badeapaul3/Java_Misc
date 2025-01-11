package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author hatzp
 **/
public class Moving6 {
    public static void main(String[] args) throws IOException {

        //static Path move(Path source, Path destination, CopyOption... options)
        //            throws IOException


        //If destination already exists, the move fails.
        //
        //If source and destination are the same, the method has no effect.
        //
        //If source is a symbolic link, the target of the link is moved.
        //
        //If source is an empty directory, the empty directory is moved to the destination.

        //StandardCopyOption.REPLACE_EXISTING: If the destination exists, this option indicates to replace the destination if it is a file or an empty directory. If the destination exists and is a symbolic link, this option indicates to replace the symbolic link and not its target.
        //
        //StandardCopyOption.ATOMIC_MOVE: The move is performed as an atomic file system operation. It is implementation specific whether the move is performed if the destination exists or whether an IOException is thrown. If the move cannot be performed, the method throws an AtomicMoveNotSupportedException.


        Path srcFile  = Path.of("project", "src",  "manifest.txt");
        Path destFile = Path.of("project", "bkup", "manifest.txt");
        Files.move(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING);


        Path srcDir = Path.of("project", "bkup");
        Path destDir = Path.of("project", "archive", "backup");  // Parent path exists.
        Files.move(srcDir, destDir);

        //renames
        Path oldFileName  = Path.of("project", "backup", "Util.java");
        Path newFileName  = Path.of("project", "backup", "UX.java");
        Files.move(oldFileName, newFileName);

        Path oldDirName  = Path.of("project", "backup");
        Path newDirName  = Path.of("project", "bkup");
        Files.move(oldDirName, newDirName);


//atomic move
        Path srcFile2 = Path.of("project", "src", "pkg", "Util.java");
        Path destFile2 = Path.of("project", "archive", "src", "pkg", "Util.java");
        Files.move(srcFile2, destFile2, StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.ATOMIC_MOVE);






    }
}
