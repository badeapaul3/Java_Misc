package devguideocp.Part5_C22to26.A22_2_ConcurrencyMore;

/**
 * @author hatzp
 **/
public class ThreadPriorityTest {
    public static void main(String[] args) {

        Thread myThread = new Thread(() ->
                System.out.println(Thread.currentThread() + ": Don't mess with my priority!")
        );
        System.out.println(myThread);
        myThread.setPriority(Math.min(Thread.MAX_PRIORITY, myThread.getPriority() + 1));
        myThread.start();

    }


}
