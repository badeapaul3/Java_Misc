package devguideocp.Part5_C22to26.A22_3_ConcurrencyIssues;

public class Diggers {
    //STARVATION
    public static void main(String[] args) {
        Hole hole = new Hole();                                          // (4)
        for (int i = 0; i < 5; i++) {                                    // (5)
            new Thread(() -> hole.dig()).start();
        }
    }
}