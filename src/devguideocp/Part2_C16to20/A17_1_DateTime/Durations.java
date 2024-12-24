package devguideocp.Part2_C16to20.A17_1_DateTime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.lang.System.out;

public class Durations {
    public static void main(String[] args) {
        //NOTE - Durations implemement comparable, based on total length


        Duration d1 = Duration.ofDays(1L);                               // PT24H
        Duration d2 = Duration.ofHours(24L);                             // PT24H
        Duration d3 = Duration.ofMinutes(24L*60);                        // PT24H
        Duration d4 = Duration.ofSeconds(24L*60*60);                     // PT24H
        Duration d5 = Duration.ofMillis(24L*60*60*1000);                 // PT24H
        Duration d6 = Duration.ofSeconds(24L*60*60 - 1, 1_000_000_000L); // (1) PT24H
        Duration d7 = Duration.ofNanos(24L*60*60*1_000_000_000); // (2) PT24H
        Duration d8 = Duration.ofNanos(24*60*60*1_000_000_000);  // (3) PT-1.857093632S
        out.println(d8);


        Duration d11 = Duration.of(1L, ChronoUnit.DAYS);                        // P24H
        Duration d22 = Duration.of(24L, ChronoUnit.HOURS);                      // P24H
        Duration d33 = Duration.of(24L*60, ChronoUnit.MINUTES);                 // P24H
        Duration d44 = Duration.of(24L*60*60, ChronoUnit.SECONDS);              // P24H
        Duration d88 = Duration.of(24L*60*60*1000, ChronoUnit.MILLIS);          // P24H
        Duration d77 = Duration.of(24L*60*60*1_000_000_000, ChronoUnit.NANOS);  // P24H
        out.println(d77);
        Duration d99 = Duration.of(24L*60*60*1_000_000_000-1, ChronoUnit.NANOS);  // PT23H59M59.999999999S
        out.println(d99);


        Duration duration = Duration.ofDays(7).ofHours(24);   // PT24H. Logical error.


        LocalTime startTime = LocalTime.of(14, 30);                  // 14:30
        LocalTime endTime   = LocalTime.of(17, 45, 15);              // 17:45:15
        Duration interval1 = Duration.between(startTime, endTime);   // PT3H15M15S
        Duration interval2 = Duration.between(endTime, startTime);   // PT-3H-15M-15S

        //accessing time units
        Duration dx = Duration.ofSeconds(12L*60*60, 500_000_000L); // PT12H0.5S
        out.println(dx.getNano());                                 // 500000000
        out.println(dx.getSeconds());                              // 43200 (i.e. 12 hrs.)

        out.println(dx.get(ChronoUnit.NANOS));       // 500000000
        out.println(dx.get(ChronoUnit.SECONDS));     // 43200
        //out.println(dx.get(ChronoUnit.MINUTES));     // UnsupportedTemporalTypeException
        out.println(dx.getUnits());                  // [Seconds, Nanos]

        out.println("Days:    " + dx.toDays());      // Days:    0
        out.println("Hours:   " + dx.toHours());     // Hours:   12
        out.println("Minutes: " + dx.toMinutes());   // Minutes: 720
        out.println("Millis:  " + dx.toMillis());    // Millis:  43200500
        out.println("Nanos:   " + dx.toNanos());     // Nanos:   43200500000000


        Duration eatBreakFast = Duration.ofMinutes(20L);                // PT20M
        Duration eatLunch     = Duration.ofSeconds(30L*60);             // PT30M
        Duration eatSupper    = Duration.of(45L, ChronoUnit.MINUTES);   // PT45M

        out.println(eatBreakFast.equals(eatLunch));                     // false
        out.println(Duration.ofSeconds(0).equals(Duration.ZERO));       // true
        out.println(Duration.ofSeconds(30L*60).equals(eatLunch.withSeconds(1)));       //true
        out.println(eatLunch.withSeconds(1).withNanos(5));

        List<Duration> ld = Arrays.asList(eatSupper, eatBreakFast, eatLunch );
        Collections.sort(ld);                            // Natural order.
        out.println(ld);                                 // [PT20M, PT30M, PT45M]

    //arithmetic
        Duration max20H = Duration.ZERO                           // PT0S
                .plusHours(10)                  // PT10H
                .plusMinutes(10*60 + 30)        // PT20H30M
                .plusSeconds(6*60*60 + 15)      // PT26H30M15S
                .minusMinutes(2*60 + 30)        // PT24H15S
                .minusSeconds(15);              // PT24H


        Duration max20H2 =
                Duration.ZERO                                         // PT0S
                        .plus(10L,           ChronoUnit.HOURS)        // PT10H
                        .plus(10*60 + 30,    ChronoUnit.MINUTES)      // PT20H30M
                        .plus(6*60*60L + 15, ChronoUnit.SECONDS)      // PT26H3015S
                        .minus(2*60 + 30,    ChronoUnit.MINUTES)      // PT24H15S
                        .minus(15,           ChronoUnit.SECONDS);     // PT24H

        Duration eatBreakFast2 = Duration.ofMinutes(20L);                // PT20M
        Duration eatLunch2     = Duration.ofSeconds(30L*60);             // PT30M
        Duration eatSupper2    = Duration.of(45L, ChronoUnit.MINUTES);   // PT45M
        Duration totalTimeForMeals = eatBreakFast2                       // PT20M
                .plus(eatLunch2)                                             // PT50M
                .plus(eatSupper2);                                           // PT1H35M


        Duration result = Duration.ofSeconds(-100, -500_000_000) // -100.5 => PT-1M-40.5S
                .abs()           // abs(-100.5) = 100.5  => PT1M40.5S
                .multipliedBy(4) // 100.5*4 = 402 => PT6M42S
                .dividedBy(2);   // 402 / 2 = 201 => PT3M21S


        LocalTime timeA = LocalTime.of(14,45,30);                 // 14:45:30
        LocalDate dateA = LocalDate.of(2021, 4, 28);              // 2021-04-28
        LocalDateTime dateTimeA = LocalDateTime.of(dateA, timeA); // 2021-04-28T14:45:30

        Duration amount = Duration.ofMinutes(20);                 // PT20M

        timeA = timeA.plus(amount);                               // 15:05:30
        dateTimeA = dateTimeA.minus(amount);                      // 2021-04-28T14:25:30

        dateA = dateA.minus(amount);                 // UnsupportedTemporalTypeException




    }
}
