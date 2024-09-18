package devguideocp.Part1_C1to5.A3_3_Arrays;

/**
 * @author hatzp
 **/
public class Initialize {
    public static void main(String[] args) {
        int[] anIntArray = {13, 49, 267, 15, 215};
        int[] anIntArray2 = {13, 49, 267, 15,};
        System.out.println(anIntArray.length);
        System.out.println(anIntArray2.length + "\n");

        // Array with 4 String objects:
        String[] pets = {"crocodiles", "elephants", "crocophants", "elediles"}; // (1)

        for (String pet : pets)System.out.println(pet);

        // Array of 3 characters:
        char[] charArray = {'a', 'h', 'a'};    // (2) Not the same as "aha"


        char letter = "TEST".toCharArray()[1];


        int[] intArray = new int[5];

        //new int[] {3, 5, 2, 8, 6}; no longer allowed

        for (int i : new int[]{3, 5, 2, 8, 6}) {
            System.out.println(i);
        }


        int[] intArray3 = {3, 5, 2, 8, 6};                               // array initializer
        int[] intArray4 = new int[] {3, 5, 2, 8, 6};                     // anonymous array expression

        int[] testArray;
       // testArray = {1,2,3}; compilation err
        testArray = new int[] {1,2,3}; //all good


    }
}
