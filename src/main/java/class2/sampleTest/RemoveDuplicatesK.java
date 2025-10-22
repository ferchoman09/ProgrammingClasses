package class2.sampleTest;

import java.util.*;

public class RemoveDuplicatesK {

    // Big O Time Complexity: O(n)
    // Big O Space Complexity: O(n)
    public static String removeDuplicates(String s, int k) {
        // stack de pares (char, count)
        Deque<Pair> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop(); // removemos el bloque
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        // reconstruir el string
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.reverse().toString(); // porque apilamos al revés
    }

    // Big O Time Complexity: O(n^2) in the worst case
    // Big O Space Complexity: O(n)
    public static String removeDuplicatesBruteForce(String s, int k) {
        // Keep removing consecutive duplicates until no more can be removed
        boolean changed = true;
        while (changed) {
            changed = false;
            StringBuilder sb = new StringBuilder();
            int i = 0;

            while (i < s.length()) {
                char currentChar = s.charAt(i);
                int count = 1;

                // Count consecutive characters
                while (i + count < s.length() && s.charAt(i + count) == currentChar) {
                    count++;
                }

                // If we found k or more consecutive characters, remove exactly k
                if (count >= k) {
                    changed = true;
                    // Add the remaining characters (count - k)
                    int remaining = count - k;
                    for (int j = 0; j < remaining; j++) {
                        sb.append(currentChar);
                    }
                    i += count;
                } else {
                    // Add all characters (less than k)
                    for (int j = 0; j < count; j++) {
                        sb.append(currentChar);
                    }
                    i += count;
                }
            }

            s = sb.toString();
        }

        return s;
    }

    static class Pair {
        char ch;
        int count;
        Pair(char c, int cnt) {
            ch = c;
            count = cnt;
        }
    }

    // Ejemplo
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); // aa
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2)); // "ps"
        System.out.println(removeDuplicatesBruteForce("deeedbbcccbdaa", 3)); // aa
        System.out.println(removeDuplicatesBruteForce("pbbcggttciiippooaais", 2)); // "ps"
    }
}