package devguideocp.Part2_C11to15.A13_2_Lambdas;

/**
 * @author hatzp
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LocalsOnly {

    public static void main(String[] args) {
        StringBuilder banner = new StringBuilder("love ");
        LocalsOnly instance = new LocalsOnly();
        Predicate<String> p = instance.getPredicate(banner);
        System.out.println(p.test("never dies!") + " " + banner);
    }

    public Predicate<String> getPredicate(StringBuilder banner) {   // (1)
        List<String> words = new ArrayList<>();                       // (2)
        words.add("Tom"); words.add("Dick"); words.add("Harriet");

//  banner = new StringBuilder();         // (3) Illegal: Not effectively final
//  words = new ArrayList<>();            // (4) Illegal: Not effectively final
        List<String> words2 = new ArrayList<>();


        return str -> {                                 // (5) Lambda expression
//    String banner = "Don't redeclare me!";        // (6) Illegal: Redeclared
//    String[] words = new String[6];               // (7) Illegal: Redeclared
            System.out.println("List: " + words);         // (8) Local variable
            banner.append(str);                           // (9) Parameter
            words2.add("smth");
            banner.append(" ");
            banner.append(words2);
            return str.length() > 5;
        };

    }
}
