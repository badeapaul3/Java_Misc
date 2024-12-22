package devguideocp.Part2_C16to20.A17_1_DateTime;

import java.time.*;
import java.time.temporal.*;

/**
 * @author hatzp
 **/
public class TemporalCalculus {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2021, 10, 23);             // 2021-10-23
        date = date.plusMonths(10).plusWeeks(3).plusDays(40);    // Method chaining
        System.out.println(date);                                // 2022-10-23
        date = date.minus(2, ChronoUnit.DAYS)
                .minus(4, ChronoUnit.WEEKS)
                .minus(11, ChronoUnit.MONTHS);                // Method chaining
        System.out.println(date);                                // 2021-10-23



        LocalTime witchingHour = LocalTime.MIDNIGHT              // 00:00
                .plusHours(14)                                       // 14:00
                .plusMinutes(45)                                     // 14:45
                .plusMinutes(30)                                     // 15:15
                .minusHours(15)                                      // 00:15
                .minusMinutes(15);                                   // 00:00

        LocalDate date5 = LocalDate.of(2020, 2, 29);  // Original: 2020-02-29
        date5 = date5.plusYears(1);                   // Expected: 2021-02-29
        System.out.println("Date5: " + date5);        // Adjusted: 2021-02-28


        LocalTime busDep = LocalTime.of(12, 15);                   // 12:15
        Duration d1 = Duration.ofMinutes(30);                      // PT30M
        LocalTime nextBusDep = busDep.plus(d1);                    // 12:45

        LocalDate birthday = LocalDate.of(2020, 10, 23);           // 2020-10-23
        Period p1 = Period.ofYears(1);                             // P1Y
        LocalDate nextBirthday = birthday.plus(p1);                // 2021-10-23


        LocalDate currentDate = LocalDate.now();
        LocalDate newYearDay = currentDate.plusYears(1).withMonth(1).withDayOfMonth(1);
        long daysToNewYear = currentDate.until(newYearDay, ChronoUnit.DAYS); // (1)
        System.out.println("Current Date: " + currentDate); // Current Date: 2021-03-08
        System.out.println("New Year's Day: " + newYearDay);// New Year's Day: 2022-01-01
        System.out.println("Days to New Year: " + daysToNewYear);// Days to New Year: 299


//        long minsToMidnight = LocalDateTime.now()             // (1) DateTimeException!
//                .until(LocalTime.MIDNIGHT.minusSeconds(1), ChronoUnit.MINUTES);

        //mysolution
        long minsToMidnight = LocalDateTime.now()             // (1) DateTimeException!
                .until(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT), ChronoUnit.MINUTES);
        System.out.println(minsToMidnight);
        System.out.println(Duration.ofMinutes(minsToMidnight));
        System.out.println(Duration.ofMinutes(minsToMidnight).get(ChronoUnit.SECONDS));

        long minsToMidnight2 = LocalTime.now()                 // (2)
                .until(LocalTime.MIDNIGHT.minusSeconds(1), ChronoUnit.MINUTES);
        System.out.println(minsToMidnight2);


        LocalDate date6 = LocalDate.of(2021, 10, 23);           // (1)
        System.out.println("date6:             " + date6);       // 2021-10-23
        date6 = date6.plusMonths(10);                            // (2)
        System.out.println("10 months after:  " + date6);       // 2022-08-23
        date6 = date6.plusWeeks(3);                              // (3)
        System.out.println("3 weeks after:    " + date6);       // 2022-09-13
        date6 = date6.plusDays(40);                              // (4)
        System.out.println("40 days after:    " + date6);       // 2022-10-23

        date6 = date6.minus(2, ChronoUnit.DAYS);                 // (5)
        System.out.println("2 days before:    " + date6);       // 2022-10-21
        date6 = date6.minus(4, ChronoUnit.WEEKS);                // (6)
        System.out.println("4 weeks before:   " + date6);       // 2022-09-23
        date6 = date6.minus(11, ChronoUnit.MONTHS);              // (7)
        System.out.println("11 months before: " + date6);       // 2021-10-23




    }
}
