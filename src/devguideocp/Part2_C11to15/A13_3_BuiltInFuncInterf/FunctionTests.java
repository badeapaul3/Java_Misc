package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.util.function.*;

/**
 * @author hatzp
 **/
public class FunctionTests {
    public static void main(String[] args) {

        Function<Integer, Boolean> boolExpr = i -> 50 <= i && i < 100;
        System.out.println("Boolean expression is: " + boolExpr.apply(99));
// Boolean expression is: true

        Function<Integer, Double> milesToKm = miles -> 1.6 * miles;
        System.out.printf("%dmi = %.2fkm%n", 24, milesToKm.apply(24));
// 24mi = 38.40km

        Function<Double, Double> milesToKms = miles -> 1.6 * miles;
        System.out.printf("%.2f mi = %.2f m%n", 24.452, milesToKms.apply(24.452));
// 24mi = 38.40km


    }
}
