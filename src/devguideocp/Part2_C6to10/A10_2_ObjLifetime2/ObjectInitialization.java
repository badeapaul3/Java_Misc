package devguideocp.Part2_C6to10.A10_2_ObjLifetime2;

/**
 * @author hatzp
 **/
class SuperclassA2 {
    protected int superValue;                              // (1)
    SuperclassA2() {                                        // (2)
        System.out.println("Constructor in SuperclassA");
        this.doValue();                                      // (3)
    }
    void doValue() {                                       // (4)
        this.superValue = 911;
        System.out.println("superValue (from SuperclassA): " + this.superValue);
    }
}
//_______________________________________________________________________________
class SubclassB2 extends SuperclassA2 {
    private int value = 800;                               // (5)
    SubclassB2() {                                          // (6)
        System.out.println("Constructor in SubclassB");
        this.doValue();
        System.out.println("superValue (from SuperclassA): " + this.superValue);
        //added by me:
        this.superValue=2;
        //super.superValue=3;
        System.out.println("superValue (from SuperclassA): " + super.superValue);
        System.out.println("superValue (from SuperclassA): " + superValue);
        System.out.println("superValue (from SuperclassA): " + this.superValue + "\n");

        super.doValue();
        System.out.println("superValue (from SuperclassA): " + super.superValue);
        System.out.println("superValue (from SuperclassA): " + superValue);
        System.out.println("superValue (from SuperclassA): " + this.superValue);
    }
    @Override
    void doValue() {                                       // (7)
        System.out.println("value (from SubclassB): " + this.value);
    }
}
//_______________________________________________________________________________
public class ObjectInitialization {
    public static void main(String[] args) {

        System.out.println("Creating an object of SubclassB.");
        new SubclassB2();                                     // (8)
    }
}
