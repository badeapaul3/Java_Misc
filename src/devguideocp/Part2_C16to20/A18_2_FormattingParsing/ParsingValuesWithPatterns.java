package devguideocp.Part2_C16to20.A18_2_FormattingParsing;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;
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

            String patternA = "{0}";                                             // (2)
            MessageFormat mfpA = new MessageFormat(patternA, Locale.US);
            Object[] parsedResultA = mfpA.parse("One Two Three");                // (3)
            System.out.println(parsedResultA[0] instanceof String);   // true
            System.out.println(Arrays.toString(parsedResultA));       // (4) [One Two Three]

            String patternB = "One {0} Three";                                   // (5)
            MessageFormat mfpB = new MessageFormat(patternB, Locale.US);
            Object[] parsedResultB = mfpB.parse("One 2 Three");                  // (6)
            System.out.println(parsedResultB[0].equals("2"));                    // true
            System.out.println(Arrays.toString(parsedResultB));                  // [2]

            Object[] parsedResultC = mfpB.parse("One 2 Three whatever");         // (7)
            System.out.println(Arrays.toString(parsedResultC));                  // [2]

            String patternD = "foo {0,number,integer} {1,number,currency} bar";  // (8)
            MessageFormat mfpD = new MessageFormat(patternD, Locale.US);
            Object[] parsedResultD = mfpD.parse("foo 2021 $64.99 bar");          // (9)
            System.out.println(Arrays.toString(parsedResultD));         // [2021, 64.99]


            Locale locale = new Locale("no", "NO");
            String pattern1 = "foo {0,number,currency} bar";
            MessageFormat mfp1 = new MessageFormat(pattern1, locale);
            // String parseSource = "foo kr 10,99 bar";               // (10a) ParseException
            String parseSource = "foo kr\u00a010,99 bar";             // (10b) nbsp. OK.
            Object[] parsedResults = mfp1.parse(parseSource);
            if (parsedResults[0] instanceof Double dValue) {
                System.out.println(dValue);                             // 10.99
            }





        } catch (ParseException pe){pe.printStackTrace();}




    }
}
