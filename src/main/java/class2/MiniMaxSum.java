package class2;

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

class MiniMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        System.out.println((sum - max) + " " + (sum - min));
    }

}

class MiniMaxSumResult2 {

    public static void miniMaxSum(List<Integer> arr) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            long current = sum - arr.get(i);
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }
        System.out.println(min + " " + max);
    }
}

class MiniMaxSumResult3 {

    public static void miniMaxSum(List<Integer> arr) {
        long[] sums = new long[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    sums[i] += arr.get(j);
                }
            }
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] < min) {
                min = sums[i];
            }
            if (sums[i] > max) {
                max = sums[i];
            }
        }
        System.out.println(min + " " + max);
    }
}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
       /* List<Integer> arr = new ArrayList<>();
        arr.add(256741038);
        arr.add(623958417);
        arr.add(467905213);
        arr.add(714532089);
        arr.add(938071625);*/
        MiniMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}
