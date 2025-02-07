package devguideocp.Part5_C22to26.A23_2_Concurrency2More;

public class VolatileCounter implements ICounter {
    private volatile int counter = 0;

    @Override public int getValue()   { return counter; }
    @Override public void increment() { ++counter; }
}