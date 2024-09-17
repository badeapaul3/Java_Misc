package devguideocp.Part1_C1to5.A5_11_OOP_Records;

import java.time.Year;

/**
 * @author hatzp
 **/

public class DataUser {
    public static void main(String[] args) {
        CD[] cdArray = {CD.cd0, CD.cd2, CD.cd4, new CD()};                   // (12)
        for(int i = 0; i < cdArray.length; ++i) {
            CD cd = cdArray[i];
            if (cd.isOther()) {                                                // (13)
                System.out.println(cd.toString());                               // (14)
            }
        }
        System.out.println("Title: " + cdArray[1].title());                  // (15)
        System.out.println(CD.Genre.JAZZ);
    }
}
