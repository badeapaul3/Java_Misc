package devguideocp.Part2_C11to15.A13_2_Lambdas;

/**
 * @author hatzp
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MembersOnly {

    // Instance variable
    private StringBuilder banner;                                    // (1)

    // Static variable
    private static List<String> strList;                             // (2)

    // Constructor
    public MembersOnly(String str) {
        banner = new StringBuilder(str);
    }

    // Static method
    public static void main(String[] args) {
        strList = new ArrayList<>();                                   // (3)
        strList.add("Tom"); strList.add("Dick"); strList.add("Harriet");

        MembersOnly obj = new MembersOnly("love ");                    // (4)
        Predicate<String> p = obj.getPredicate();                      // (5)
        System.out.println(p.test("never dies!") + " " + obj.banner);  // (6)
        System.out.println(obj.banner);
    }

    // Instance method
    public Predicate<String> getPredicate() {              // (7)
        return str -> {                                      // (8)  Lambda expression
            System.out.println("List: " + MembersOnly.strList);// (9)  Static field
            this.banner.append(str);                           // (10) Instance field
            System.out.println(str);
            return str.length() > 5;                           // (11) boolean value
        };
    }
}
