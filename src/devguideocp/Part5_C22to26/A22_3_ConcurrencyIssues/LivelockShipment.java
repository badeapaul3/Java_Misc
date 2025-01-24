package devguideocp.Part5_C22to26.A22_3_ConcurrencyIssues;

public class LivelockShipment {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Seller seller = new Seller();

        new Thread(() -> customer.makePaymentTo(seller)).start();            // (9)
        new Thread(() -> seller.shipTo(customer)).start();                   // (10)
    }
}