package devguideocp.Part2_C16to20.A17_1_DateTime;

import java.time.*;
import java.time.temporal.*;
import java.util.List;

/**
 * @author hatzp
 **/
public class Periods {

    public static void main(String[] args) {

        Period p = Period.of(2, 4, 8).negated();         // (1)
        System.out.println(p);                 // (2) P2Y4M8D (2 Years, 4 Months, 8 Days)
        Period p1 = Period.ofYears(10);        // P10Y, period of 10 years.
        Period p2 = Period.ofMonths(14);       // P14M, period of 14 months.
        Period p3 = Period.ofDays(40);         // P40D, period of 40 days.
        Period p4 = Period.ofWeeks(2);         // P14D, period of 14 days (2 weeks).

        Period period = Period.ofYears(3).ofMonths(4).ofDays(5); // P5D. Logical error. only days set

        LocalDate d1 = LocalDate.of(2021, 3, 1);  // 2021-03-01
        LocalDate d2 = LocalDate.of(2022, 3, 1);  // 2022-03-01
        Period period12 = Period.between(d1, d2); // P1Y
        Period period21 = Period.between(d2, d1); // P-1Y

        Period period2 = Period.parse("P1Y15M20D"); // 1 year, 15 months, 20 days
        Period period3 = Period.parse("P20D");      // 20 days
        Period period4 = Period.parse("P5W");       // 35 days (5 weeks)
//  Period pX = Period.parse("P24H"); // java.time.format.DateTimeParseException

        Period myp = Period.ZERO;
        Boolean isPeriodNegative = myp.isNegative();
        Period mypNegated = myp.negated();
        System.out.println(mypNegated.isNegative());

        Period period5 = Period.of(2, 4, -10);
        System.out.println("Period: " + period5);             // Period: P2Y4M-10D
        System.out.println("Years:  " + period5.getYears());  // Years:  2
        System.out.println("Months: " + period5.getMonths()); // Months: 4
        System.out.println("Days:   " + period5.getDays());   // Days:   -10

        System.out.println("Years:  " + period5.get(ChronoUnit.YEARS)); // Years:  2
        System.out.println("Months: " + period5.get(ChronoUnit.MONTHS));// Months: 4
        System.out.println("Days:   " + period5.get(ChronoUnit.DAYS));  // Days: -10
        List<TemporalUnit> supportedUnits = period5.getUnits(); // [Years, Months, Days]

        System.out.println("Total months: " + period5.toTotalMonths()); // 28 months
        System.out.println(period5.isNegative());                       // true
        System.out.println(period5.isZero());                           // false

        //does not implement Comparable. equality is based on the fields being equal
        Period px = Period.of(1, 14, 0);
        Period py = Period.of(2, 2, 0);
        Period pz = Period.ofMonths(26);
        System.out.println(px.equals(py));           // false
        System.out.println(px.equals(pz));           // false
        System.out.println(px.equals(Period.ZERO));  // false

        Period p5 = Period.of(2, 1, 30) // P2Y1M30D
                .withYears(3)               // P3Y1M30D, sets the number of years
                .withMonths(16)             // P3Y16M30D, sets the number of months
                .withDays(1);               // P3Y16M1D, sets the number of days

        Period p6 = Period.of(2, 10, 30)  // P2Y10M30D
                .plusDays(10)                 // P2Y10M40D
                .plusMonths(8)                // P2Y18M40D
                .plusYears(1)                 // P3Y18M40D
                .normalized();                // P4Y6M40D


        Period p7 = Period.of(1, 1, 1);               // P1Y1M1D
        Period p8 = Period.of(2, 12, 30);             // P2Y12M30D
        System.out.println(p8);
        Period p9 = p8.minus(p7);                     // P1Y11M29D
        p8 = p8.plus(p7).plus(p8);                    // P3Y13M31D, P5Y25M61D
        System.out.println(p8);
        p8 = p8.plus(p8);
        System.out.println(p8);

        //simple arithmetic with date and periods
        Period p10 = Period.of(1, 1, 1);               // P1Y1M1D
        LocalDate date1 = LocalDate.of(2021, 3, 1);    // 2021-03-01
        LocalDate date2 = date1.plus(p10);             // 2022-04-02
        LocalDate date3 = date1.minus(p10);            // 2020-01-31

        //Period is not time related
        LocalTime time = LocalTime.NOON;
       // time = time.plus(p10);     // java.time.temporal.UnsupportedTemporalTypeException







    }
}
