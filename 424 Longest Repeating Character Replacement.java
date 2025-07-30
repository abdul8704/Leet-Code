// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.
 
// Constraints:
// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, N = s.length();
        int[] map = new int[26];
        int maxFreq = 0;

        int left = 0;
        for(int right=0; right<N; right++){
            map[s.charAt(right) - 'A']++;
            maxFreq = Math.max(map[s.charAt(right) - 'A'], maxFreq);
            int len = right - left + 1;

            if(len - maxFreq > k)
            {
                while(len - maxFreq > k){
                    map[s.charAt(left++) - 'A']--;
                    maxFreq = Math.max(map[s.charAt(right) - 'A'], maxFreq);
                    len = right - left + 1;
                }
            }

            res = Math.max(res, len);

        }

        return res;
    }
}