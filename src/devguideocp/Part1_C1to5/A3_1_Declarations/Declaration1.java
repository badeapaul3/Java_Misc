package devguideocp.Part1_C1to5.A3_1_Declarations;

/**
 * @author hatzp
 **/
public class Declaration1 {
    public static void main(String[] args) {
        double weight = 10.0;
        double thePrice = 1;                    // (1) Local variables

        if (weight <  10.0) thePrice = 20.50;
        if (weight >  50.0) thePrice = 399.00;
        if (weight >= 10.0) thePrice = weight * 10.0;      // (2) Always executed
        System.out.println("The price is: " + thePrice);   // (3) Compile-time error if in line 9 we do not initialize thePrice

    }
}
