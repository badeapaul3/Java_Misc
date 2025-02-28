package devguideocp.Part5_C22to26.A23_2_Concurrency2More;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements ICounter {
    private AtomicInteger counter = new AtomicInteger(0);         // (1)

    @Override
    public int getValue() {                                                 // (2)
        return counter.get();
    }

    @Override
    public void increment() {                                               // (3)
        counter.incrementAndGet();                                          // (4)

        //equivalent with incrementAndGet
//  while (true) {                                                        // (5)
//    int expectedValue = counter.get();                                  // (6)
//    int newValue = expectedValue + 1;                                   // (7)
//    if (counter.compareAndSet(expectedValue, newValue)) {// (8) Compare and Set.
//      return;                                            // (9)
//    }
//  }
    }
}
