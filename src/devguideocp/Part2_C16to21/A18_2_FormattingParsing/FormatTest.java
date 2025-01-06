package devguideocp.Part2_C16to21.A18_2_FormattingParsing;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatTest {
    public static void main(String[] args) {

        //number formatting
        double num = 12345.6789;                                // (1a)
// BigDecimal num = new BigDecimal("12345.6789");       // (1b)

        Locale locNOR = Locale.of("no", "NO");                 // Norway
        NumberFormat nfNOR = NumberFormat.getNumberInstance(locNOR);
        System.out.println(nfNOR.format(num));                  // 12 345,679

        NumberFormat nfUS = NumberFormat.getNumberInstance(Locale.US);
        System.out.println(nfUS.format(num));                   // 12,345.679

        //currency format
        NumberFormat cfNOR = NumberFormat.getCurrencyInstance(locNOR);
        String formattedCurrStr = cfNOR.format(num);
        System.out.println(formattedCurrStr);              // kr 12 345,68 (with 2 nbsp) non breaking space  \u00a0 vs usual space \u0020

        NumberFormat cfUS = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedCurrStrUS = cfUS.format(num);
        System.out.println(formattedCurrStrUS);            // $12,345.68


        //Percentage format
        double rebate = 0.746;
        NumberFormat pfNOR = NumberFormat.getPercentInstance(locNOR);
        String formattedPStr = pfNOR.format(rebate);
        System.out.println(formattedPStr);                 // 75 %  (with nbsp)

        NumberFormat pfUS = NumberFormat.getPercentInstance(Locale.US);
        String formattedPStrUS = pfUS.format(rebate);
        System.out.println(formattedPStrUS);               // 75%

        System.out.println(pfUS.format(0.745));            // 74%

        //accounting formatting
        NumberFormat df0 = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(df0.format(-9.99));            // -$9.99

        //en: Represents the English language
        //US: Represents the United States
        //u: Indicates that a Unicode locale/language extension is specified as a key–value pair
        //cf-account: The key–value pair, where the key cf stands for currency format, and the value account means to use parentheses for negative numbers

        Locale loc = Locale.forLanguageTag("en-US-u-cf-account");   // (1)
        NumberFormat df = NumberFormat.getCurrencyInstance(loc);    // (2)
        System.out.println(df.format(-9.99));                       // ($9.99)


    }
}
