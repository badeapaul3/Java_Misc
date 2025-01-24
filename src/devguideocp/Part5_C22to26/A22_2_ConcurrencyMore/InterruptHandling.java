package devguideocp.Part5_C22to26.A22_2_ConcurrencyMore;

/**
 * @author hatzp
 **/
public class InterruptHandling {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(task, "worker");                   // (1)
        worker.start();
        while (true) {
            int x = (int)(Math.random()*100);// (2)
            System.out.println(x);
            if (x % 2 == 0) {
                System.out.println("worker state "+worker.getState());
                worker.interrupt();
                break;
            }
            Thread.sleep(2);
        }
    }

    private static Runnable task = () -> {                          // (3)
        Thread ct = Thread.currentThread();
        String threadName = ct.getName();
        while (true) {                                                // (4)
            System.out.println(threadName + " performing task");
            System.out.println("ct state " + ct.getState());
            if (ct.isInterrupted()) {                                   // (5)
                System.out.println(threadName + ": interrupted flag is "
                        + ct.isInterrupted());
                System.out.println(threadName + " terminating");
                return;
            }

            try {                                                        // (6)
                Thread.sleep(2);
            } catch (InterruptedException e) {                           // (7)
                System.out.println(threadName + " caught " + e);
                System.out.println(threadName + ": interrupted flag is "
                        + ct.isInterrupted());
                System.out.println(threadName + " terminating");
                return;
            }
        }
    };
}
