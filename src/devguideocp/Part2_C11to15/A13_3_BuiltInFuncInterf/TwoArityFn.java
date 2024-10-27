package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * @author hatzp
 **/
public class TwoArityFn {
    public static void main(String[] args) {

        BiFunction<Double, Double, Double> areaOfRectangle
                = (length, width) -> length * width;            // (Double, Double) -> Double
        System.out.printf("%.2f x %.2f = %.2f%n",
                25.0, 4.0, areaOfRectangle.apply(25.0, 4.0));
// 25.00 x 4.00 = 100.00

        Map <String,String> map = new HashMap<>();
        map.put("Anne", "Mary");
        map.put("Anne2", "Mary2");
        map.put("Anne3", "Mary3");

        BiFunction<String, String, String> concatKeyVal = (key, val) -> key.concat(val);

        map.replaceAll(concatKeyVal);

        System.out.println(map);

        map.replaceAll(new BiFunction<String, String, String>() {
            public String apply(String key, String val) {
                return key.concat(val);
            }
        });
        System.out.println(map);






        BiFunction<String, String, String> concatStr = (s1, s2) -> s1 + s2;
        Function<String, String> postfix1 = s -> s + "nana";

        Function<String, String> postfix2 = s -> s + "s!";
        System.out.println(concatStr.andThen(postfix1).andThen(postfix2)
                .apply("I am going", " ba"));         // I am going bananas!

//        BiFunction<String, String, String> concatTwice
//                = concatStr.andThen(concatStr);           // Compile-time error!

        ToIntBiFunction<String, String> addIntStrs
                = (s1, s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);
        System.out.println("10 + 20 = " + addIntStrs.applyAsInt("10", "20"));
// 10 + 20 = 30



        //UnaryOperator<T> interface extends the Function<T, T> interface
        UnaryOperator<Double> area = r -> Math.PI * r * r;
        System.out.printf("Area of circle, radius %.2f: %.2f%n", 10.0, area.apply(10.0));
// Area of circle, radius 10.00: 314.16

        UnaryOperator<Double> milesToKms = miles -> 1.6 * miles;
        System.out.printf("%.2fmi = %.2fkm%n", 24.0, milesToKms.apply(24.0));
// 24.00mi = 38.40km


        List<String> team = Arrays.asList("Tom", "Dick", "Harriet");
        UnaryOperator<String> toUpper = str -> str.toUpperCase();
        team.replaceAll(toUpper);     // [TOM, DICK, HARRIET]

        UnaryOperator<String> f = s -> s + "-One";
        UnaryOperator<String> g = s -> s + "-Two";
        System.out.println(f.compose(g).apply("Three")); // Three-Two-One
        System.out.println(f.andThen(g).apply("Three")); // Three-One-Two


        DoubleUnaryOperator celsiusToFahrenheit = celsius -> 1.8 * celsius + 32.0;
        System.out.printf("%.1f Celsius = %.1f Fahrenheit%n",
                25.0, celsiusToFahrenheit.applyAsDouble(25.0));
// 25.0 Celsius = 77.0 Fahrenheit

        DoubleUnaryOperator kms = miles -> 1.6 * miles;
        System.out.printf("%.2fmi = %.2fkm%n", 25.0, kms.applyAsDouble(25.0));
// 25.00mi = 40.00km

        IntUnaryOperator incrBy1 = i -> i + 1;
        IntUnaryOperator multBy2 = i -> i * 2;
        System.out.println(incrBy1.compose(multBy2).applyAsInt(4)); // 9
        System.out.println(incrBy1.andThen(multBy2).applyAsInt(4)); // 10

        BinaryOperator<Double> areaOfRectangle2 = (length, width) -> length * width;
        System.out.printf("%.2f x %.2f = %.2f%n",
                25.0, 4.0, areaOfRectangle2.apply(25.0, 4.0));
// 25.00 x 4.00 = 100.00

        BinaryOperator<String> concatTwo = (s1, s2) -> s1 + s2;
        UnaryOperator<String> postfix12 = s -> s + "nana";
        UnaryOperator<String> postfix22 = s -> s + "s!";
        System.out.println(concatTwo.andThen(postfix12).andThen(postfix22)
                .apply("I am going", " ba"));     // I am going bananas!


        String maxStr = BinaryOperator.maxBy(String.CASE_INSENSITIVE_ORDER)
                .apply("aha", "Madonna");             // Madonna
        String minStr = BinaryOperator.minBy(String.CASE_INSENSITIVE_ORDER)
                .apply("aha", "Madonna");             // aha


        DoubleBinaryOperator areaOfRectangle3 = (length, width) -> length * width;
        System.out.printf("%.2f x %.2f = %.2f%n",
                25.0, 4.0, areaOfRectangle3.applyAsDouble(25.0, 4.0));
// 25.00 x 4.00 = 100.00

    }
}
