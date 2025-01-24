package devguideocp.Part5_C22to26.A22_2_ConcurrencyMore;


public class ThreadStates {

    private static Thread t1 = new Thread("T1") {    // (1)
        @Override public void run() {
            try {
                sleep(1);                            // (2)
                for (int i = 100; i > 0; i--) {
                    System.out.println("a");
                }        // (3)
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        System.out.println(t1.getState());              // (4)
        t1.start();
        int i=0;
        while (true) {                                  // (5)
            Thread.State state = t1.getState();
            System.out.println(i++);
            System.out.println(state);
            if (state == Thread.State.TERMINATED) {
                break;
            }
        }
    }
}
