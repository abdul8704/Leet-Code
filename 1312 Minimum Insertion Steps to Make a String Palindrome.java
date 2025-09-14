// Given a string s. In one step you can insert any character at any index of the string.
// Return the minimum number of steps to make s palindrome.
// A Palindrome String is one that reads the same backward as well as forward.

// Example 1:
// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we do not need any insertions.

// Example 2:
// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".

// Example 3:
// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 
// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.

class Solution {
    public int minInsertions(String s) {
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

        return N - dp[N][N]; // dp[N][N] is the lps. N-dp[N][N] characters are preventing from making the entire string a palindrome
                         // so add N-dp[N][N] to counter their imbalance.

    }
}