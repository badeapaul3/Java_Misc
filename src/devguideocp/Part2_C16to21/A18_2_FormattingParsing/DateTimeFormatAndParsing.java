package devguideocp.Part2_C16to21.A18_2_FormattingParsing;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
@author hatzp    
    **/

public class DateTimeFormatAndParsing {
    public static void main(String[] args) {

        LocalTime timex = LocalTime.of(12, 30, 15, 99);
        String strTime = timex.toString();                 // (1) 12:30:15.000000099
        LocalTime parsedTime = LocalTime.parse(strTime);  // (2)
        System.out.println(timex.toString().equals(parsedTime.toString())); // true

     //   LocalTime badTime = LocalTime.parse("12.30.15");  // DateTimeParseException

        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;     // (1)


        LocalDate datex = LocalDate.of(1935, 1, 8);
        System.out.println(df.format(datex));
        String strDate = datex.format(df);                            // (2) 1935-01-08
        LocalDate parsedDate = LocalDate.parse(strDate, df);         // (3)
        System.out.println(strDate + "|" +
                parsedDate.format(df));          // (4) 1935-01-08|1935-01-08


        LocalDateTime dateTimex = LocalDateTime.of(1935, 1, 8, 12, 45);
        String strDate2 = dateTimex.format(df);                       // (4) 1935-01-08
        LocalDate parsedDate2 = LocalDate.parse(strDate2, df);       // (5) LocalDate

        //String timeStr2 = LocalTime.NOON.format(df);   // UnsupportedTemporalTypeException
        //LocalTime time2 = LocalTime.parse("12:00", df);// DateTimeParseException



        //style based formatters for DateTime
        LocalTime time = LocalTime.of(14, 15, 30);             // 14:15:30
        LocalDate date = LocalDate.of(2021, 12, 1);            // 2021-12-01
        LocalDateTime dateTime = LocalDateTime.of(date, time); // 2021-12-01T14:15:30
// 2021-12-01T14:15:30-06:00[US/Central]
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("US/Central"));

        DateTimeFormatter dfs = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String str1 = date.format(dfs);           // 12/1/21
        String str2 = dateTime.format(dfs);       // Date part: 12/1/21
        String str3 = zonedDateTime.format(dfs);  // Date part: 12/1/21


        DateTimeFormatter tff = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        String str4 = zonedDateTime.format(tff);  // Time part:
        //   2:15:30 PM Central Standard Time
        //String str5 = time.format(tff);           // java.time.DateTimeException
        //String str6 = date.format(tff);           // java.time.temporal.//      UnsupportedTemporalTypeException
        //String str7 = dateTime.format(tff);       // java.time.DateTimeException

        DateTimeFormatter df1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);// (1)
        String inputStr = "2/29/21";                       // (2) en_US date, SHORT style
        LocalDate parsedDate1 = LocalDate.parse(inputStr, df1);    // (3)
        System.out.println(parsedDate1);                          // (4) 2021-02-28



        DateTimeFormatter dtff
                = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .localizedBy(Locale.FRANCE);          // (1)


// "mercredi 1 décembre 2021 à 14:15:30 heure normale du centre nord-américain"

        String charSeq = zonedDateTime.format(dtff);                 // (2)
        System.out.println(charSeq);
        LocalTime pTime = LocalTime.parse(charSeq, dtff);            // (3) 14:15:30
        LocalDate pDate = LocalDate.parse(charSeq, dtff);            // (4) 2021-12-01

// 2021-12-01T14:15:30
        LocalDateTime pDateTime = LocalDateTime.parse(charSeq, dtff);         // (5)

// 2021-12-01T14:15:30-06:00[America/Chicago]
        ZonedDateTime pZonedDateTime = ZonedDateTime.parse(charSeq, dtff);    // (6)
        System.out.println(pZonedDateTime);













    }
}
