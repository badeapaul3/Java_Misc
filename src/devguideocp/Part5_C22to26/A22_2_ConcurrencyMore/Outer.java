package devguideocp.Part5_C22to26.A22_2_ConcurrencyMore;

/**
 * @author hatzp
 **/
public class Outer {                      // (1) Top-level Class
    private double count;            // (2)
    protected class Inner {          // (3) Non-static member Class
        public void incr() {           // (4)
            synchronized(Outer.this) {   // (5) Synchronized statement on Outer object
                ++count;                   // (6)
            }
        }
    }
}
