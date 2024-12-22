package devguideocp.Part2_C16to20.A17_1_DateTime;

import java.time.Period;

/**
 * @author hatzp
 **/
public class Periods {

    public static void main(String[] args) {

        Period p = Period.of(2, 4, 8);         // (1)
        System.out.println(p);                 // (2) P2Y4M8D (2 Years, 4 Months, 8 Days)
        Period p1 = Period.ofYears(10);        // P10Y, period of 10 years.
        Period p2 = Period.ofMonths(14);       // P14M, period of 14 months.
        Period p3 = Period.ofDays(40);         // P40D, period of 40 days.
        Period p4 = Period.ofWeeks(2);         // P14D, period of 14 days (2 weeks).






    }
}
