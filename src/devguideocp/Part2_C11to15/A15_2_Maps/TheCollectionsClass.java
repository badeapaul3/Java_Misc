package devguideocp.Part2_C11to15.A15_2_Maps;

/**
 * @author hatzp
 **/
import java.util.*;
public class TheCollectionsClass {
    public static void main(String[] args) {

        // Mutable courses:
        StringBuilder mc1 = new StringBuilder("Java I");
        StringBuilder mc2 = new StringBuilder("Java II");
        StringBuilder mc3 = new StringBuilder("Java III");
        StringBuilder mc4 = new StringBuilder("Java IV");

// Backing map:
        Map<Integer, StringBuilder> backingMap = new HashMap<>();
        backingMap.put(200, mc1); backingMap.put(300, mc2);
        backingMap.put(400, mc3); backingMap.put(500, mc4);

// Unmodifiable view of a map:
        Map<Integer, StringBuilder> unmodViewMap
                = Collections.unmodifiableMap(backingMap);

        System.out.println(backingMap);
        System.out.println(unmodViewMap);


        // UnsupportedOperationException at (1), (2), and (3):
//        unmodViewMap.put(100, new StringBuilder("Java Now"));
//        unmodViewMap.remove(400);
//        unmodViewMap.replace(200, new StringBuilder("First Java"));

        backingMap.remove(200); backingMap.remove(400);
        System.out.println("Backing map:       " + backingMap);
        System.out.println("Unmodifiable view: " + unmodViewMap);
//  Backing map:       {500=Java Complete, 300=Java II}
//  Unmodifiable view: {500=Java Complete, 300=Java II}


    }
}
