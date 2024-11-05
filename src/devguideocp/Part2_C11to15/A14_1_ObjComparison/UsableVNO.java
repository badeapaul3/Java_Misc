package devguideocp.Part2_C11to15.A14_1_ObjComparison;

/**
 * @author hatzp
 **/
import java.util.Objects;

// Overrides equals(), but not hashCode().
public class UsableVNO {

    private int release;
    private int revision;
    private int patch;

    public UsableVNO(int release, int revision, int patch) {
        this.release  = release;
        this.revision = revision;
        this.patch    = patch;
    }
    public UsableVNO(){}

    public int getRelease()  { return this.release;  }
    public int getRevision() { return this.revision; }
    public int getPatch()    { return this.patch;    }

    @Override public String toString() {
        return "(" + release + "." + revision + "." + patch + ")";
    }

    @Override public boolean equals(Object obj) {     // (1)
        return (this == obj)                            // (2)
                || (obj instanceof UsableVNO vno            // (3)
                && this.patch    == vno.patch           // (4)
                && this.revision == vno.revision
                && this.release  == vno.release);
    }
}



//MyRefType ref1 = new MyRefType();
//MyRefType ref2 = new MyRefType();
//Object    ref3 = ref2;
//boolean b1 = ref1.equals(ref2);    // True. Calls equals() in MyRefType.
//boolean b2 = ref1.equals(ref3);    // Always false. Calls equals() in Object.