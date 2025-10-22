package class2;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class PowerSumResult {

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */

    public static int powerSum(int X, int N) {
        // Write your code here
        List<Integer> numeros = new ArrayList<>();
        return calculatePowerSumWays(X, N, 1, numeros);
    }

    public static int calculatePowerSumWays(int X, int N, int num, List<Integer> numeros) {
        if (X == 0) {
            // Print the current combination
            System.out.println(numeros);
            return 1;
        }
        if (X < 0) {
            return 0;
        }
        int count = 0;
        for (int i = num; Math.pow(i, N) <= X; i++) {
            // Add the current number to the list
            numeros.add(i);
            count += calculatePowerSumWays(X - (int) Math.pow(i, N), N, i + 1, numeros);
            // Remove the last number to backtrack
            numeros.remove(numeros.size() - 1);
        }
        return count;
    }
}

public class PowerSum {
    public static void main(String[] args) throws IOException {
        int X = 100;
        int N = 2;

        int result = PowerSumResult.powerSum(X, N);
        System.out.println(result);
    }
}
