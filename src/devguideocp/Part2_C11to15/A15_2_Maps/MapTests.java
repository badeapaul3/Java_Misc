package devguideocp.Part2_C11to15.A15_2_Maps;

import java.util.*;

/**
 * @author hatzp
 **/
public class MapTests {
    public static void main(String[] args) {

        Map<Integer, String> jCourses = Map.of(
                200, "Basic Java",    300, "Intermediate Java",
                400, "Advanced Java", 500, "Kickass Java");
//  jCourses.put(200, "Java Jive");              // UnsupportedOperationException
//  jCourses.remove(500);                        // UnsupportedOperationException
        System.out.println(jCourses instanceof HashMap); // false
        System.out.println(jCourses instanceof Map); // true
        System.out.println(jCourses);
// {200=Basic Java, 400=Advanced Java, 300=Intermediate Java, 500=Kickass Java}

//        Map<Integer, String> coursesMap1
//                = Map.of(101, "Java 1.1", 101, "Java 17");  // IllegalArgumentException
//        Map<Integer, String> coursesMap2
//                = Map.of(101, "Java 1.1", 101, null);       // NullPointerException


        //  Map.Entry<Integer, String> e0 = Map.entry(100, null); // NullPointerException
        Map.Entry<Integer, String> e1 = Map.entry(200, "Basic Java");
        Map.Entry<Integer, String> e2 = Map.entry(300, "Intermediate Java");
        Map.Entry<Integer, String> e3 = Map.entry(400, "Advanced Java");
        Map.Entry<Integer, String> e4 = Map.entry(500, "Kickass Java");

        Map<Integer, String> unmodCourseMap = Map.ofEntries(e1, e2, e3, e4);  // Varargs
// {300=Intermediate Java, 500=Kickass Java, 200=Basic Java, 400=Advanced Java}
//unmodCourseMap.replace(200, "Java Jive");    // UnsupportedOperationException
//unmodCourseMap.remove(500);                  // UnsupportedOperationException


        StringBuilder mc1 = new StringBuilder("Basic Java");
        StringBuilder mc2 = new StringBuilder("Intermediate Java");
        StringBuilder mc3 = new StringBuilder("Advanced Java");
        StringBuilder mc4 = new StringBuilder("Kickass Java");

        Map.Entry<Integer, StringBuilder> me1 = Map.entry(200, mc1);
        Map.Entry<Integer, StringBuilder> me2 = Map.entry(300, mc2);
        Map.Entry<Integer, StringBuilder> me3 = Map.entry(400, mc3);
        Map.Entry<Integer, StringBuilder> me4 = Map.entry(500, mc4);

        Map<Integer, StringBuilder> unmodMapWithMutableCourses
                = Map.ofEntries(me1, me2, me3, me4);         // Varargs
        System.out.println(unmodMapWithMutableCourses);
// {200=Basic Java, 500=Kickass Java, 300=Intermediate Java, 400=Advanced Java}

// unmodMapWithMutableCourses.replace(200, mc4); // UnsupportedOperationException
// unmodMapWithMutableCourses.remove(400);       // UnsupportedOperationException

        StringBuilder mutableCourse = unmodMapWithMutableCourses.get(500);
        mutableCourse.replace(0, 7, "Smartass");
        System.out.println(unmodMapWithMutableCourses);
// {400=Advanced Java, 500=Smartass Java, 200=Basic Java, 300=Intermediate Java}


        // Original map:
        Map<Integer, StringBuilder> courseMap = new HashMap<>();
        courseMap.put(200, mc1); courseMap.put(300, mc2);
        courseMap.put(400, mc3); courseMap.put(500, mc4);

// Unmodifiable copy of the map:
        Map<Integer, StringBuilder> copyCourseMap = Map.copyOf(courseMap); // (1)

// Modify original map:
        courseMap.remove(200);
        courseMap.remove(400);
        System.out.println("Original: " + courseMap);
        System.out.println("Copy: " + copyCourseMap);




    }
}
