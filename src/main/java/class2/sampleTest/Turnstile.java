package class2.sampleTest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
A university has a turnstile to enter or exit a building. Determine the time each person will pass through the turnstile. Each person takes one second to pass through the turnstile.
When multiple people arrive at the turnstile simultaneously, the following rules apply:
1. If the turnstile was not used in the previous second, priority is given to the person exiting.
2. If the previous person exited, the person exiting goes first.
3. If the previous person entered, the person entering goes first.
4. If two people going the same direction arrive at the same time, the lower-indexed one goes first.
Example 1
Input: n = 4 people, time = [O, 0, 1, 51, direction = [0, 1, 1, Ol enter = O, exit = 1
Output: [2, 0, 1, 5]
Explanation: row numbers are times
O. Two students arrive, Person 1 exiting, and Person 0 entering. Rule 1, Person 1 exits
1. Person 2 arrives and is exiting. Rule 2, Person 2 exits.
2. Person 1 enters.
3. No one is at the turnstile.
4. No one is at the turnstile.
5. Person 3 enters.
Example 2
Input: n = 5 people, time = [O, 1, 1, 3, 31, direction = [O, 1, O, O, 1]
Output: [0, 2, 1, 4, 3]
Explanation: row numbers are times
O. Person 0 arrives and enters.
1. Person 1 is exiting, and Person 2 is entering. Person 2 enters, Rule 3.
2. Person 1 exits.
3. Person 3 is entering. Person 4 is exiting. Person 4 exits, Rule 2.
4. Person 3 enters.
Constraints
• 1≤n ≤ 105
• 0 ≤ timelil ≤ 10° for 0 ≤ i ≤n - 1
• timelil ≤ timeli + 1] for 0 si≤n - 2
• directionlil is 0 or 1 for O si ≤n - 1
 */

class Result {

    /*
     * Complete the 'getTimes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY time
     *  2. INTEGER_ARRAY direction
     */

    // BigO Time Complexity: O(n)
    // BigO Space Complexity: O(n)
    public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        int n = time.size();
        List<Integer> result = new ArrayList<>();
        // Initialize result array with placeholder values
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Keep track of people waiting to enter and exit
        Queue<Integer> enterWaitingQueue = new LinkedList<>();
        Queue<Integer> exitWaitingQueue = new LinkedList<>();

        int currentSecond = 0;
        int previousDirection = -1; // track what happened last second
        int idx = 0; // index to iterate through arrivals

        // Keep going until everyone has gone through
        while (idx < n || enterWaitingQueue.size() > 0 || exitWaitingQueue.size() > 0) {

            // First, add anyone who arrives at this second
            while (idx < n && time.get(idx) == currentSecond) {
                if (direction.get(idx) == 0) { // wants to enter
                    enterWaitingQueue.add(idx);
                } else { // wants to exit
                    exitWaitingQueue.add(idx);
                }
                idx++;
            }

            // Now figure out who gets to go through
            boolean someoneWantsToEnter = !enterWaitingQueue.isEmpty();
            boolean someoneWantsToExit = !exitWaitingQueue.isEmpty();

            if (someoneWantsToEnter && someoneWantsToExit) {
                // Both directions have people waiting - need to apply rules
                if (previousDirection == -1 || previousDirection == 1) {
                    // Rule 1 or 2: give priority to exit
                    int personWhoExits = exitWaitingQueue.poll();
                    result.set(personWhoExits, currentSecond);
                    previousDirection = 1;
                } else {
                    // Rule 3: last person entered, so give priority to enter
                    int personWhoEnters = enterWaitingQueue.poll();
                    result.set(personWhoEnters, currentSecond);
                    previousDirection = 0;
                }
            } else if (someoneWantsToExit) {
                // Only exit queue has people
                int personWhoExits = exitWaitingQueue.poll();
                result.set(personWhoExits, currentSecond);
                previousDirection = 1;
            } else if (someoneWantsToEnter) {
                // Only enter queue has people
                int personWhoEnters = enterWaitingQueue.poll();
                result.set(personWhoEnters, currentSecond);
                previousDirection = 0;
            } else {
                // Nobody waiting this second
                previousDirection = -1;
            }

            currentSecond++;
        }

        return result;
    }

}

public class Turnstile {
    public static void main(String[] args) throws IOException {
        // Test Example 1: time = [0, 0, 1, 5], direction = [0, 1, 1, 0]
        // Expected output: [2, 0, 1, 5]
        List<Integer> time1 = new ArrayList<>(Arrays.asList(0, 0, 1, 5));
        List<Integer> direction1 = new ArrayList<>(Arrays.asList(0, 1, 1, 0));
        List<Integer> result1 = Result.getTimes(time1, direction1);
        System.out.println("Example 1 result: " + result1);

        // Test Example 2: time = [0, 1, 1, 3, 3], direction = [0, 1, 0, 0, 1]
        // Expected output: [0, 2, 1, 4, 3]
        List<Integer> time2 = new ArrayList<>(Arrays.asList(0, 1, 1, 3, 3));
        List<Integer> direction2 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1));
        List<Integer> result2 = Result.getTimes(time2, direction2);
        System.out.println("Example 2 result: " + result2);
    }
}
