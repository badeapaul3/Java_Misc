package devguideocp.Part5_C22to26.A22_1_Concurrency;

public class Counter2 extends Thread {
    public int currentValue;
    public Counter2() { this.currentValue = 0; }
    public int getValue() { return this.currentValue; }

    @Override
    public void run() {                         // (1) Override from superclass.
        while (this.currentValue < 5) {
            System.out.printf("%s: %s%n",
                    super.getName(),           // (2) Print thread name,
                    this.currentValue++);      //     current value, and increment.
            try {
                Thread.sleep(500);                    // (3) Current thread sleeps.
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " interrupted.");
            }
        }
        System.out.println("Exiting " + super.getName());
    }
}
