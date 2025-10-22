package class2.sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/*
Given two strings, str1 and str2, where str1 contains exactly one character more than str2, find the indices of the characters in str1 that can be removed to make str1 equal to str2. Return the array of indices in increasing order. If it is not possible, return the array [-1].

Note: Use 0-based indexing.

Example

str1 = "abdgggda"

str2 = "abdggda"

Any "g" character at positions 3, 4, or 5 can be deleted to obtain str2. Return [3, 4, 5].

Output Format

    int[]: the indices of characters that can be removed from str1 in ascending order, or [-1] if it is not possible to match str2

Constraints

*   2 <= |str1| <= 2 * 10^5
*   1 <= |str2| <= 2 * 10^5
*   |str1| = |str2| + 1
*   str1 and str2 only contain lowercase English letters.

 */
public class ProblemInterviewMock1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bufferedReader.readLine();

        String str2 = bufferedReader.readLine();

        List<Integer> result = getRemovableIndices(str1, str2);
        List<Integer> result2 = getRemovableIndicesOptimized(str1, str2);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
        );
        System.out.println("-----");
        System.out.println(
                result2.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
        );

        bufferedReader.close();
    }

    // Big O - Time Complexity: O(n^2)
    // Big O - Space Complexity: O(1)
    public static List<Integer> getRemovableIndices(String str1, String str2) {
        List<Integer> removableIndices = new ArrayList<>();
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2 + 1) {
            removableIndices.add(-1);
            return removableIndices;
        }

        for (int i = 0 ; i < len1 ; i++) {
            if (checkEqualAfterRemoval(str1, str2, i)) {
                removableIndices.add(i);
            }
        }

        if (removableIndices.isEmpty()) {
            removableIndices.add(-1);
        }
        return removableIndices;
    }

    private static boolean checkEqualAfterRemoval(String str1, String str2, int i) {
        for (int j = 0, k = 0; j < str1.length() && k < str2.length(); ) {
            if (j == i) {
                j++;
                continue;
            }
            if (str1.charAt(j) != str2.charAt(k)) {
                return false;
            }
            j++;
            k++;
        }
        return true;
    }

    // Optimized implementation using prefix & suffix matches.
    // Big O - Time Complexity: O(n)
    // Big O - Space Complexity: O(n) (can be reduced to O(1) with a two-pass approach, but arrays improve clarity and keep O(n) constraints acceptable for n <= 2e5)
    public static List<Integer> getRemovableIndicesOptimized(String str1, String str2) {
        List<Integer> removable = new ArrayList<>();
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2 + 1) { // basic constraint check
            removable.add(-1);
            return removable;
        }

        // prefixMatch[i] == true if first i characters of str1 and str2 match (i in [0, len2])
        boolean[] prefixMatch = new boolean[len2 + 1];
        prefixMatch[0] = true;
        for (int i = 0; i < len2; i++) {
            prefixMatch[i + 1] = prefixMatch[i] && str1.charAt(i) == str2.charAt(i);
        }

        // suffixMatch[i] == true if str1 substring (i+1 .. end) == str2 substring (i .. end)
        // i ranges 0..len2; suffixMatch[len2] compares empty substrings -> true
        boolean[] suffixMatch = new boolean[len2 + 1];
        suffixMatch[len2] = true;
        for (int i = len2 - 1; i >= 0; i--) {
            suffixMatch[i] = suffixMatch[i + 1] && str1.charAt(i + 1) == str2.charAt(i);
        }

        for (int removeIdx = 0; removeIdx <= len2; removeIdx++) {
            if (prefixMatch[removeIdx] && suffixMatch[removeIdx]) {
                removable.add(removeIdx);
            }
        }

        if (removable.isEmpty()) {
            removable.add(-1);
        }
        return removable;
    }
}
