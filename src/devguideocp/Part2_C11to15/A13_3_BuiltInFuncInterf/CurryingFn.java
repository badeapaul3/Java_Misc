package devguideocp.Part2_C11to15.A13_3_BuiltInFuncInterf;

import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;

/**
 * @author hatzp
 **/
public class CurryingFn {
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R compute(T t, U u, V v);             // (T, U ,V) -> R
    }

    public static void main(String[] args) {
// (Double, Double, Double) -> Double
        TriFunction<Double, Double, Double, Double> cubeVol = (x, y, z) -> x * y * z;
        System.out.println(cubeVol.compute(10.0,  20.0,  30.0));  // 6000.0



        //CURRYING PROCESS to reduce a multi-argument fns into a chain of lower arity fns
        //by Haskell Curry

        // Step 1:
// Partial application: double -> DoubleFunction<DoubleUnaryOperator>
        DoubleFunction<DoubleFunction<DoubleUnaryOperator>> uniFuncA
                = (x -> (y -> (z -> x * y * z)));              // (1)


        // Step 2:
// Partial application: double -> DoubleUnaryOperator
        DoubleFunction<DoubleUnaryOperator> uniFuncB
                = uniFuncA.apply(10.0);

        // Step 3:
// Partial application: double -> double
        DoubleUnaryOperator uniOpC = uniFuncB.apply(20.0); // 10.0 * 20.0 * z


        // Step 4:
// Application:
        double vol1 = uniOpC.applyAsDouble(30.0);      // (2) 10.0 * 20.0 * 30.0 = 6000.0
        double vol2 = uniFuncA.apply(10.0).apply(20.0).applyAsDouble(30.0); // (3) 6000.0





    }
}
