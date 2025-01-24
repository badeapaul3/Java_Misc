package devguideocp.Part5_C22to26.A22_1_Concurrency;

/**
 * @author hatzp
 **/
public class ThreadTest {

    public static void main(String[] args) {

        Thread thread = new Thread(
                () -> System.out.println("1 Harmonious threads create beautiful applications.")
        );
        thread.start();

        (new Thread() {
            @Override
            public void run() {
                System.out.println("2 Harmonious threads create beautiful applications.");
            }
        }
        ).start();

        (new Thread(() -> System.out.println("3 Harmonious threads create beautiful applications."))
        ).start();


    }
}
