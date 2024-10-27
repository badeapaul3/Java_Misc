package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.util.*;
import java.util.function.*;

/**
 * @author hatzp
 **/
public class LambdaContexts {
    public static void main(String[] args) {

        //declaration and assignment statements
        DoubleFunction cToF = x -> 1.8 * x + 32.0;           // double -> double
        ToIntFunction<String> lenFunc1 = s -> s.length();    // String -> int
        ToIntFunction<String> lenFunc2 = String::length;     // String -> int
        lenFunc1 = s -> Integer.parseInt(s);                 // String -> int
        lenFunc2 = Integer::parseInt;                        // String -> int


        //Method and Constructor Calls
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.forEach(i -> System.out.println(i));   // Target type: Consumer<Integer>
        numbers.forEach(System.out::println);


        //Expressions in return Statements
// Client code:
        IntUnaryOperator y = createLinearFormula(10, 5);  // 10 * x + 5
        y.applyAsInt(2);                                  // 25


        //Ternary Conditional Expressions
        int ii = 10;
        IntUnaryOperator iFunc1 = ii % 2 == 0 ? i -> i * 2 : j -> j + 1;   // int -> int
        iFunc1.applyAsInt(4);                                              // 8
//IntUnaryOperator iFunc2 = ii % 2 == 0 ? i -> i * 2
//                          : s -> Integer.parseInt(s);   // Compile-time error!



        //Cast Expressions
        System.out.println(((IntUnaryOperator) i -> i * 2).applyAsInt(10));        // 20
        System.out.println(((DoubleUnaryOperator) i -> i * 2).applyAsDouble(10.0));// 20.0


        // Object obj1 = StringBuilder::new;                 // Compile-time error!
        Object obj2 = (Function<String, StringBuilder>) StringBuilder::new;

        Object uFunc1 = (IntUnaryOperator) i -> i * 2;
        if (uFunc1 instanceof DoubleUnaryOperator) {                     // (1) false
            DoubleUnaryOperator uFunc2 = (DoubleUnaryOperator) uFunc1;     // (2)
            uFunc2.applyAsDouble(10.0);                                    // (3)
        }




        //nested lambda

        Supplier<Supplier<String>> f = () -> () -> "Hi";
        //The target type for the nested lambda expressions is inferred from the context, which is an assignment statement to a reference of type Supplier<Supplier<String>>.
        // The inner lambda expression () -> "Hi" is inferred to be of target type Supplier<String>, as its type () -> String is compatible with
        // the function type of this target type. The outer lambda expression is then inferred to have the type () -> Supplier<String> which is compatible with the target
        // type Supplier<Supplier<String>>.

        //testing the concept:
        Supplier<Function<String,String>> myf = () -> s -> s.concat(s);
        System.out.println(myf.get().apply("test"));



    }


    static IntUnaryOperator createLinearFormula(int a, int b) {
        return x -> a * x + b;      // int -> int
    }
}
