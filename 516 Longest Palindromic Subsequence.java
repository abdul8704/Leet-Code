// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

// Example 2:
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".
 
// Constraints:
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.

class Solution { 
    public int longestPalindromeSubseq(String s) {
        char[] s1 = s.toCharArray();
        char[] s2 = new StringBuilder(s).reverse().toString().toCharArray();

        int N = s1.length;

        int[][] dp = new int[N+1][N+1];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(s1[i] == s2[j])
                    dp[i+1][j+1] = 1 + dp[i][j];
                else
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }

        StringBuilder sb = new StringBuilder(); // to print the longest palindromic subsequence
        int i = N, j = N;

        while (i > 0 && j >0){
            if(s1[i-1] == s2[j-1]){
                sb.append(s1[i-1]);
                i--; j--;
            }
            else if(dp[i][j] == dp[i-1][j])
                i--;
            else
                j--;
        }

        System.out.println(sb.reverse());

        return dp[N][N];
    }
}