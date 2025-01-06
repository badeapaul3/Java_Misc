package devguideocp.Part2_C16to21.A18_2_FormattingParsing;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ParsingTest {
    public static void main(String[] args) {

        double num = 12345.6789;                                // (1a)
// BigDecimal num = new BigDecimal("12345.6789");       // (1b)

        Locale locNOR = Locale.of("no", "NO");                 // Norway
        NumberFormat nfNOR = NumberFormat.getNumberInstance(locNOR);
        System.out.println(nfNOR.format(num));                  // 12 345,679

        NumberFormat nfUS = NumberFormat.getNumberInstance(Locale.US);
        System.out.println(nfUS.format(num));                   // 12,345.679
        System.out.println("\n@@@@@@@@@@@@@@@@\n");

        try {
            System.out.println(nfNOR.parse("9876.598"));     // (1) 9876
            System.out.println(nfNOR.parse("9876,598"));     // (2) 9876.598

            System.out.println(nfUS.parse("9876.598"));      // (3) 9876.598
            System.out.println(nfUS.parse("9876,598"));      // (4) 9876598
        }
        catch (Exception e){e.printStackTrace();}

        try {
            DecimalFormat dfUS = (DecimalFormat) nfUS;
            dfUS.setParseBigDecimal(true);
            BigDecimal bd = (BigDecimal) dfUS.parse("9876,598");
            System.out.println(bd);
        }
        catch (Exception e){e.printStackTrace();}

        //currency format
        NumberFormat cfNOR = NumberFormat.getCurrencyInstance(locNOR);
        String formattedCurrStr = cfNOR.format(num);
        System.out.println(formattedCurrStr);              // kr 12 345,68 (with 2 nbsp) non breaking space  \u00a0 vs usual space \u0020

        NumberFormat cfUS = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedCurrStrUS = cfUS.format(num);
        System.out.println(formattedCurrStrUS);            // $12,345.68

        try{
            //seems an update was done to the NO locale regarding the currency position
            //System.out.println(cfNOR.parse("kr\u00a09876.59"));        // (1) 9876
            System.out.println(cfNOR.parse("9876,59\u00a0kr"));        // (1) 9876.59
            //System.out.println(cfNOR.parse("kr\u00a09876,59"));        // (2) 9876.59
            //System.out.println(cfNOR.parse("kr\u00a09 876,59"));       // (3) 9
           // System.out.println(cfNOR.parse("kr\u00a09\u00a0876,59"));  // (4) 9876.59

            System.out.println(cfUS.parse("$9876.59"));                // (5) 9876.59
        }
        catch (Exception e){e.printStackTrace();}

        NumberFormat pfNOR = NumberFormat.getPercentInstance(locNOR);
        NumberFormat pfUS = NumberFormat.getPercentInstance(Locale.US);
        try{
            System.out.println(pfNOR.parse("15,75\u00a0%"));           // (1) 0.1575
            System.out.println(pfUS.parse("25.5%"));                   // (2) 0.255

        }
        catch (Exception e){e.printStackTrace();}










    }
}
