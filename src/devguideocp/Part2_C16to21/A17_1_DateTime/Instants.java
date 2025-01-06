package devguideocp.Part2_C16to21.A17_1_DateTime;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.lang.System.out;

/**
 * @author hatzp
 **/
public class Instants {
    public static void main(String[] args) {


        //uuuu-MM-ddTHH:mm:ss.SSSSSSSSSZ

        Instant currentInstant = Instant.now();      // 2024-12-18T10:48:01.914826Z
        out.println(Instant.now());

        Instant inst1 = Instant.ofEpochMilli(-24L*60*60*1000);// Date 1 day before epoch.
        Instant inst2 = Instant.ofEpochSecond(24L*60*60);     // Date 1 day after epoch.
        Instant inst3 = Instant.ofEpochSecond(24L*60*60 - 1,  // Date 1 day after epoch.
                1_000_000_000L);
        out.println("A day before: " + inst1); // Date 1 day before: 1969-12-31T00:00:00Z
        out.println("A day after:  " + inst2); // Date 1 day after : 1970-01-02T00:00:00Z
        out.println("A day after:  " + inst3); // Date 1 day after : 1970-01-02T00:00:00Z

        Instant inst4 = Instant.ofEpochSecond(0, 500);
        out.println("Default format:  " + inst4);       // 1970-01-01T00:00:00.000000500Z

        Instant instA = Instant.parse("1970-01-01T00:00:00.000000500Z");
        Instant instB = Instant.parse("1949-03-01T12:30:15Z");
        Instant instC = Instant.parse("-1949-03-01T12:30:15Z");
       // Instant instD = Instant.parse("-1949-03-01T12:30:15"); // DateTimeParseException!


//        LocalDateTime ldt = LocalDate.of(2021, 12, 25).atStartOfDay();  //(1)
//        Instant i1 = ldt.toInstant(ZoneOffset.of("+02:00"));     // (2) Ahead of UTC
//        Instant i2 = ldt.toInstant(ZoneOffset.UTC);              // (3) At UTC
//        Instant i3 = ldt.toInstant(ZoneOffset.of("-02:00"));     // (4) Behind UTC
//        System.out.println("ldt: " + ldt);
//        System.out.println("i1:  " + i1);
//        System.out.println("i2:  " + i2);
//        System.out.println("i3:  " + i3);

        Instant inst = Instant.ofEpochSecond(24L*60*60,    // 1 day and
                555_555_555L);// 555555555 ns after epoch.
        out.println(inst);                   // 1970-01-02T00:00:00.555555555Z
        out.println(inst.getNano());         // 555555555 ns
        out.println(inst.getEpochSecond());  // 86400 s

        out.println(inst.get(ChronoField.NANO_OF_SECOND));      // 555555555 ns
        out.println(inst.get(ChronoField.MICRO_OF_SECOND));     // 555555 micros
        out.println(inst.get(ChronoField.MILLI_OF_SECOND));     // 555 ms
        out.println(inst.getLong(ChronoField.INSTANT_SECONDS)); // 86400 s
//out.println(inst.get(ChronoField.INSTANT_SECONDS));   // DateTimeException
//out.println(inst.get(ChronoField.HOUR_OF_DAY));       // UnsupportedTemporal-
        // TypeException

        out.println(inst.toEpochMilli());                        // 86400555 ms



        Instant i0, i1, i2, i3;
        i0 = Instant.now();
        out.println(i0);                             // 2021-02-28T08:43:35.864Z
        i1 = i0.with(ChronoField.NANO_OF_SECOND,  500_000_000);// 500000000 ns.
        i2 = i0.with(ChronoField.MICRO_OF_SECOND, 500_000);    // 500000x1000 ns.
        i3 = i0.with(ChronoField.MILLI_OF_SECOND, 500);        // 500x1000000 ns.
        out.println(i1);                             // 2021-02-28T08:43:35.500Z

        out.println(i1.equals(i2));                  // true
        out.println(i1.equals(i3));                  // true

        Instant oneInstant = Instant.now()
                .with(ChronoField.MILLI_OF_SECOND, 500)
                .with(ChronoField.INSTANT_SECONDS, 24L*60*60);
        out.println(oneInstant);                     // 1970-01-02T00:00:00.500Z

        Instant event =
                Instant.EPOCH                    //            1970-01-01T00:00:00Z
                        .plusSeconds(7L*24*60*60) // (+7days)   1970-01-08T00:00:00Z
                        .plusSeconds(6L*60*60)    // (+6hrs)    1970-01-08T06:00:00Z
                        .plusSeconds(5L*60)       // (+5mins)   1970-01-08T06:05:00Z
                        .plusSeconds(4L)          // (+4s)      1970-01-08T06:05:04Z
                        .plusMillis(3L*100)       // (+3ms)     1970-01-08T06:05:04.003Z
                        .plusNanos(2L*1_000)      // (+2micros) 1970-01-08T06:05:04.003002Z
                        .plusNanos(1L);           // (+1ns)     1970-01-08T06:05:04.003002001Z


        Instant ptInTime =
                Instant.EPOCH                          // 1970-01-01T00:00:00Z
                        .plus(7L, ChronoUnit.DAYS)      // 1970-01-08T00:00:00Z
                        .plus(6L, ChronoUnit.HOURS)     // 1970-01-08T06:00:00Z
                        .plus(5L, ChronoUnit.MINUTES)   // 1970-01-08T06:05:00Z
                        .plus(4L, ChronoUnit.SECONDS)   // 1970-01-08T06:05:04Z
                        .plus(3L, ChronoUnit.MILLIS)    // 1970-01-08T06:05:04.003Z
                        .plus(2L, ChronoUnit.MICROS)    // 1970-01-08T06:05:04.003002Z
                        .plus(1L, ChronoUnit.NANOS);    // 1970-01-08T06:05:04.003002001Z

        Instant start = Instant.EPOCH
                .plus(20, ChronoUnit.MINUTES);// 1970-01-01T00:20:00Z
        Duration length = Duration.ZERO.plusMinutes(90);     // PT1H30M (90 mins)
        Instant end = start.plus(length);                    // 1970-01-01T01:50:00Z


        long eventDuration1 = start.until(end, ChronoUnit.MINUTES);  // 90 minutes
        long eventDuration2 = start.until(end, ChronoUnit.HOURS);    // 1 hour

        Instant instant = Instant.parse("2021-04-28T03:15:00Z");
        ZoneId zid = ZoneId.of("America/New_York");
        LocalTime lt = LocalTime.ofInstant(instant, zid);           // 10:18:30
        LocalDate ld = LocalDate.ofInstant(instant, zid);           // 2021-04-27
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, zid);  // 2021-04-27T23:15
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        // 2021-04-27T23:15-04:00[America/New_York]

    }
}
