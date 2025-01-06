package devguideocp.Part2_C16to21.A17_1_DateTime;

import java.time.*;

/**
 * @author hatzp
 **/
public class TestingDateTime {
    public static void main(String[] args) {

        LocalTime time1 = LocalTime.of(8, 15, 35, 900);   // 08:15:35.000000900
        LocalTime time2 = LocalTime.of(16, 45);           // 16:45
// LocalTime time3 = LocalTime.of(25, 13, 30);    // DateTimeException
//HH:mm:ss.SSSSSSSSS

        LocalDate date1 = LocalDate.of(1969, 7, 20);            // 1969-07-20
        LocalDate date2 = LocalDate.of(-3113, Month.AUGUST, 11);// -3113-08-11
//  LocalDate date3 = LocalDate.of(2021, 13, 11);       // DateTimeException
//  LocalDate date4 = LocalDate.of(2021, 2, 29);        // DateTimeException
//uuuu-MM-dd

        // 2021-04-28T12:15
        LocalDateTime dt1 = LocalDateTime.of(2021, 4, 28, 12, 15);
// 2021-08-19T14:00
        LocalDateTime dt2 = LocalDateTime.of(2021, Month.AUGUST, 19, 14, 0);
//uuuu-MM-ddTHH:mm:ss.SSSSSSSSS

        // LocalDate date1 is 1969-07-20.
        LocalDateTime dt3 = LocalDateTime.of(date1, LocalTime.NOON); // 1969-07-20T12:00
        LocalDateTime dt4 = LocalTime.of(12, 0).atDate(date1);       // 1969-07-20T12:00
        LocalDateTime dt5 = date1.atTime(LocalTime.NOON);            // 1969-07-20T12:00
        LocalDateTime dt6 = date1.atTime(12, 0);                     // 1969-07-20T12:00


//now()
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();




    }
}
