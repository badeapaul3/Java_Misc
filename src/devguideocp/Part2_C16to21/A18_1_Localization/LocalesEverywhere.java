package devguideocp.Part2_C16to21.A18_1_Localization;

import java.util.Locale;
public class LocalesEverywhere {

    public static void main(String[] args) {

        Locale locDF = Locale.getDefault();              // (1)
        //constructors deprecated
        //factory methods used currently
        //Locale locNO2 =  new Locale("no", "NO");          // Locale: Norwegian/Norway
        Locale locNO =  Locale.of("no", "NO");          // Locale: Norwegian/Norway
        //Locale locFR2 =  new Locale("fr", "FR");          // Locale: French/France
        Locale locFR =  Locale.of("fr", "FR");          // Locale: French/France

        System.out.println("Default locale is: " + locDF.getDisplayName());
        System.out.println("Display country (language) for Norwegian locale:");

        System.out.printf("In %s: %s (%s)%n", locDF.getDisplayCountry(),
                locNO.getDisplayCountry(locDF), locNO.getDisplayLanguage(locDF));

        System.out.printf("In %s: %s (%s)%n", locNO.getDisplayCountry(),
                locNO.getDisplayCountry(locNO), locNO.getDisplayLanguage(locNO));

        System.out.printf("In %s: %s (%s)%n", locFR.getDisplayCountry(),
                locNO.getDisplayCountry(locFR), locNO.getDisplayLanguage(locFR));

        System.out.println("\nChanging the default locale.");
        Locale.setDefault(Locale.GERMANY);               // (2) Locale: German/Germany
        locDF = Locale.getDefault();
        System.out.println("Default locale is: " + locDF.getDisplayName());
        System.out.printf("Interpreting %s locale information in %s locale.%n",
                locNO.getDisplayName(), locDF.getDisplayName());
    }
}
