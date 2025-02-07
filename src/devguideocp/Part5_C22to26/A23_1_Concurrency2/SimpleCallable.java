package devguideocp.Part5_C22to26.A23_1_Concurrency2;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author hatzp
 **/
public class SimpleCallable {
    public static void main(String[] args) {

        Random rng = new Random();
        Callable<Integer> dice = () -> rng.nextInt(1,7);  // (1)
        try {
            Integer diceValue = dice.call();     // (2)
            System.out.println(diceValue);       // Prints a value in the interval [1,6].
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
