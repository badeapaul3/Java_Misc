package devguideocp.Part5_C22to26.A23_3_Concurrency3More;

import java.util.concurrent.TimeUnit;

public class ConcUtil {
    public static void snooze(int timeout, TimeUnit unit) {
        String threadName = Thread.currentThread().getName();
        try {
            unit.sleep(timeout);
        } catch (InterruptedException ex) {
            System.out.println(threadName + ": " + ex);
            Thread.currentThread().interrupt();         // Reinstate interrupt status.
        }
    }
}