package devguideocp.Part5_C22to26.A22_3_ConcurrencyIssues;

public class DeadLockDanger {
    public static void main(String[] args) {
        String o1 = "o1 " ;                                         // (1)
        String o2 = "o2 ";                                          // (2)

        Thread t1 = (new Thread("t1") {                             // (3)
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                while (true) {
                    synchronized(o1) {                                    // (4)
                        System.out.println(threadName + " acquired " + o1);
                        synchronized(o2) {                                  // (5)
                            System.out.println(threadName + ": " + o1 + o2);
                        }}}}});

        Thread t2 = (new Thread("t2") {                             // (6)
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                while (true) {
                    synchronized(o2) {                                    // (7)
                        System.out.println(threadName + " acquired " + o2);
                        synchronized(o1) {                                  // (8)
                            System.out.println(threadName + ": " + o2 + o1);
                        }}}}});

        //However, the potential of a deadlock in the situation in Example 22.9 is easy to fix. If the two threads acquire the locks on the objects in the same order,
        // then mutual lock dependency is avoided and a deadlock can never occur. This means having the same locking order at (4) and (5) as at (7) and (8).
        // In general, the cause of a deadlock is not always easy to discover, let alone easy to fix.
        t1.start();                                                 // (9)
        t2.start();                                                 // (10)
        System.out.println("Exiting main.");                        // (11)
    }
}
