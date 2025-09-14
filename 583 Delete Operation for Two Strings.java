// Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.

// Example 1:
// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

// Example 2:
// Input: word1 = "leetcode", word2 = "etco"
// Output: 4
 
// Constraints:
// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.

class Solution {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();;

        int N = s1.length, M = s2.length;

        int[][] dp = new int[N+1][M+1];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(s1[i] == s2[j])
                    dp[i+1][j+1] = 1 + dp[i][j];
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        // find longest common subsequence. this will give a string. this string is the longest string that can be obtained.
        // We just need to delete rest of the characters.

        return (N - dp[N][M]) + (M - dp[N][M]);
    }
}