package devguideocp.Part2_C16to20.A17_1_DateTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Durations {
    public static void main(String[] args) {

        Duration d1 = Duration.ofDays(1L);                               // PT24H
        Duration d2 = Duration.ofHours(24L);                             // PT24H
        Duration d3 = Duration.ofMinutes(24L*60);                        // PT24H
        Duration d4 = Duration.ofSeconds(24L*60*60);                     // PT24H
        Duration d5 = Duration.ofMillis(24L*60*60*1000);                 // PT24H
        Duration d6 = Duration.ofSeconds(24L*60*60 - 1, 1_000_000_000L); // (1) PT24H
        Duration d7 = Duration.ofNanos(24L*60*60*1_000_000_000); // (2) PT24H
        Duration d8 = Duration.ofNanos(24*60*60*1_000_000_000);  // (3) PT-1.857093632S
        System.out.println(d8);


        Duration d11 = Duration.of(1L, ChronoUnit.DAYS);                        // P24H
        Duration d22 = Duration.of(24L, ChronoUnit.HOURS);                      // P24H
        Duration d33 = Duration.of(24L*60, ChronoUnit.MINUTES);                 // P24H
        Duration d44 = Duration.of(24L*60*60, ChronoUnit.SECONDS);              // P24H
        Duration d88 = Duration.of(24L*60*60*1000, ChronoUnit.MILLIS);          // P24H
        Duration d77 = Duration.of(24L*60*60*1_000_000_000, ChronoUnit.NANOS);  // P24H









    }
}
