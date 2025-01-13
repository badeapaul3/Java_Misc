package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.util.Set;

import static java.lang.System.out;

/**
 * @author hatzp
 **/
public class BulkFileAttributes10 {
    public static void main(String[] args) throws IOException {


        Path path = Path.of("project", "src", "pkg", "Main.java");
        out.println("File: " + path);
        BasicFileAttributeView bfaView = Files.getFileAttributeView(path,      // (6)
                BasicFileAttributeView.class);
        out.printf("Using view: %s%n", bfaView.name());

// Reading the basic set of file attributes:                              (7)
        BasicFileAttributes bfa2 = bfaView.readAttributes();
        //FileUtils.printBasicFileAttributes(bfa2);
        FileTime currentLastModifiedTime = bfa2.lastModifiedTime();

// Updating timestamp for last modified time using view:                  (8)
        long newLMTinMillis = currentLastModifiedTime.toMillis() + 15*60*1000L;
        FileTime newLastModifiedTime = FileTime.fromMillis(newLMTinMillis);
        bfaView.setTimes(newLastModifiedTime, null, null);

// Reading the updated last modified time:                                (9)
        out.println("updated lastModifiedTime (incorrect): "
                + bfa2.lastModifiedTime());   // (10)
        out.println("updated lastModifiedTime: "
                + Files.getLastModifiedTime(path)); // (11)
        out.println("updated lastModifiedTime: " + Files.getAttribute(path,    // (12)
                "basic:lastModifiedTime"));

        out.println("File: " + path);
        PosixFileAttributeView pfaView = Files.getFileAttributeView(path,      // (13)
                PosixFileAttributeView.class);
        System.out.printf("Using view: %s%n", pfaView.name());

// Reading the basic + POSIX set of file attributes:                   // (14)
        PosixFileAttributes pfa2 = pfaView.readAttributes();
//        FileUtils.printBasicFileAttributes(pfa2);
//        FileUtils.printPosixFileAttributes(pfa2);

// Updating owner and group file attributes using view.                // (15)
        FileSystem fs = path.getFileSystem();
        UserPrincipalLookupService upls = fs.getUserPrincipalLookupService();
        UserPrincipal newUser = upls.lookupPrincipalByName("javadude");
        GroupPrincipal newGroup = upls.lookupPrincipalByGroupName("admin");
        pfaView.setOwner(newUser);
        pfaView.setGroup(newGroup);

//Updating file permissions using view.                                // (16)
        Set<PosixFilePermission> newPerms = PosixFilePermissions.fromString("r--r--r--");
        pfaView.setPermissions(newPerms);

//Updating last access time using view.                                // (17)
        FileTime currentAccessTime = pfa2.lastAccessTime();
        long newLATinMillis = currentAccessTime.toMillis() + 10*60*1000L;
        FileTime newLastAccessTime = FileTime.fromMillis(newLATinMillis);
        pfaView.setTimes(null, newLastAccessTime, null);

// Reading the updated file attributes:                                // (18)
        pfa2 = pfaView.readAttributes();
//        FileUtils.printBasicFileAttributes(pfa2);
//        FileUtils.printPosixFileAttributes(pfa2);


    }
}
