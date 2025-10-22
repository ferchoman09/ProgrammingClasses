package class2.sampleTest;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    // Big O Time Complexity: O(n)
    // Big O Space Complexity: O(n) - O(min(m, n)) where m is the size of the charset
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Big O Time Complexity: O(n^2)
    // Big O Space Complexity: O(min(m, n)) where m is the size of the charset
    public static int lengthOfLongestSubstringBruteForce(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring("asjrgapa"));         // 0

        System.out.println("With brute force:");

        System.out.println(lengthOfLongestSubstringBruteForce("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstringBruteForce("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstringBruteForce("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstringBruteForce("asjrgapa"));         // 0
    }
}
