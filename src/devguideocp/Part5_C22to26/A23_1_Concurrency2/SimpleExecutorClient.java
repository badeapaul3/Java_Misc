package devguideocp.Part5_C22to26.A23_1_Concurrency2;

/**
 * @author hatzp
 **/
public class SimpleExecutorClient {
    public static void main(String[] args) {

        SimpleExecutor executor = new SimpleExecutor();
        Runnable task = () -> System.out.println("Executing task ...");
        executor.execute(task);
    }
}
