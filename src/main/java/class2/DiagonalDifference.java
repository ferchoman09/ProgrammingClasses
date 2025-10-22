package class2;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DiagonalDifferenceResult {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    // Big O Time Complexity: O(n)
    // Big O Space Complexity: O(1)
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum1 = 0;
        int sum2 = 0;
        // Big O notation: O(n)
        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(arr.size() - i - 1);
        }
        return Math.abs(sum1 - sum2);
    }

}

class DiagonalDifferenceResult2 {

    // Big O Time Complexity: O(n)
    // Big O Space Complexity: O(1)
    public static int diagonalDifference(List<List<Integer>> arr) {
        // main diagonal [0][0], [1][1], [2][2]
        // secondary diagonal [0][2], [1][1], [2][0]
        int mainDiagonalX = 0;
        int mainDiagonalY = 0;
        int secondaryDiagonalX = 0;
        int secondaryDiagonalY = arr.size() - 1;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(mainDiagonalX).get(mainDiagonalY);
            sum2 += arr.get(secondaryDiagonalX).get(secondaryDiagonalY);
            mainDiagonalX++;
            mainDiagonalY++;
            secondaryDiagonalX++;
            secondaryDiagonalY--;
        }
        return Math.abs(sum1 - sum2);
    }
}

class DiagonalDifferenceResult3 {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // main diagonal [0][0], [1][1], [2][2]
        // secondary diagonal [0][2], [1][1], [2][0]
        int sumMainDiagonal = 0;
        int sumSecondaryDiagonal = 0;
        // Big. Space Complexity: O(1)
        // Big. Time Complexity: O(n^2)
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    sumMainDiagonal += arr.get(i).get(j);
                }
                if (i + j == arr.size() - 1) {
                    sumSecondaryDiagonal += arr.get(i).get(j);
                }
            }
        }
        return Math.abs(sumMainDiagonal - sumSecondaryDiagonal);
    }
}

class DiagonalDifferenceResult4 {

    // Big O - Time Complexity: O(n)
    // Big O - Space Complexity: O(1)
    //O(log n)
    //O(n log n)
    //O(n^2)
    //O(n^3)
    public static int diagonalDifference(List<List<Integer>> arr) {
        // main diagonal [0][0], [1][1], [2][2]
        // secondary diagonal [0][2], [1][1], [2][0]
        int sumMainDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumMainDiagonal += arr.get(i).get(i);
        }
        int sumSecondaryDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumSecondaryDiagonal += arr.get(i).get(arr.size() - i - 1);
        }
        return Math.abs(sumMainDiagonal - sumSecondaryDiagonal);
    }
}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifferenceResult.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
