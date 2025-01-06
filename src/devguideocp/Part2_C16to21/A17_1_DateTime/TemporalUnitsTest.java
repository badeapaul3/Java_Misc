package devguideocp.Part2_C16to21.A17_1_DateTime;

import java.time.*;
import java.time.temporal.*;


/**
 * @author hatzp
 **/
public class TemporalUnitsTest {
    public static void main(String[] args) {


        System.out.println(ChronoUnit.HOURS.getDuration());
        System.out.println(ChronoUnit.WEEKS.getDuration());


        System.out.println(ChronoUnit.HOURS.isDateBased());
        System.out.println(ChronoUnit.HOURS.isTimeBased());

        System.out.println(ChronoUnit.YEARS.isSupportedBy(LocalTime.MIDNIGHT));

        LocalDate date = LocalDate.of(2021, 10, 23);
        System.out.print("Date " + date);
        date = date.minus(10, ChronoUnit.MONTHS).minus(3, ChronoUnit.DAYS);
        System.out.println(" minus 10 months and 3 days: " + date);
// Date 2021-10-23 minus 10 months and 3 days: 2020-12-20

        LocalTime time = LocalTime.of(14, 15);
        System.out.print("Time " + time);
        time = time.plus(9, ChronoUnit.HOURS).plus(70, ChronoUnit.MINUTES);
        System.out.println(" plus 9 hours and 70 minutes is " + time);
// Time 14:15 plus 9 hours and 70 minutes is 00:25

        LocalDate fromDate = LocalDate.of(2021, 3, 1);
        LocalDate xmasDate = LocalDate.of(2021, 12, 25);
        long tilChristmas = fromDate.until(xmasDate, ChronoUnit.DAYS);
        System.out.println("From " + fromDate + ", days until Xmas: " + tilChristmas);
// From 2021-03-01, days until Xmas: 299



        //ChronoField Enum
        System.out.println(ChronoField.YEAR.isSupportedBy(LocalTime.MIDNIGHT));

        LocalDate date2 = LocalDate.of(2021, 8, 13);
        int monthValue = date2.get(ChronoField.MONTH_OF_YEAR);
        System.out.print("Date " + date2 + " has month of the year: " + monthValue);
// Date 2021-08-13 has month of the year: 8


        LocalDateTime dateTime = LocalDateTime.of(2021, 8, 13, 20, 20);
        System.out.print("Date-time " + dateTime);
        dateTime = dateTime.with(ChronoField.DAY_OF_MONTH, 11)
                .with(ChronoField.MONTH_OF_YEAR, 1)
                .with(ChronoField.YEAR, 2022);
        System.out.println(" changed to: " + dateTime);
// Date-time 2021-08-13T20:20 changed to: 2022-01-11T20:20



    }
}
