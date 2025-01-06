package devguideocp.Part2_C16to21.A17_1_DateTime;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Set;

public class TimeZonesAndDaylightSavings {
    public static void main(String[] args) {

        //3 classes - ZoneId, ZoneOffset, ZonedDateTime
//        ZoneId.getAvailableZoneIds()                 // Prints a long list of zone names.
//                .stream()
//                .sorted()
//                .forEachOrdered(System.out::println);


        ZoneId estZID = ZoneId.of("US/Eastern");              // Create a time zone ID.
        System.out.println(estZID);                           // US/Eastern
        System.out.println(ZoneId.systemDefault());           //
        System.out.println(ZoneId.systemDefault().getRules());           //
        System.out.println(ZoneId.systemDefault().getId());           //

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);

        //ZonedDateTime - objects are not comparable

        ZonedDateTime defaultZDT = ZonedDateTime.now();                          // (1a)
        ZonedDateTime utcZDT     = ZonedDateTime.now(ZoneId.of("UTC"));          // (2a)
        ZonedDateTime edtZDT     = ZonedDateTime.now(ZoneId.of("US/Eastern"));   // (3a)
        System.out.println("Default Zone Date-time:  " + defaultZDT);
        System.out.println("UTC Date-time:           " + utcZDT);
        System.out.println("EDT Zone Date-time:      " + edtZDT);



        LocalTime concertTime = LocalTime.of(00, 10);                  // 00:10
        LocalDate concertDate = LocalDate.of(1973, Month.JANUARY, 14); // 1973-01-14
        LocalDateTime concertDT = LocalDateTime.of(concertDate,
                concertTime);  // 1973-01-14T00:10
        ZoneId hwZID = ZoneId.of("US/Hawaii");                    // US/Hawaii
        Instant instantZ = Instant.ofEpochSecond(95854200);       // 1973-01-14T10:10:00Z

        //create from parts
        ZonedDateTime concertZDT0 = ZonedDateTime.of(concertDate, concertTime, hwZID);
        ZonedDateTime concertZDT1 = ZonedDateTime.of(concertDT, hwZID);
        ZonedDateTime concertZDT2 = ZonedDateTime.ofInstant(instantZ, hwZID);
        // 1973-01-14T00:10-10:00[US/Hawaii]
        boolean areEqual = concertZDT0.equals(concertZDT1)
                && concertZDT0.equals(concertZDT2);      // true

        ZonedDateTime concertZDT3 = concertDT.atZone(hwZID);
        ZonedDateTime concertZDT4 = instantZ.atZone(hwZID);
        System.out.println(concertDT);
        System.out.println(concertZDT3);
        // 1973-01-14T00:10-10:00[US/Hawaii]


        ZonedDateTime concertZDT5
                = ZonedDateTime.parse("1973-01-14T00:10-10:00[US/Hawaii]");


// Using ChronoField constants:
        int theDay = concertZDT0.get(ChronoField.DAY_OF_MONTH);          // 14
        int theMonthValue = concertZDT0.get(ChronoField.MONTH_OF_YEAR);  // 1
        int theYear = concertZDT0.get(ChronoField.YEAR);                 // 1973

// Using specific get methods:
        int theMonthValue2 = concertZDT0.getMonthValue();                // 1
        Month theMonth     = concertZDT0.getMonth();                     // JANUARY


// Extracting constituent parts:
        LocalTime theTime     = concertZDT0.toLocalTime();         // 00:10
        LocalDate theDate     = concertZDT0.toLocalDate();         // 1973-01-14
        LocalDateTime theDT   = concertZDT0.toLocalDateTime();     // 1973-01-14T00:10
        Instant theInstant = concertZDT0.toInstant();
        System.out.println(theInstant);
        ZoneId theZID         = concertZDT0.getZone();             // US/Hawaii
        ZoneOffset theZoffset = concertZDT0.getOffset();           // -10:00

        ZonedDateTime theZDT = concertZDT0         // 1973-01-14T00:10-10:00[US/Hawaii]
                .withYear(1977)                        // 1977-01-14T00:10-10:00[US/Hawaii]
                .with(ChronoField.MONTH_OF_YEAR, 8)    // 1977-08-14T00:10-10:00[US/Hawaii]
                .withDayOfMonth(16)                    // 1977-08-16T00:10-10:00[US/Hawaii]
                .with(ChronoField.HOUR_OF_DAY, 9)      // 1977-08-16T09:10-10:00[US/Hawaii]
                .with(ChronoField.MINUTE_OF_HOUR, 30)
                .withZoneSameLocal(ZoneId.of("Europe/Bucharest")); // 1977-08-16T09:30-10:00 - my execercise

        System.out.println(theZDT);

        ZoneId cTZ = ZoneId.of("US/Central");
        ZonedDateTime zdtSameLocal = theZDT.withZoneSameLocal(cTZ);            // (1)
        System.out.printf("%23s %25s%n", "ZonedDateTime", "Instant");
        System.out.printf("%-35s %s%n", theZDT, theZDT.toInstant());
        System.out.printf("%-35s %s%n", zdtSameLocal, zdtSameLocal.toInstant());


        ZonedDateTime zdtSameInstant = theZDT.withZoneSameInstant(cTZ);        // (2)
        System.out.printf("%23s %25s%n", "ZonedDateTime", "Instant");
        System.out.printf("%-35s %s%n", theZDT, theZDT.toInstant());
        System.out.printf("%-35s %s%n", zdtSameInstant, zdtSameInstant.toInstant());

        //SEE DSTAdjustment program
        //Daylight Savings in US/Central starts at 2021-03-14T02:00 (spring forward 1 hour).
        //                    ___________ZonedDateTime__________
        //                       Date    Time  Offset    TZ       DST   UTC
        //(1) Before gap:     2021-03-14 01:30 -06:00 US/Central false 07:30
        //    + 1 hour
        //(2) After gap:      2021-03-14 03:30 -05:00 US/Central true  08:30


        //Daylight Savings in US/Central ends at 2021-11-07T02:00 (fall back 1 hour).
        //                    ___________ZonedDateTime__________
        //                       Date    Time  Offset    TZ       DST   UTC
        //(1) Before overlap: 2021-11-07 00:30 -05:00 US/Central true  05:30
        //    + 1 hour
        //(2) In overlap:     2021-11-07 01:30 -05:00 US/Central true  06:30
        //    + 1 hour
        //(3) In overlap:     2021-11-07 01:30 -06:00 US/Central false 07:30
        //    + 1 hour
        //(4) After overlap:  2021-11-07 02:30 -06:00 US/Central false 08:30

        ZonedDateTime zdt2 = ZonedDateTime.of(
                LocalDate.of(2021, 11, 7),
                LocalTime.of(1, 30),                // Time 01:30 in the overlap.
                ZoneId.of("US/Central"));
        System.out.println(zdt2);               // 2021-11-07T01:30-05:00[US/Central]

        ZonedDateTime zdt3 = ZonedDateTime.of(
                LocalDate.of(2021, 3, 14),
                LocalTime.of(0, 0), ZoneId.of("US/Central")).withHour(2); // Time 02:00 is in the gap.
        System.out.println(zdt3);            // 2021-03-14T03:00-05:00[US/Central]

        ZonedDateTime zdt4 = ZonedDateTime.of(
                LocalDate.of(2021, 11, 7), LocalTime.of(1, 0), ZoneId.of("US/Central")
        ).withMinute(30);                 // Time 01:30 is in the overlap.
        System.out.println(zdt4);           // 2021-11-07T01:30-05:00[US/Central]

        ZonedDateTime zdtBeforeOverlap = ZonedDateTime.of(
                LocalDate.of(2021, 11, 7),
                LocalTime.of(0, 30),             // Time 00:30 is before the DST crossover.
                ZoneId.of("US/Central"));

        // Date units and time units.
        System.out.printf("%s + 1 day    = %s%n",
                zdtBeforeOverlap, zdtBeforeOverlap.plusDays(1));        // (1) Add 1 day.
        System.out.printf("%s + 24 hours = %s%n",
                zdtBeforeOverlap, zdtBeforeOverlap.plusHours(24));      // (2) Add 24 hours.
//2021-11-07T00:30-05:00[US/Central] + 1 day    = 2019-11-04T00:30-06:00[US/Central]
//2021-11-07T00:30-05:00[US/Central] + 24 hours = 2021-11-07T23:30-06:00[US/Central]







    }
}
