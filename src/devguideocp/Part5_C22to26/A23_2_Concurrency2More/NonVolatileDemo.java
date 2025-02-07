package devguideocp.Part5_C22to26.A23_2_Concurrency2More;

/** Potential problem with visibility of shared data. */
public class NonVolatileDemo {

    private static boolean stopThread = false;             // (1)

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {                        // (2)
            new Thread(() -> {
                while (!stopThread) {                            // (3)
                    System.out.println(Thread.currentThread().getName()
                            + ": Get me out of here!");
                }
            }, "T" + i).start();
        }
        Thread.sleep(1);                                     // (4)
        stopThread = true;                                   // (5)
    }
}