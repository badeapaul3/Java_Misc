package devguideocp.Part2_C11to15.A11_3_Generics3;

import java.util.*;

/**
 * @author hatzp
 **/
public class TypeErasure {

    public static void main(String[] args) {
        // Pre-erasure code
        List<String> strList = new ArrayList<>(); // (0)
        List list = strList;       // (1) Assignment to non-generic reference is ok.
        strList = list;            // (2) warning: unchecked conversion
        strList.add("aha");        // (3) Method call type-safe.
        list.add(23);              // (4) warning: [unchecked] unchecked call to add(E)
        //     as a member of the raw type java.util.List
        //System.out.println(strList.get(1).length());  // (5) ClassCastException

        // Post-erasure code
        List strList1 = new ArrayList();                        // (0')
        List list1 = strList1;                                   // (1')
        strList1 = list1;                                        // (2')
        strList1.add("aha");                                    // (3')
        list1.add(Integer.valueOf(23));                         // (4')
        System.out.println(((String)strList1.get(0)).length()); // (5') Cast inserted.
        System.out.println(list1);
        System.out.println(strList1);



    }
}
