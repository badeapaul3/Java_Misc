package devguideocp.Part2_C11to15.A14_2_ObjComparisonComp;

/**
 * @author hatzp
 **/

import java.util.Comparator;
import java.util.Objects;

public final class VersionNumber implements Comparable<VersionNumber> {

    private final int release;
    private final int revision;
    private final int patch;

    public VersionNumber(int release, int revision, int patch) {
        this.release  = release;
        this.revision = revision;
        this.patch    = patch;
    }

    public int getRelease()  { return this.release;  }
    public int getRevision() { return this.revision; }
    public int getPatch()    { return this.patch;    }

    @Override public String toString() {
        return "(" + release + "." + revision + "." + patch + ")";
    }

    @Override public boolean equals(Object obj) {                     // (1)
        return (this == obj)                                            // (2)
                || (obj instanceof VersionNumber vno                        // (3)
                && this.patch    == vno.patch
                && this.revision == vno.revision
                && this.release  == vno.release);
    }

    @Override public int hashCode() {
        return Objects.hash(this.release, this.revision, this.patch);   // (4)
    }

    @Override public int compareTo(VersionNumber vno) {               // (5)
        // Compare the release numbers.                                    (6)
        if (this.release != vno.release)
            return Integer.compare(this.release, vno.release);

        // Release numbers are equal,                                      (7)
        // must compare revision numbers.
        if (this.revision != vno.revision)
            return Integer.compare(this.revision, vno.revision);

        // Release and revision numbers are equal,                         (8)
        // patch numbers determine the ordering.
        return Integer.compare(this.patch, vno.patch);
    }

  /*
  @Override public int compareTo(VersionNumber vno) {               // (9a)
    return Comparator.comparingInt(VersionNumber::getRelease)       // (10a)
                     .thenComparingInt(VersionNumber::getRevision)  // (11a)
                     .thenComparingInt(VersionNumber::getPatch)     // (12a)
                     .compare(this, vno);                           // (13a)
  }
  */

 /*
    @Override public int compareTo(VersionNumber vno) {               // (9b)
        Comparator<VersionNumber> c1
                = Comparator.comparingInt(vn -> vn.getRelease());           // (10b)
        Comparator<VersionNumber> c2
                = c1.thenComparingInt(vn -> vn.getRevision());              // (11b)
        Comparator<VersionNumber> c3
                = c2.thenComparingInt(vn -> vn.getPatch());                 // (12b)
//return c3.compare(this, vno);                                   // (13b)
        return Objects.compare(this, vno, c3);                          // (13c)
    }

  */



}
