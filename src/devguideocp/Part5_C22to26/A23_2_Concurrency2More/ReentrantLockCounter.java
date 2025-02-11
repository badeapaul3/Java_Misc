package devguideocp.Part5_C22to26.A23_2_Concurrency2More;

import java.util.concurrent.locks.*;

public class ReentrantLockCounter implements ICounter {               // (1)

    private Lock rl = new ReentrantLock();                              // (2)
    //Lock frl = new ReentrantLock(true);  // Fair reentrant lock - the acquisition order is that the longest-waiting thread for the lock is chosen to acquire the released lock
    private int counter = 0;                                            // (3)

    @Override
    public int getValue() {                                             // (4)
        rl.lock();
        try {
            return counter;
        } finally { rl.unlock(); }
    }

    @Override
    public void increment() {                                           // (5)
        rl.lock();
        try {
            counter++;                                                      // (6)
            getValue();                                                     // (7)
        } finally { rl.unlock(); }
    }

//reentrant
//frl.lock();
//frl.lock();
//// Access the resource. Lock hold count is 2.
//frl.unlock();
//frl.unlock();










}