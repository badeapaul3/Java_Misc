package devguideocp.Part2_C16to21.A18_2_FormattingParsing;

import java.text.*;
import java.time.*;
import java.util.*;

public class CompoundMessageFormatting {
    static void displayStockInfo(Locale requestedLocale) {                  // (1)
        System.out.println("Requested Locale: " + requestedLocale);

        // Fetch the relevant resource bundle:                                   (2)
        ResourceBundle bundle =
                ResourceBundle.getBundle("devguideocp.Part2_C16to20.A18_2_FormattingParsing.StockInfoBundle", requestedLocale);

        // Create a formatter, given the pattern and the locale:                 (3)
        MessageFormat mf = new MessageFormat(bundle.getString("pattern"),
                requestedLocale);

        // Argument values:                                                      (4)
        String itemName = bundle.getString("item.name");
        double itemPrice = Double.parseDouble(bundle.getString("item.price"));
        int numOfItems = 1234;
        Date timeOnly = new Date(LocalTime.of(14,30).toEpochSecond(LocalDate.now(),ZoneOffset.UTC));
        Date dateOnly = new Date(LocalDate.of(2021,3,1).toEpochSecond(LocalTime.now(),ZoneOffset.UTC));

        // Create argument array:                                                (5)
        Object[] messageArguments = {
                itemName,       // {0}
                itemPrice,      // {1,number,currency}
                numOfItems,     // {2,number,integer}
                timeOnly,       // {3,time,short}
                dateOnly,       // {4,date,long}
        };

        // Apply the formatter to the arguments:                                 (6)
        String result = mf.format(messageArguments);
        System.out.println(result);
    }

    public static void main(String[] args) {
        displayStockInfo(Locale.US);
        System.out.println();
        displayStockInfo(Locale.of("es", "ES"));
        System.out.println();
    }
}