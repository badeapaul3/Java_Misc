package devguideocp.Part1_C1to5.A3_1_Declarations;

/**
 * @author hatzp
 **/
public class Name {

    Name() {                      // (1) No-argument constructor
        System.out.println("Constructor");
    }


    //OF COURSE NOT RECOMMENDED
    void Name() {                 // (2) Instance method
        System.out.println("Method");
    }

    public static void main(String[] args) {
        new Name().Name();          // (3) Constructor call followed by method call
    }
}
