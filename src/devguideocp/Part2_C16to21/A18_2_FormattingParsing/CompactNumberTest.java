package devguideocp.Part2_C16to21.A18_2_FormattingParsing;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompactNumberTest {
    public static void main(String[] args) {

        NumberFormat shortCompactFormat = NumberFormat.getCompactNumberInstance(
                Locale.US, NumberFormat.Style.SHORT);
        NumberFormat longCompactFormat = NumberFormat.getCompactNumberInstance(
                Locale.US, NumberFormat.Style.LONG);

        System.out.println(shortCompactFormat.format(9_400_000));    // 9M
        System.out.println(longCompactFormat.format(9_400_000));     // 9 million

        shortCompactFormat.setMaximumFractionDigits(2);
        longCompactFormat.setMaximumFractionDigits(2);

        System.out.println(shortCompactFormat.format(9_400_000));    // 9M
        System.out.println(longCompactFormat.format(9_400_000));     // 9 million
        try {
            System.out.println(shortCompactFormat.parse("9M"));        // 9000000
            System.out.println(longCompactFormat.parse("9 million"));  // 9000000
        } catch (ParseException pe) {
            System.out.println(pe);
        }



    }
}
