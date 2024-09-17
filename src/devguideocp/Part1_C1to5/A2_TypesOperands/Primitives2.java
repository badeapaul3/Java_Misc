package devguideocp.Part1_C1to5.A2_TypesOperands;

/**
 * @author hatzp
 **/
public class Primitives2 {
    public static void main(String[] args) {
//        byte b = 3;           // int literal in range. Narrowing conversion.
//        b = (byte) -b;        // Cast required on assignment.

        double  dr0 =  7.0  %  7.0;    //  0.0
        float   fr1 =  7.0F %  5.0F;   //  2.0F
        double  dr1 =  7.0  % -5.0;    //  2.0
        float   fr2 = -7.0F %  5.0F;   // -2.0F
        double  dr2 = -7.0  % -5.0;    // -2.0
        boolean fpRelation = dr2  == (-7.0) - (-5.0) * (long)(-7.0 / -5.0);  // true
        float   fr3 = -7.0F %  0.0F;   // NaN

        int  r0 =  7  %  7;     //  0
        int  r1 =  7  %  5;     //  2
        long r2 =  7L % -5L;    //  2L
        int  r3 = -7  %  5;     // -2
        long r4 = -7L % -5L;    // -2L
        boolean relation = -7L == (-7L / -5L) * -5L + r4;  // true

        byte   b = 32;
        char   c = 'z';                              // Unicode value 122 (\u007a)
        short  s = 256;
        int    i = 10000;
        float  f = 3.5F;
        double d = 0.5;
        double v = (d * i) + (f * -b) - (c / s);     // (1) 4888.0D
        System.out.println("Value of v: " + v);



    }
}
