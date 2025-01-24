package devguideocp.Part5_C22to26.A22_2_ConcurrencyMore;



class CounterX {
    private int counter = 0;

    public synchronized void increment() {                            // (1a)
//public void increment() {                                         // (1b)
        System.out.println(Thread.currentThread().getName()
                + ": old:" + counter + " new:" + ++counter);
    }

    public void increment2() {
        synchronized(this) {                                // Synchronized statement
            System.out.println(Thread.currentThread().getName()
                    + ": current: " + counter + " new:" + ++counter);
        }
    }

    //BankAccount account;
//    public void updateTransaction() {
//        synchronized (account) {       // (1) synchronized statement
//            account.update();            // (2)
//        }
//    }

//A static synchronized method classAction() in class A is equivalent to the following declaration

    //static void classAction() {
    //  synchronized (A.class) {       // Synchronized statement on class A
    //    // ...
    //  }
    //}

}
