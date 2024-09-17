package devguideocp.Part1_C1to5.A2_TypesOperands;

/**
 * @author hatzp
 **/
public class Primitives {
    public static void main(String[] args) {

        int    smallOne = 1234;               // No widening necessary.
        long   bigOne   = 2020;               // Widening: int to long.
        double largeOne = bigOne;             // Widening: long to double.
        double hugeOne  = (double) bigOne;    // Cast redundant but allowed.


        long bigInteger = 98765432112345678L;
        float fpNum = bigInteger;  // Widening but loss of precision: 9.8765436E16

        int result = 100;               // Not a constant variable. Not declared final.
        final char finalGrade = 'A';    // Constant variable. ’A’

        System.out.printf("%d%n%s%n%d%n%.2f%n%b%n%d%n%d%n",
                2022,                       // Constant expression. 2022
                "Trust " + "me!",           // Constant expression. "Trust me"
                2 + 3 * 4,                  // Constant expression. 14
                Math.PI * Math.PI * 10.0,   // Constant expression. 98.70
                finalGrade == 'A',          // Constant expression. true
                Math.min(2020, 2021),       // Not constant expression. Method call.
                ++result                    // Not constant expression. Increment operator.
        );


        // Conditions fulfilled for implicit narrowing primitive conversions.
        short s1 = 10;       // int value in range.
        short s2 = 'a';      // char value in range.
        char c1 = 32;        // int value in range.
        char c2 = (byte)35;  // byte value in range. (int value in range, without cast.)
        //byte b1 = 40;        // int value in range.
        byte b2 = (short)40; // short value in range. (int value in range, without cast.)
        final int i1 = 20;   // Constant variable
        byte b3 = i1;        // final value of i1 in range.

        // Conditions not fulfilled for implicit narrowing primitive conversions.
        // A cast is required.
        int i2 = -20;            // i2 is not a constant variable. i2 is not final.
        final int i3 = i2;       // i3 is not a constant variable, since i2 is not.
        final int i4 = 200;      // i4 is a constant variable.
        final int i5;            // i5 is not a constant variable.
        short s3 = (short) i2;   // Not constant expression.
        char  c3 = (char)  i3;   // Final value of i3 not determinable at compile time.
        char  c4 = (char)  i2;   // Not constant expression.
        byte  b4 = (byte)  128;  // int value not in range.
        byte  b5 = (byte)  i4;   // Value of constant variable i4 is not in range.
        i5 = 100;                // Initialized at runtime.
        short s4 = (short) i5;   // Final value of i5 not determinable at compile time.


        // The value is truncated to fit the size of the target type.
        float huge   = (float) 1.7976931348623157d;  // double to float.
        long  giant  = (long)  4415961481999.03D;    // (1) double to long.
        int   big    = (int)   giant;                // (2) long to int.
        short small  = (short) big;                  // (3) int to short.
        byte  tiny   = (byte)  small;                // (4) short to byte.
        char  symbol = (char)  112.5F;               // (5) float to char.


        Boolean   boolRef = true;  // Boxing.
        Byte      bRef =  2;       // Constant in range: narrowing, then boxing.
// Byte  bRef2 =  257;     // Constant not in range. Compile-time error!

        short s = 10;              // Narrowing from int to short.
// Integer   iRef1 = s;    // short not assignable to Integer.
        Integer iRef3 = (int) s;   // Explicit widening with cast to int and boxing

        boolean bv1 = boolRef;     // Unboxing.
        byte  b1 = bRef;           // Unboxing.
        int   iVal = bRef;         // Unboxing and widening.

        Integer iRefVal = null;           // Always allowed.
// int j = iRefVal;               // NullPointerException at runtime.
        if (iRef3 != null) iVal = iRef3;  // Avoids exception at runtime.
    }
}
