package devguideocp.Part2_C16to21.A18_1_Localization;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class LocatingBundles {
    public static void main(String[] args) {

        Locale[] locales = {
                Locale.of("no", "NO"),                             // Norway
                Locale.CANADA_FRENCH,                               // Canada (French)
                Locale.FRENCH,                                      // French
                Locale.getDefault(),                                // Default: en_US
        };

        for (Locale locale: locales) {
            System.out.println("Locating resource bundles for " + locale + " locale:");
            ResourceBundle resources = ResourceBundle.getBundle("devguideocp.Part2_C16to20.A18_1_Localization.MyResources",
                    locale);
            for (String key : new TreeSet<>(resources.keySet())) {               // (1)
                System.out.println(resources.getString(key));
            }
            System.out.println();
        }
    }
}