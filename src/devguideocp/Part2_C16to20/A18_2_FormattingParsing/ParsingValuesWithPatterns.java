package devguideocp.Part2_C16to20.A18_2_FormattingParsing;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsingValuesWithPatterns {
    public static void main(String[] args) {
        String pattern = "foo {0,number,currency} bar";                      // (1)
        MessageFormat mfp = new MessageFormat(pattern, Locale.US);
        Object[] arguments = new Object[] {10.99};            // [10.99]
        String formattedResult = mfp.format(arguments);       // "foo $10.99 bar"

        try{
            Object[] parsedResult = mfp.parse(formattedResult);
            System.out.println((double)arguments[0] == (double)parsedResult[0]); // true
        } catch (ParseException pe){pe.printStackTrace();}




    }
}
