package devguideocp.Part2_C11to15.A15_1_Collections;

/**
 * @author hatzp
 **/
import java.util.ArrayDeque;
import java.util.Arrays;

/** Executes tasks. */
public class TaskExecutor2 {

    public static void main(String[] args) {
        String[] elementArray = {"sway", "and", "twist", "stacks", "tall"};     // (1)
        System.out.println("Array of elements: " + Arrays.toString(elementArray));

        // Using ArrayDeque as a stack:                                            (2)
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String string : elementArray)
            stack.push(string);                             // (3) Push elements.
        System.out.println("Stack before: TOP->" + stack + "<-BOTTOM");
        System.out.print("Popping stack: ");
        while (!stack.isEmpty()) {                        // (4)
            System.out.print(stack.pop() + " ");            // (5) Pop elements.
        }
        System.out.println("\n");

        // Using ArrayDeque as a FIFO queue:                 (6)
        elementArray = new String[] {"Waiting", "in", "queues", "is", "boring"};// (7)
        System.out.println("Array of elements: " + Arrays.toString(elementArray));
        ArrayDeque<String> fifoQueue = new ArrayDeque<>();
        for (String string : elementArray)
            fifoQueue.offerLast(string);                    // (8) Insert at tail.
        System.out.println("Queue before: HEAD->" + fifoQueue  + "<-TAIL");
        System.out.print("Polling queue: ");
        while (!fifoQueue.isEmpty()) {                    // (9)
            String string = fifoQueue.pollFirst();          // (10) Remove from head.
            System.out.print(string.toUpperCase() + " ");
        }
        System.out.println();
        System.out.println();


        //exercise to create both queue and stack (FIFO + LIFO)
        String[] myArray = new String[]{"Paul","is","a","great","cook"};
        System.out.println("My Array: "+ Arrays.toString(myArray));
        ArrayDeque<String> myDeque = new ArrayDeque<>();
        ArrayDeque<String> myStack = new ArrayDeque<>();
        for(String str : myArray){
            myDeque.offerLast(str);
            myStack.offerFirst(str);
        }
        System.out.println("My Deque: " + myDeque);
        System.out.println("My Deque: " + myStack);
    }
}