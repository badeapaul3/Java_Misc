package devguideocp.Part1_C1to5.A5_7_OOP_Interfaces;

/**
 * @author hatzp
 **/
// File: JavaParty.java
interface ISlogan {
    default void printSlogan() {                       // (1)
        System.out.println("Happiness is getting certified!");
    }
}
//_______________________________________________________________________________
class JavaGuru implements ISlogan {
    @Override
    public void printSlogan() {                        // (2) overrides (1)
        System.out.println("Happiness is catching all the exceptions!");
    }
}
//_______________________________________________________________________________
class JavaGeek implements ISlogan { }                // (3) inherits (1)
//_______________________________________________________________________________
public class JavaParty {
    public static void main(String[] args) {
        JavaGuru guru = new JavaGuru();
        guru.printSlogan();                              // (4)
        JavaGeek geek = new JavaGeek();
        geek.printSlogan();                              // (5)
    }
}
