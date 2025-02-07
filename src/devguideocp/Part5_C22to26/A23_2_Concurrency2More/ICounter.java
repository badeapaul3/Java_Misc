package devguideocp.Part5_C22to26.A23_2_Concurrency2More;

/** Interface that defines a basic counter. */
interface ICounter {                                                      // (1)
    void increment();
    int getValue();
}
