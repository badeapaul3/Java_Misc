package devguideocp.A3_1_Declarations;

/**
 * @author hatzp
 **/
public class MethOverload {
    public static void main(String[] args) {
        //Several method implementations may have the same name, as long as the method signatures differ
        //signature does not include return type!!!
        //e.g.

        //double cubeVolume(double length, double width, double height) {}
        //has the signature
        //cubeVolume(double, double, double)



//        public static double min(double a, double b)
//        public static float min(float a, float b)
//        public static int min(int a, int b)
//        public static long min(long a, long b)
//
//        void methodA(int a, double b) { /* ... */ }      // (1)
//        int  methodA(int a)           { return a; }      // (2)
//        int  methodA()                { return 1; }      // (3)
//        long methodA(double a, int b) { return b; }      // (4)
//        long methodA(int x, double y) { return x; }      // (5) Not OK.
        //WHY?Because:
//        methodA(int, double)      1'
//        methodA(int)j             2': Number of parameters
//        methodA()                 3': Number of parameters
//        methodA(double, int)      4': Order of parameters
//        methodA(int, double)      5': Same as 1'




    }
}
