package devguideocp.Part2_C16to20.A20_1_JavaIO;

import java.io.Console;

/**
 * @author hatzp
 **/
public class ConsoleTest {
    public static void main(String[] args) {

        // Obtaining the console:
        Console console = System.console();
        if (console == null) {
            System.err.println("No console available.");
            return;
        }

        String username = console.readLine("Enter the username (%d chars): ", 4);
        char[] password;
        do {
            password = console.readPassword("Enter password (min. %d chars): ", 6);
        } while (password.length < 6);



    }
}
