package devguideocp.Part2_C11to15.A15_2_Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hatzp
 **/
public class AdvMapTests {
    public static void main(String[] args) {

        Map<Integer, String> etnMap = new HashMap<>();
        etnMap.put(112, "Norway");
        etnMap.put(999, "UK");
        etnMap.put(190, null);
        etnMap.put(911, null);
        // {112=Norway, 999=UK, 190=null, 911=null}
        System.out.println(etnMap);

        // Before: {112=Norway, 999=UK, 190=null, 911=null}
        System.out.println(etnMap.merge(112, "Mordor", (oVal, value) -> null));      // (1) null, removed
        System.out.println(etnMap.merge(999, "Mordor", (oVal, value) -> "Uganda"));  // (2) Uganda, updated
        System.out.println(etnMap.merge(190, "Mordor", (oVal, value) -> null));      // (3) Mordor, updated
        System.out.println(etnMap.merge(911, "Mordor", (oVal, value) -> "USA"));     // (4) Mordor, updated
        System.out.println(etnMap.merge(100, "Mordor", (oVal, value) -> null));      // (5) Mordor, inserted
        System.out.println(etnMap.merge(110, "Mordor", (oVal, value) -> "China"));   // (6) Mordor, inserted
        // After: {100=Mordor, 999=Uganda, 110=Mordor, 190=Mordor, 911=Mordor}
        System.out.println(etnMap.merge(999, "Test", (oVal, value) -> oVal.concat(value)));  // (2) UgandaTest, updated (LE)
        System.out.println(etnMap.merge(999, "Test", String::concat));  // (2) UgandaTestTest, updated (MR)


        System.out.println(etnMap);
        etnMap.clear();
        etnMap.put(112, "Norway");
        etnMap.put(999, "UK");
        etnMap.put(190, null);
        etnMap.put(911, null);
        System.out.println(etnMap);
        System.out.println("COMPUTE @@@@@@@@@@@@ COMPUTE");

        // Before: {112=Norway, 999=UK, 190=null, 911=null}
        System.out.println(etnMap.compute(112, (key, oVal) -> null));              // (7) null, removed
        System.out.println(etnMap.compute(999, (key, oVal) -> "Uganda"));          // (8) Uganda, updated
        System.out.println(etnMap.compute(190, (key, oVal) -> null));              // (9) null, removed
        System.out.println(etnMap.compute(911, (key, oVal) -> "USA"));             // (10) USA, updated
        System.out.println(etnMap.compute(100, (key, oVal) -> null));              // (11) null, no action
        System.out.println(etnMap.compute(110, (key, oVal) -> "China"));           // (12) China, inserted
        // After: {110=China, 999=Uganda, 911=USA}

        System.out.println(etnMap);
        etnMap.clear();
        etnMap.put(112, "Norway");
        etnMap.put(999, "UK");
        etnMap.put(190, null);
        etnMap.put(911, null);
        System.out.println(etnMap);
        System.out.println("COMPUTE IF ABSENT @@@@@@@@@@@@ COMPUTE IF ABSENT");

        // Before: {112=Norway, 999=UK, 190=null, 911=null}
        etnMap.computeIfAbsent(112, key -> null);              // (13) Norway, no change
        etnMap.computeIfAbsent(999, key -> "Uganda");          // (14) UK, no change
        etnMap.computeIfAbsent(190, key -> null);              // (15) null, no change
        etnMap.computeIfAbsent(911, key -> "USA");             // (16) USA, updated
        etnMap.computeIfAbsent(100, key -> null);              // (17) null, no action
        etnMap.computeIfAbsent(110, key -> "China");           // (18) China, inserted
        // After: {112=Norway, 110=China, 999=UK, 190=null, 911=USA}
        System.out.println(etnMap);

        etnMap.clear();
        etnMap.put(112, "Norway");
        etnMap.put(999, "UK");
        etnMap.put(190, null);
        etnMap.put(911, null);
        System.out.println(etnMap);
        System.out.println("COMPUTE IF ABSENT @@@@@@@@@@@@ COMPUTE IF ABSENT");

        // Before: {112=Norway, 999=UK, 190=null, 911=null}
        etnMap.computeIfPresent(112, (key, oVal) -> null);      // (19) null, removed
        etnMap.computeIfPresent(999, (key, oVal) -> "Uganda");  // (20) Uganda, updated
        etnMap.computeIfPresent(190, (key, oVal) -> null);      // (21) null, no change
        etnMap.computeIfPresent(911, (key, oVal) -> "USA");     // (22) null, no change
        etnMap.computeIfPresent(100, (key, oVal) -> null);      // (23) null, no action
        etnMap.computeIfPresent(110, (key, oVal) -> "China");   // (24) null, no action
        System.out.println(etnMap);
// After: {999=Uganda, 190=null, 911=null}





    }
}
