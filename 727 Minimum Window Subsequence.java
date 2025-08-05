// ﻿Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.
// If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index

// Examples
// Input: s1 = "abcdebdde", s2 = "bde"
// Output: "bcde"
// Explanation:
// "bcde" is the answer because it occurs before "bdde" which has the same length.
// "deb" is not a smaller window because the elements of s2 in the window must occur in order.

// Input: s1 = "jmeqsiwvaovvnbstl", s2 = "u"
// Output: ""
// Input: s1="fhhjkeejkdjjs", s2=”jkj”
// Output:
// Jkdj

// Constraints:
// 1 <= s1.length <= 2 * 104
// 1 <= s2.length <= 100
// s1 and s2 consist of lowercase English letters.

class Solution {
    public String minWindow(String s, String t) {
        int ansLeft = 0, ansRight = 1000001, N = s.length(),
            M = t.length(), left = 0;
        int[] targetMap = new int[128];
        int[] sourceMap = new int[128];

        for(int i=0; i<t.length(); i++)
            targetMap[t.charAt(i)]++;

        for(int right=0; right<N; right++){
            sourceMap[s.charAt(right)]++;

            while(right >= left && isSame(sourceMap, targetMap)
                    && check(s, left, right, t, 0, M-1)){
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
    private static boolean check(String s, int left1, int right1, String t, int left2, int right2){
        int p1 = left1, p2 = left2;

        while(p1 <= right1){
            if(s.charAt(p1) == t.charAt(p2)){
                p2++;
                if(p2 > right2)
                    return true;
            }
            p1++;
        }

        return p2 > right2;
    }

}