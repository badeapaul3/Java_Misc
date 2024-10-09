package devguideocp.Part2_C11to15.A11_3_Generics3;

import java.util.*;

/**
 * @author hatzp
 **/
public class WildParamType {

    public static void main(String[] args) {


        Collection<Number> colNum;
        Set<Number> setNum = null;
        Set<Integer> setInt = null;
        colNum = setNum; // (1) Set<Number> <: Collection<Number>
        //colNum = setInt; // (2) Compile-time error!

        Collection<Collection<Number>> colColNum = null; // Collection of Collections of Number
        Set<Collection<Number>>        setColNum = null; // Set of Collections of Number
        Set<Set<Integer>>              setSetInt = null; // Set of Sets of Integer
        colColNum = setColNum;                    // (3) Set<Collection<Number>> <: Collection<Collection<Number>>
//        colColNum = setSetInt;                    // (4) Compile-time error!
//        setColNum = setSetInt;                    // (5) Compile-time error!


        Collection<? extends Collection<Number>> colExtColNum;
        colExtColNum = colColNum;       // (6) Collection<Collection<Number>> <: Collection<? extends Collection<Number>>
        colExtColNum = setColNum;       // (7) Set<Collection<Number>> <: Collection<? extends Collection<Number>>
        //colExtColNum = setSetInt;       // (8) Compile-time error!

        Collection<Collection<? extends Number>> colColExtNum;
        Set<Collection<Number>> mySet = null;
        colColNum = mySet;
//        colColExtNum = colColNum;       // (9)  Compile-time error! subtype covariance only at the top level with upper bound wildcard
//        colColExtNum = setColNum;       // (10) Compile-time error!
//        colColExtNum = setSetInt;       // (11) Compile-time error!

        Map<Number, String>  mapNumStr;
        Map<Integer, String> mapIntStr;
        //mapNumStr = mapIntStr;             // (12) Compile-time error!

        Map<Integer, ? extends Collection<String>> mapIntExtColStr;
        Map<Integer, Collection<? extends String>> mapIntColExtStr;
        Map<Integer, Collection<String>>           mapIntColStr = null;
        Map<Integer, Set<String>>                  mapIntSetStr = null;
        mapIntExtColStr = mapIntColStr;// (13) Map<Integer, Collection<String>> <:
        //      Map<Integer, ? extends Collection<String>>
        mapIntExtColStr = mapIntSetStr;// (14) Map<Integer, Set<String>> <:
        //      Map<Integer, ? extends Collection<String>>
//        mapIntColStr    = mapIntSetStr;    // (15) Compile-time error!
//        mapIntColExtStr = mapIntColStr;    // (16) Compile-time error!
//        mapIntColExtStr = mapIntSetStr;    // (17) Compile-time error!



    }
}
