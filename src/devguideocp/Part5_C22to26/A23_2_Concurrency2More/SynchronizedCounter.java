package devguideocp.Part5_C22to26.A23_2_Concurrency2More;

public class SynchronizedCounter implements ICounter  {
    private int counter = 0;

    @Override public synchronized int getValue() { return counter; }
    @Override public synchronized void increment() { counter++; }
}
