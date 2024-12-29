package devguideocp.Part2_C16to20.A18_2_FormattingParsing;

import java.text.MessageFormat;
import java.time.*;
import java.util.Date;

/**
 * @author hatzp
 **/
public class MessageFormatParse {
    public static void main(String[] args) {

        String pattern = "At {3} on {2} Elvis landed at {0} and was greeted by {1} fans.";
        String output = MessageFormat.format(pattern, "Honolulu", 3000,
                LocalDate.of(1961,3,25), LocalTime.of(12,15));
        System.out.println(output);


        //Format element:     {0}      {1}           {2}                     {3}
        //Arguments:       "Honolulu", 3000, LocalDate.of(1961,3,25), LocalTime.of(12,15)



//DateFormat.getTimeInstance(DateFormat.SHORT, getLocale()) formatter implicitly created by method call

        // Specify the pattern:                                                       (1)
        String pattern2 = "At {3,time,short} on {2,date,full} Elvis landed at {0} "
                +  "and was greeted by {1,number,integer} fans.";

// Create a MessageFormat based on the given pattern:                         (2)
        MessageFormat mf2 = new MessageFormat(pattern2);

// Create the array with the arguments to format:                             (3)
        Object[] messageArguments = {
                "Honolulu",                                         // argument index 0
                3000,                                               // argument index 1
                new Date(LocalDate.of(1961,3,25).toEpochSecond(LocalTime.of(12,15),ZoneOffset.UTC)),    // argument index 2
                new Date(LocalDate.of(1961,3,25).toEpochSecond(LocalTime.of(12,15),ZoneOffset.UTC)) //index 3
        };

// Format the arguments:                                                      (4)
        String output2 = mf2.format(messageArguments);
        System.out.println(output2);








    }
}
