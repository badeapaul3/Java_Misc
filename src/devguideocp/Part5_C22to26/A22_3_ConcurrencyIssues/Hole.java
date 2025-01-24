package devguideocp.Part5_C22to26.A22_3_ConcurrencyIssues;

public class Hole {                                                  // (1)
    public synchronized void dig() {
        String threadName = Thread.currentThread().getName();
        while (true) {                                                   // (2)
            System.out.println(threadName + " digging the hole.");
//    try {                                                          // (3)
//    wait(1);
//    } catch (InterruptedException ex) {
//      ex.printStackTrace();
//    }
        }
    }
}
