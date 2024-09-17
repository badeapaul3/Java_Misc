package devguideocp.Part1_C1to5.A5_7_OOP_Interfaces;

/**
 * @author hatzp
 **/
/** Class Shopper implements IShopper interface */

public class Shopper implements IShopper {

    @Override
    public double getItemPrice() {
        return 100.00;
    }

    public static void main(String[] args) {
        Shopper customer = new Shopper();
        var price = customer.getItemPrice();
        System.out.println("Item price: " + price);
        var salePrice = customer.getSalePrice(price); // Calls default method at (2)
        System.out.println();
        IShopper.startSale();                         // Calls static method at (5)
    }
}