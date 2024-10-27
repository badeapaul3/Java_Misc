package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author hatzp
 **/
public class ConsumerTests {
    public static void main(String[] args) {

        Consumer<Double> formatter = d -> System.out.printf("Value: %.2f%n", d);
        formatter.accept(3.145);                     // Value: 3.15


        StringBuilder sb1 = new StringBuilder("Banana");
        Consumer<StringBuilder> resizeSB = sb -> sb.setLength(4);
        resizeSB.accept(sb1);                        // Bana
        Consumer<StringBuilder> reverseSB = sb -> sb.reverse();
        reverseSB.accept(sb1);                       // anaB

        Consumer<StringBuilder> printSB
                = sb -> System.out.println("StringBuilder: " + sb);
        printSB.accept(sb1);                         // StringBuilder: anaB

        List<String> words = new ArrayList<>();
        words.add("Otto"); words.add("ADA"); words.add("Alyla");
        words.add("Bob"); words.add("HannaH"); words.add("Java");

        words.forEach(s -> System.out.print(s.toLowerCase() + " "));
// otto ada alya bob hannah java

// [Otto, ADA, Alya, Bob, HannaH, Java]
        words.forEach(new Consumer<String>() {
            public void accept(String s) {

                System.out.print(s.toLowerCase() + " ");
            }
        });
// otto ada alya bob hannah java
        System.out.println();
        // [Otto, ADA, Alya, Bob, HannaH, Java]
        words.forEach(s -> {if (s.length() % 2 == 0) System.out.print(s + " ");});
// Otto Alya HannaH Java
        System.out.println();
        resizeSB.andThen(reverseSB)
                .andThen(printSB).accept(new StringBuilder("Banana")); // StringBuilder: anaB


        IntConsumer sqrt = i -> System.out.printf("%.2f%n", Math.sqrt(i));
        IntConsumer sqr = i -> System.out.printf("%d%n", i * i);
        sqrt.andThen(sqr).accept(9);    // 3.87
        // 225



        BiConsumer<String, Double> formatPrinter
                = (format, obj) -> System.out.printf(format, obj);
        formatPrinter.accept("Math.PI:|%10.3f|%n", Math.PI); // Math.PI:|     3.142|


        ObjIntConsumer<StringBuilder> resizeSB2 = (sb, len) -> sb.setLength(len);
        StringBuilder sb2 = new StringBuilder("bananarama");
        resizeSB2.accept(sb2, 6);      // The required length passed as a parameter.
        System.out.println("StringBuilder resized: " + sb2);
// StringBuilder resized: banana


    }
}
