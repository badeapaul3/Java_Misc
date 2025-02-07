package devguideocp.Part5_C22to26.A23_1_Concurrency2;

import java.util.concurrent.Executor;

/**
 * @author hatzp
 **/
class SimpleExecutor implements Executor {
    @Override
    public void execute(Runnable task) {

        new Thread(task).start();         // (1a) Asynchronous call
//  task.run();                       // (1b) Synchronous call. Not recommended.
    }
}