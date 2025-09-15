// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

// Example 1:
// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.

// Example 2:
// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"
 
// Constraints:
// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of lowercase English letters.

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int R = str1.length(), C = str2.length();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int[][] dp = new int[R+1][C+1];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(s1[i] == s2[j])
                    dp[i+1][j+1] = dp[i][j] + 1;
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }

        StringBuilder sb = new StringBuilder();

        int r = R, c = C;

        while(r > 0 && c > 0){
            if(s1[r-1] == s2[c - 1]){
                sb.append(s1[r-1]);
                r--; c--;
            }
            else if(dp[r][c] == dp[r][c-1]){
                sb.append(s2[c-1]);
                c--;
            }
            else{
                sb.append(s1[r-1]);
                r--;
            }
        }

        while(r > 0){
            sb.append(s1[r-1]);
            r--;
        } 
        while(c > 0){
            sb.append(s2[c-1]);
            c--;
        }

        return sb.reverse().toString();
    }
}