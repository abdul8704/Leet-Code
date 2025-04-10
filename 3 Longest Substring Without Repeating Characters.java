// Given a string s, find the length of the longest substring without repeating characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Constraints:
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[127];
        int longest = 0;
        int left = 0;

        for(int right=0; right<s.length(); right++){
            if(freq[s.charAt(right)] >= 1){

                while(freq[s.charAt(right)] != 0){
                    freq[s.charAt(left)]--;
                    left++;
                }
            }
            freq[s.charAt(right)]++;
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}