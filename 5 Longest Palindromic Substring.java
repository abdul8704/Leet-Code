// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Example 2:
// Input: s = "cbbd"
// Output: "bb"
 
// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.

class Solution {
    public String longestPalindrome(String s) {
        int res = 0, N = s.length();
        String ans = "";

        for(int i=0; i<N; i++){
            String oddPalindrome = maxPalindrome(s, N, i, i, res);
            if(res < oddPalindrome.length()){
                res = oddPalindrome.length();
                ans = oddPalindrome;
            }


            String evenPalindrome = maxPalindrome(s, N, i, i+1, res);
            if(res < evenPalindrome.length()){
                res = evenPalindrome.length();
                ans = evenPalindrome;
            }
        }   

        return ans;
    }
    private static String maxPalindrome(String s, int N, int left, int right, int max){
        int res[] = new int[2];

        while(left >= 0 && right < N && s.charAt(left) == s.charAt(right)){
            if(right - left + 1 > max){
                max = right - left + 1;
                res[0] = left;
                res[1] = right;
            }
            
            left--;
            right++;
        }
        return s.substring(res[0], res[1]+1);    
    }
}

class AnotherSolution {
    public String longestPalindrome(String s) { // finding palindromes at each length from 1 to N;
        int N = s.length();

        boolean dp[][] = new boolean[N][N];

        for(int i=0; i<N; i++)
            dp[i][i] = true;

        int maxLen = 1;    
        int start = 0;

        for(int len = 2; len<=N; len++){
            for(int idx=0; idx<N; idx++){
                if(idx+len-1 < N && s.charAt(idx) == s.charAt(idx+len-1) && (len == 2 || dp[idx+1][idx+len-2])){
                    maxLen = len;
                    start = idx;
                    dp[idx][idx+len-1] = true;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}