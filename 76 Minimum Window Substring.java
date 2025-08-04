// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 
// Constraints:
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
 
// Follow up: Could you find an algorithm that runs in O(m + n) time?

class Solution {
    public String minWindow(String s, String t) {
        int ansLeft = 0, ansRight = 1000001, N = s.length(), left = 0;
        int[] targetMap = new int[128];
        int[] sourceMap = new int[128];

        for(int i=0; i<t.length(); i++)
            targetMap[t.charAt(i)]++;

        for(int right=0; right<N; right++){
            sourceMap[s.charAt(right)]++;

            while(right >= left && isSame(sourceMap, targetMap)){
                if(right - left + 1 < ansRight - ansLeft + 1){
                    ansRight = right;
                    ansLeft = left;
                }
                sourceMap[s.charAt(left)]--;
                left++;
            }
        }    

        if(ansRight == 1000001)
            return "";

        return s.substring(ansLeft, ansRight+1);
    }
    private static boolean isSame(int[] source, int[] target){
        for(int i=0; i<128; i++){
            if(target[i] > 0 && source[i] < target[i])
                return false;
        }

        return true;        
    }

}